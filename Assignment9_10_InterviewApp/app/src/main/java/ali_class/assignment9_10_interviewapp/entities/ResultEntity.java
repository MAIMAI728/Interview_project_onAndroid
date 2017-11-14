package ali_class.assignment9_10_interviewapp.entities;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.text.SimpleDateFormat;
import java.util.Locale;

public class ResultEntity {
    @SerializedName("interviewid")
    @Expose
    private int interviewid;
    @SerializedName("questions")
    @Expose
    private int questions;
    //questions = total
    @SerializedName("correctAnswer")
    @Expose
    private int correctAnswer;
    @SerializedName("wrongAnswer")
    @Expose
    private int wrongAnswer;
    @SerializedName("skippedAnswer")
    @Expose
    private int skippedAnswer;
    @SerializedName("topic")
    @Expose
    private Topic topic;
    @SerializedName("duration")
    @Expose
    private int duration;
    @SerializedName("score")
    @Expose
    private int score;
    @SerializedName("date")
    @Expose
    private long date;


    public ResultEntity() {
        // TODO Auto-generated constructor stub
    }

    public ResultEntity(int interviewid, int questions, int correctAnswer, int wrongAnswer,
                        int skippedAnswer, Topic topic, int duration, int score, long date) {
        this.interviewid = interviewid;
        this.questions = questions;
        this.correctAnswer = correctAnswer;
        this.wrongAnswer = wrongAnswer;
        this.skippedAnswer = skippedAnswer;
        this.topic = topic;
        this.duration = duration;
        this.score = score;
        this.date = date;
    }

    public String getDateAsFormatted() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd MMMM, yyyy", Locale.CANADA);
        return sdf.format(date);
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


    public int getCorrectAnswer() {
        return correctAnswer;
    }


    public void setCorrectAnswer(int correctAnswer) {
        this.correctAnswer = correctAnswer;
    }


    public int getWrongAnswer() {
        return wrongAnswer;
    }


    public void setWrongAnswer(int wrongAnswer) {
        this.wrongAnswer = wrongAnswer;
    }


    public int getSkippedAnswer() {
        return skippedAnswer;
    }


    public void setSkippedAnswer(int skippedAnswer) {
        this.skippedAnswer = skippedAnswer;
    }


    public Topic getTopic() {
        return topic;
    }


    public void setTopic(Topic topic) {
        this.topic = topic;
    }


    public int getDuration() {
        return duration;
    }


    public void setDuration(int duration) {
        this.duration = duration;
    }


    //★
    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }


    public long getDate() {
        return date;
    }


    public void setDate(long date) {
        this.date = date;
    }

}