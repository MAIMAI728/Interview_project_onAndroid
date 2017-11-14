package ca.ciccc.madp202.maisaya.InterviewerBackend.models.entities;
import java.util.ArrayList;

public class AnswerCollectionEntity {
//	AnswerCollectionEntity では HashMap<questionidとAnswer>とinterviewIDとuserIDを持っている
	//integerはクイズのidのこと、AnswerEntityは答えた問題
	private int interviewid;
	private int userid;
	ArrayList<AnswerEntity> answers = new ArrayList<>();
	
	
	public AnswerCollectionEntity() {
	}

	
	
	public AnswerCollectionEntity(int interviewid, int userid,
			ArrayList<ca.ciccc.madp202.maisaya.InterviewerBackend.models.entities.AnswerEntity> answers) {
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
