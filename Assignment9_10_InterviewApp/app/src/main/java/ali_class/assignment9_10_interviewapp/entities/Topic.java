package ali_class.assignment9_10_interviewapp.entities;



import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public enum Topic {

    @SerializedName("1")
    @Expose
    JAVA(1),
    @SerializedName("2")
    @Expose
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
}
