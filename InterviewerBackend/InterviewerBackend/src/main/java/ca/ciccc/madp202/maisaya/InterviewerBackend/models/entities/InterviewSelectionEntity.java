package ca.ciccc.madp202.maisaya.InterviewerBackend.models.entities;

public class InterviewSelectionEntity {
	private Topic topic;
	
	public InterviewSelectionEntity() {
	}
	
	public InterviewSelectionEntity(Topic topic) {
		this.topic = topic;
	}

	public Topic getTopic() {
		return topic;
	}

	public void setTopic(Topic topic) {
		this.topic = topic;
	}
}
