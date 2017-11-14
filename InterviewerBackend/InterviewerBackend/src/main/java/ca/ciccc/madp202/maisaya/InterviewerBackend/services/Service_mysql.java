package ca.ciccc.madp202.maisaya.InterviewerBackend.services;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

import ca.ciccc.madp202.maisaya.InterviewerBackend.database.MySQLConnector;
import ca.ciccc.madp202.maisaya.InterviewerBackend.models.entities.AnswerCollectionEntity;
import ca.ciccc.madp202.maisaya.InterviewerBackend.models.entities.InterviewEntity;
import ca.ciccc.madp202.maisaya.InterviewerBackend.models.entities.ProfileEntity;
import ca.ciccc.madp202.maisaya.InterviewerBackend.models.entities.Question;
import ca.ciccc.madp202.maisaya.InterviewerBackend.models.entities.ResultEntity;
import ca.ciccc.madp202.maisaya.InterviewerBackend.models.entities.Topic;
import ca.ciccc.madp202.maisaya.InterviewerBackend.models.entities.UserEntity;
import ca.ciccc.madp202.maisaya.InterviewerBackend.models.requestModels.CredentialRequestModel;
import ca.ciccc.madp202.maisaya.InterviewerBackend.models.requestModels.InterviewSelectionRequestModel;
import ca.ciccc.madp202.maisaya.InterviewerBackend.models.requestModels.UserRequestModel;

//public class Service_mysql {
//	
//	//POST(登録する時)
//	public ProfileEntity addUser(UserRequestModel request) {
//		String token = generateAuthToken(request.getUsername());
//		String timestamp = getCurrentLocalDateStamp();
//		//request /* データを取得 */
//		String firstName = request.getFirstName();
//		String lastName = request.getLastName();
//		String country = request.getCountry();
//		String username = request.getUsername();
//		String password = request.getPassword();
//		MySQLConnector.insertUser("insert into user (first_name,last_name,country,username,password,joined,authtoken) values ('"+firstName+"','"+lastName+"','"+country+"','"+username+"','"+password+"','"+timestamp+"','"+token.substring(0, 40)+"')");	
//	    UserEntity ue = new UserEntity(firstName,lastName,country,username,password);
//	    ArrayList<String> data = new ArrayList<>();
//	    data = MySQLConnector.connectUser("SELECT * FROM user where username="
//				+ "'"+username+"' and password='"+password+"'");
//	    Integer userId = Integer.parseInt(data.get(0));
//	    ProfileEntity pe = new ProfileEntity(token,userId,new Date(),ue);
//	    return pe;
//	}
//	
//	
//	//POST(ログインする時)
//	public ProfileEntity loginUser(CredentialRequestModel request) {
//		ArrayList<String> data = new ArrayList<>();
//		data = MySQLConnector.connectUser("SELECT * FROM user where username="+ "'"+request.getUsername()+"' and password='"+request.getPassword()+"'");
//		/* データを取得 */
//		String authtoken = "got your userdata"; 
//    		int userid= 0;
//    		Date joined = new Date();
//    		UserEntity userProfile = new UserEntity(data.get(0),data.get(1),data.get(2),data.get(3),data.get(4));
//    		ProfileEntity pe = new ProfileEntity(authtoken,userid,joined,userProfile);
//        return pe;
//	}
//	public static String generateAuthToken(String value) {
//	    @SuppressWarnings("deprecation")
//	    String token = UUID.randomUUID().toString().toUpperCase() + value + new Date().getSeconds();
//	    return token;
//	}
//	public static String getCurrentLocalDateStamp() {
//        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
//    }
//		
//	//GET(インタビューの種類からquestionを取得)
//	public InterviewEntity getInterview(Topic topic) {
//		ArrayList<String[]> data = new ArrayList<>();
//		data = MySQLConnector.getQuestion("SELECT * FROM question where topic="+"'"+topic+"' order by RAND()");
//		
//		/* データを取得 */		
//		
//		System.out.println("get interview 1");
//		
//		Integer totalq = data.size();
//		//all things of question table
//		Question q[] = new Question[totalq];
//		for(Integer i=0;i<totalq;i++) {
//			String[] questionRow = data.get(i);
//			
//			int questionid = Integer.parseInt(questionRow[0].toString());
//			String description = questionRow[1].toString();
//			String optionA = questionRow[2].toString();
//			String optionB = questionRow[3].toString();
//			String optionC = questionRow[4].toString();
//			String optionD = questionRow[5].toString();
//			String right_option = questionRow[6].toString();
//			int difficultyLevel = Integer.parseInt(questionRow[7].toString());
//			
//			Question question = new Question(questionid,description,optionA,optionB,optionC,optionD,right_option,difficultyLevel,topic);
//			q[i] = question;
//		}
//		
//		System.out.println("get interview 2");
//		
//		int duration = 20;
//		InterviewEntity ie = new InterviewEntity(1,q.length,duration,topic,q);
//		System.out.println("get interview 3");
//		return ie;
//	}
//	
//	//POST(Resultを格納)
////	public ResultEntity submitAnswer(AnswerCollectionEntity request) {
////		
////		int historyid;
////		int userid;
////		int score;
////		String date = getCurrentLocalDateStamp();
////		Topic topic;
////		
////		String token = generateAuthToken(request.getUsername());
////		
////		//request /* データを取得 */
////		int interviewid = request.getInterviewid();
////		int 
////		MySQLConnector.insertUser("insert into user (first_name,last_name,country,username,password,joined,authtoken) values ('"+firstName+"','"+lastName+"','"+country+"','"+username+"','"+password+"','"+timestamp+"','"+token.substring(0, 40)+"')");	
////	    UserEntity ue = new UserEntity(firstName,lastName,country,username,password);
////	    ArrayList<String> data = new ArrayList<>();
////	    data = MySQLConnector.connectUser("SELECT * FROM user where username="
////				+ "'"+username+"' and password='"+password+"'");
////	    Integer userId = Integer.parseInt(data.get(0));
////	    ProfileEntity pe = new ProfileEntity(token,userId,new Date(),ue);
////	    return pe;
////		
////	}
//	public static class Timeformat{
//		public static String getCurrentLocalDateStamp() {
//		    return LocalDateTime.now()
//		       .format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
//		}
//	}
//}




