package ca.ciccc.madp202.maisaya.InterviewerBackend.models.entities;

public class Question {
	private int questionid;
	private String description;
	private String optionA;
	private String optionB;
	private String optionC;
	private String optionD;
	private String right_option;
	private int difficultyLevel;
	private Topic topic;
	
	
	public Question() {
	}

	public Question(int questionid, String description, String optionA, String optionB, String optionC, String optionD,
			String right_option, int difficultyLevel, Topic topic) {
		this.questionid = questionid;
		this.description = description;
		this.optionA = optionA;
		this.optionB = optionB;
		this.optionC = optionC;
		this.optionD = optionD;
		this.right_option = right_option;
		this.difficultyLevel = difficultyLevel;
		
		this.topic = topic;
	}

	public int getQuestionid() {
		return questionid;
	}
	public void setQuestionid(int questionid) {
		this.questionid = questionid;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getOptionA() {
		return optionA;
	}
	public void setOptionA(String optionA) {
		this.optionA = optionA;
	}
	public String getOptionB() {
		return optionB;
	}
	public void setOptionB(String optionB) {
		this.optionB = optionB;
	}
	public String getOptionC() {
		return optionC;
	}
	public void setOptionC(String optionC) {
		this.optionC = optionC;
	}
	public String getOptionD() {
		return optionD;
	}
	public void setOptionD(String optionD) {
		this.optionD = optionD;
	}
	public String getRight_option() {
		return right_option;
	}
	public void setRight_option(String right_option) {
		this.right_option = right_option;
	}
	public int getDifficultyLevel() {
		return difficultyLevel;
	}
	public void setDifficultyLevel(int difficultyLevel) {
		this.difficultyLevel = difficultyLevel;
	}
	public Topic getTopic() {
		return topic;
	}
	public void setTopic(Topic topic) {
		this.topic = topic;
	}
	

	

}
