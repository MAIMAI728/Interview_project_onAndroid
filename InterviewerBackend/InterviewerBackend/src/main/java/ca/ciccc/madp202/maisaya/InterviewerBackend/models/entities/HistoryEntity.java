package ca.ciccc.madp202.maisaya.InterviewerBackend.models.entities;

import java.io.Serializable;
import java.util.Date;

public class HistoryEntity implements Serializable{
	private Topic topic;
	//topic = type
	private Date date;
	private int score;
	private int correct;
	private int userid;
	
	
	public HistoryEntity() {
	}

	public HistoryEntity(Topic topic, Date date, int score, int correct, int userid) {
		this.topic = topic;
		this.date = date;
		this.score = score;
		this.correct = correct;
		this.userid = userid;
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


	public int getCorrect() {
		return correct;
	}


	public void setCorrect(int correct) {
		this.correct = correct;
	}


	public int getUserid() {
		return userid;
	}


	public void setUserid(int userid) {
		this.userid = userid;
	}

	
	
}
