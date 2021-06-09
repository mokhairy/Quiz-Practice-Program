package jsonparsing;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

public class Json {
	private static ObjectMapper objectMapper = getDefaultObjectMapper();
	
	//@SuppressWarnings("unused")
	private static ObjectMapper getDefaultObjectMapper() {
		ObjectMapper defaultObjectMapper = new ObjectMapper();
		defaultObjectMapper.registerModule(new JavaTimeModule());
		defaultObjectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		return defaultObjectMapper;
	}
	
	public static JsonNode parse(String src) throws JsonMappingException, JsonProcessingException {	return objectMapper.readTree(src);	}
	
	public static JsonNode parseFile(File src) throws JsonProcessingException, IOException {
		return objectMapper.readTree(src);
		
	}
	
	public static <A> A fromJson(JsonNode node, Class<A> clazz) throws JsonProcessingException, IllegalArgumentException {
		return objectMapper.treeToValue(node, clazz);
	}
	
	public static JsonNode toJson(Object a) {
		return objectMapper.valueToTree(a);
	}
	
	public static String stringify(JsonNode node) throws JsonProcessingException {	return generateString(node,false);	}
	
	public static String prettyPrint(JsonNode node) throws JsonProcessingException {	return generateString(node,true);	}
	
	private static String generateString(JsonNode node, boolean pretty) throws JsonProcessingException {
		ObjectWriter writer = objectMapper.writer();
		if(pretty) {
			writer = writer.with(SerializationFeature.INDENT_OUTPUT);
		}
		
		return writer.writeValueAsString(node);
	}
	
}// end class
