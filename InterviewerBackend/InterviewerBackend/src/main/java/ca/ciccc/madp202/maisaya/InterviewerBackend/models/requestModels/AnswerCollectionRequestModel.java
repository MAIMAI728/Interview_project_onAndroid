package ca.ciccc.madp202.maisaya.InterviewerBackend.models.requestModels;

import java.util.ArrayList;
import java.util.HashMap;

import ca.ciccc.madp202.maisaya.InterviewerBackend.models.entities.AnswerEntity;

public class AnswerCollectionRequestModel {
	private int interviewid;
	private int userid;
	private ArrayList<AnswerEntity> answers = new ArrayList<>();
	
	public AnswerCollectionRequestModel() {
			
	}

	public AnswerCollectionRequestModel(int interviewid, int userid, ArrayList<AnswerEntity> answers) {
		super();
		this.interviewid = interviewid;
		this.userid = userid;
		this.answers = answers;
	}

	public int getInterviewid() {
		return interviewid;
	}

	public void setInterviewid(int interviewid) {
		this.interviewid = interviewid;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public ArrayList<AnswerEntity> getAnswers() {
		return answers;
	}

	public void setAnswers(ArrayList<AnswerEntity> answers) {
		this.answers = answers;
	}
	
	
	
}
