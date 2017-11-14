package ali_class.assignment9_10_interviewapp.entities;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Question {

    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("optionA")
    @Expose
    private String optionA;
    @SerializedName("optionB")
    @Expose
    private String optionB;
    @SerializedName("optionC")
    @Expose
    private String optionC;
    @SerializedName("optionD")
    @Expose
    private String optionD;
    @SerializedName("difficultyLevel")
    @Expose
    private int difficultyLevel;
    @SerializedName("questionid")
    @Expose
    private int questionid;

    private String selectedOption = "S";

    public Question() {
    }

    public Question(String description, String optionA, String optionB, String optionC, String optionD, int difficultyLevel,
                    int questionid) {
        this.description = description;
        this.optionA = optionA;
        this.optionB = optionB;
        this.optionC = optionC;
        this.optionD = optionD;
        this.difficultyLevel = difficultyLevel;
        this.questionid = questionid;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public String getOptionA() {
        return optionA;
    }


    public void setOptionA(String optionA) {
        this.optionA = optionA;
    }


    public String getOptionB() {
        return optionB;
    }


    public void setOptionB(String optionB) {
        this.optionB = optionB;
    }


    public String getOptionC() {
        return optionC;
    }


    public void setOptionC(String optionC) {
        this.optionC = optionC;
    }


    public String getOptionD() {
        return optionD;
    }


    public void setOptionD(String optionD) {
        this.optionD = optionD;
    }


    public int getDifficultyLevel() {
        return difficultyLevel;
    }


    public void setDifficultyLevel(int difficultyLevel) {
        this.difficultyLevel = difficultyLevel;
    }


    public int getQuestionid() {
        return questionid;
    }


    public void setQuestionid(int questionid) {
        this.questionid = questionid;
    }

    public String getSelectedOption() {
        return selectedOption;
    }

    public void setSelectedOption(String selectedOption) {
        this.selectedOption = selectedOption;
    }
}