package ali_class.assignment9_10_interviewapp.entities;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.Iterator;

public class InterviewEntity implements Iterable<Question> {

    @SerializedName("interviewid")
    @Expose
    private int interviewid;
    @SerializedName("questions")
    @Expose
    private int questions;
    @SerializedName("duration")
    @Expose
    private int duration;
    @SerializedName("topic")
    @Expose
    private Topic topic;
    @SerializedName("interviewQuestions")
    @Expose
    private ArrayList<Question> interviewQuestions;


    public InterviewEntity() {
    }

    public InterviewEntity(int interviewid, int questions, int duration, Topic topic, ArrayList<Question> interviewQuestions) {
        this.interviewid = interviewid;
        this.questions = questions;
        this.duration = duration;
        this.topic = topic;
        this.interviewQuestions = interviewQuestions;
    }

    public int getInterviewid() {
        return interviewid;
    }
    public void setInterviewid(int interviewid) {
        this.interviewid = interviewid;
    }
    public int getQuestions() {
        return questions;
    }
    public void setQuestions(int questions) {
        this.questions = questions;
    }
    public int getDuration() {
        return duration;
    }
    public void setDuration(int duration) {
        this.duration = duration;
    }
    public Topic getTopic() {
        return topic;
    }
    public void setTopic(Topic topic) {
        this.topic = topic;
    }
    public ArrayList<Question> getInterviewQuestions() {
        return interviewQuestions;
    }
    public void setInterviewQuestions(ArrayList<Question> interviewQuestions) {
        this.interviewQuestions = interviewQuestions;
    }

    @Override
    public Iterator<Question> iterator() {
        return new QuestionIterator(interviewQuestions.toArray(new Question[interviewQuestions.size()]));
    }

}
