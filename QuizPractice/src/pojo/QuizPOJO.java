package pojo;

import java.time.LocalDate;
import java.util.List;

public class QuizPOJO {
private String authorName;
private String programName;
private LocalDate datePublished;
private List<QuestionPOJO> questions;

public String getAuthorName() {
		return authorName;
	}
	
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	
	public String getProgramName() {
		return programName;
	}
	
	public void setProgramName(String programName) {
		this.programName = programName;
	}
	
	public LocalDate getDatePublished() {
		return datePublished;
	}
	
	public void setDatePublished(LocalDate datePublished) {
		this.datePublished = datePublished;
	}
	

	public List <QuestionPOJO> getQuestions() {
		return questions;
	}
	

	public void setQuestions(List <QuestionPOJO> questions) {
		this.questions = questions;
	}
	
	
	





}//end QuizPOJO class
