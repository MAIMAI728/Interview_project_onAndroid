package ca.ciccc.madp202.maisaya.InterviewerBackend.database;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonSubTypes.Type;

import ca.ciccc.madp202.maisaya.InterviewerBackend.models.entities.HistoryEntity;
import ca.ciccc.madp202.maisaya.InterviewerBackend.models.entities.InterviewEntity;
import ca.ciccc.madp202.maisaya.InterviewerBackend.models.entities.ProfileEntity;
import ca.ciccc.madp202.maisaya.InterviewerBackend.models.entities.Question;
import ca.ciccc.madp202.maisaya.InterviewerBackend.models.entities.Topic;

public class Database {
    private static final String FILE_PROFILES = "file_profiles";
    private static final String FILE_HISTORIES = "file_histories";

    private static Database instance = new Database();

    private List<ProfileEntity> profiles;
    private List<InterviewEntity> interviews;
    private List<HistoryEntity> histories;
    

    private Database() {
        profiles = deserialize(FILE_PROFILES);
        interviews = createInterviews();
        histories = deserialize(FILE_HISTORIES);
    }

    public static Database getInstance() {
        return instance;
    }


    /* ________________________
     * PROFILE
     * ________________________ */
    public List<ProfileEntity> getProfileEntitys() {
        return profiles;
    }

    public ProfileEntity getProfileEntity(String username) {
        for (ProfileEntity p : profiles) {
            if (p.getUserProfile().getUsername().equals(username)) return p;
        }
        return null;
    }

    public void saveProfileEntity(ProfileEntity profile) {
        profiles.add(profile);
        serialize(profiles, FILE_PROFILES);
    }

    /* ________________________
     * INTERVIEW
     * ________________________ */
    //インタビューを呼び出し("interviews"がcreateInterviews()を呼び出してる)
    public InterviewEntity getInterview(Topic topic) {
        for (InterviewEntity ie : interviews) {
            if (ie.getTopic() == topic)
            	return ie;
        }
        return null;
    }

    //答え合わせ
    public Question getQuestion(int questionId) {
        for (InterviewEntity ie : interviews) {
            for (Question q : ie.getInterviewQuestions()) {
                if(q.getQuestionid() == questionId) return q;
            }
        }
        return null;
    }

    private List<InterviewEntity> createInterviews() {
        if (interviews == null) interviews = new ArrayList<>();
        
        Question[] javaQuestions = {
        		new Question(11,"What is process of defining two or more methods within same class that have same name but different parameters declaration?","overloading","overriding","hiding","none","A", 1,Topic.JAVA),
	        new Question(12,"Which of these access specifiers must be used for main() method?","private","public","protected","none","B", 3,Topic.JAVA),
	        new Question(13,"What is the process by which we can control what parts of a program can access the members of a classes?","Polymorphism","Abstraction","Encapsulation","Recursion","C", 4,Topic.JAVA),
	        new Question(14,"Which of these methods must be made static?","main()","delete()","run()","finalize()","A", 2,Topic.JAVA),
	        new Question(15,"Which of these keywords is used by a class to use an interface defined previously?","import","Import","implements","Implements","C", 5,Topic.JAVA),
	        
	        };
        interviews.add(new InterviewEntity(Topic.JAVA.id, javaQuestions.length, 5, Topic.JAVA, javaQuestions));
        
        Question[] sqlQuestions = {	
	        new Question(21,"Which SQL statement is used to extract data from a database?","OPEN","GET","EXTRACT","SELECT","C", 1,Topic.SQL),
	        new Question(22,"Which SQL statement is used to update data in a database?","UPDATE","SAVE","MODIFY","SAVE AS","A", 2,Topic.SQL),
	        new Question(23,"Which SQL statement is used to delete data from a database?","DELETE","COLLAPSE","REMOVE","KILL","A", 4,Topic.SQL),
	        new Question(24,"Which SQL statement is used to insert new data in a database?","INSTANT NEW","ADD RECORD","INSERT INTO","ADD NEW","C", 3,Topic.SQL),
	        new Question(25,"Which SQL keyword is used to sort the result-set?","SORT BY","SORT","ORDER BY","ORDER","D", 5,Topic.SQL)
	        };
        interviews.add(new InterviewEntity(Topic.SQL.id, sqlQuestions.length, 5, Topic.SQL, sqlQuestions));

        return interviews;
    }


    /* ________________________
     * HISTORY
     * ________________________ */
    public List<HistoryEntity> getHistories(Integer userid) {
        List<HistoryEntity> list = new ArrayList<>();
        for (HistoryEntity h : histories) {
            if (h.getUserid() == userid) list.add(h);
        }
        return list;
    }

    public void saveHistory(HistoryEntity history) {
        histories.add(history);
        serialize(histories, FILE_HISTORIES);
    }


    /* ========================
     * SERIALIZE / DESERIALIZE
     * ======================== */
    private static <T> void serialize(T t, String fileName) {
        try (FileOutputStream fileOutput = new FileOutputStream(fileName);
             ObjectOutputStream os = new ObjectOutputStream(fileOutput)) {
            os.writeObject(t);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static <R> R deserialize(String fileName) {
        R r = null;
        if (!new File(fileName).exists()) {
            serialize(new ArrayList<>(), fileName);
        }

        try (FileInputStream fileInput = new FileInputStream(fileName);
             ObjectInputStream objInput = new ObjectInputStream(fileInput)) {
            r = (R) (objInput.readObject());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return r;
    }

}