package ali_class.assignment9_10_interviewapp.entities;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AnswerEntity {
    @SerializedName("questionid")
    @Expose
    private int questionid;
    @SerializedName("answer")
    @Expose
    private String answer;

    public AnswerEntity() {
        super();
    }

    public AnswerEntity(int questionid, String answer) {
        this.questionid = questionid;
        this.answer = answer;
    }

    public int getQuestionid() {
        return questionid;
    }

    public void setQuestionid(int questionid) {
        this.questionid = questionid;
    }
    public String getAnswer() {
        return answer;
    }
    public void setAnswer(String answer) {
        this.answer = answer;
    }


}