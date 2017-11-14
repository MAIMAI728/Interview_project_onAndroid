package ca.ciccc.madp202.maisaya.InterviewerBackend.models.responseModels;

import java.util.Date;

import ca.ciccc.madp202.maisaya.InterviewerBackend.models.entities.Topic;

public class HistoryResponseModel {
	private Topic topic;
	//topic = type
	private Date date;
	private int score;
	
	
	public HistoryResponseModel() {
	}


	public HistoryResponseModel(Topic topic, Date date, int score) {
		this.topic = topic;
		this.date = date;
		this.score = score;
	}


	public Topic getTopic() {
		return topic;
	}


	public void setTopic(Topic topic) {
		this.topic = topic;
	}


	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}


	public int getScore() {
		return score;
	}


	public void setScore(int score) {
		this.score = score;
	}

}
