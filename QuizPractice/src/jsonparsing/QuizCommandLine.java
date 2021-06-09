package jsonparsing;


import java.io.File;
import java.io.IOException;
import java.util.Scanner;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;

import pojo.QuizPOJO;
import pojo.QuestionPOJO;

@SuppressWarnings("unused")
class QuizCommandLine {

	public static void main(String[] args) throws IllegalArgumentException, IOException {
		// Creation of objects needed to excecute the program
		Scanner scnr = new Scanner(System.in);
		System.out.println("Please paste the absolute path to your JSON Quiz!");
		String filePath = scnr.nextLine();
		File quizFile = new File(filePath);
		JsonNode node = Json.parseFile(quizFile);
		QuizPOJO pojo = Json.fromJson(node, QuizPOJO.class);
		char userChoice;
		
		// Initial heading upon program start
		System.out.println("Program: " + pojo.getProgramName());
		System.out.println("Author: " + pojo.getAuthorName());
		System.out.println("Date Published: " + pojo.getDatePublished());
		System.out.println("---------------------------------------------------------------------------------------------------------------------------------------\n");
		
		// Enhanced for loop that loops through every question in the file specified
		for(QuestionPOJO question:pojo.getQuestions()) {
			System.out.println("Question: " + question.getQuestion());
			if(question.getAnswer1() != null) {
				System.out.println("A: " + question.getAnswer1());
			}
			if(question.getAnswer2() != null) {
				System.out.println("B: " + question.getAnswer2());
			}
			if(question.getAnswer3() != null) {
				System.out.println("C: " + question.getAnswer3());
			}
			if(question.getAnswer4() != null) {
				System.out.println("D: " + question.getAnswer4());
			}
			
			// Get the user answer as a single character.
			// Only a/A b/B c/C or d/D are valid
			System.out.print("Enter your answer: ");
			userChoice = scnr.next().charAt(0);
			System.out.println();
			
			if(Character.toUpperCase(userChoice) == question.getCorrect().charAt(0)) {
				System.out.println("CORRECT! Answer is: " + question.getCorrect());
			}
			else{
				System.out.println("WRONG! Answer is: " + question.getCorrect());
			}
			
			System.out.println("\n");
			userChoice = 0;
		
		scnr.close();
	}//end main
}//end class
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}//end class
