package ca.ciccc.madp202.maisaya.InterviewerBackend.models.entities;
public enum Topic{
	JAVA(1),
	SQL(2);
	
	public int id;
	
	Topic(int id){
		this.id=id;
	}
	
	public static Topic getTopicById(int id) {
		for(Topic topic : values()) {
			if(topic.id == id) return topic;
		}
		return null;
	}
	
//	TYPE1("JAVA"),
//	TYPE2("SQL");
//	private final String topic;
//    private Topic(final String topic) {
//        this.topic = topic;
//    }
//
//    public String getString() {
//        return this.topic;
//    }
}
