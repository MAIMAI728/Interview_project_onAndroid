package ali_class.assignment9_10_interviewapp.entities;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TopicSelectEntity {
    @SerializedName("topic")
    @Expose
    private Topic topic;

    public TopicSelectEntity (Topic topic) {
        this.topic = topic;
    }

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }
}
