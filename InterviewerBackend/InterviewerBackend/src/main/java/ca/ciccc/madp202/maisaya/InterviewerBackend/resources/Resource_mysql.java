package ca.ciccc.madp202.maisaya.InterviewerBackend.resources;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import ca.ciccc.madp202.maisaya.InterviewerBackend.database.MySQLConnector;
import ca.ciccc.madp202.maisaya.InterviewerBackend.models.entities.AnswerEntity;
import ca.ciccc.madp202.maisaya.InterviewerBackend.models.entities.InterviewEntity;
import ca.ciccc.madp202.maisaya.InterviewerBackend.models.entities.ProfileEntity;
import ca.ciccc.madp202.maisaya.InterviewerBackend.models.entities.Question;
import ca.ciccc.madp202.maisaya.InterviewerBackend.models.entities.Topic;
import ca.ciccc.madp202.maisaya.InterviewerBackend.models.requestModels.AnswerCollectionRequestModel;
import ca.ciccc.madp202.maisaya.InterviewerBackend.models.requestModels.CredentialRequestModel;
import ca.ciccc.madp202.maisaya.InterviewerBackend.models.requestModels.InterviewSelectionRequestModel;
import ca.ciccc.madp202.maisaya.InterviewerBackend.models.requestModels.UserRequestModel;
import ca.ciccc.madp202.maisaya.InterviewerBackend.models.responseModels.AnswerCollectionResponseModel;
import ca.ciccc.madp202.maisaya.InterviewerBackend.models.responseModels.CredentialResponseModel;
import ca.ciccc.madp202.maisaya.InterviewerBackend.models.responseModels.UserResponseModel;
import ca.ciccc.madp202.maisaya.InterviewerBackend.services.Service;

//@Path("interview")
//public class Resource_mysql {
//	
//	public static HashMap<Integer, String> tabAnswers = new HashMap<>();
//	public static Topic yourtopic;
//	
//	Service service = new Service();
//	public String getIt() {
//        return "Got it!";
//    }
//	
//	Calendar calendar = Calendar.getInstance();
//	Timestamp timestamp = new Timestamp(calendar.getTime().getTime());
//	
//	@POST
//	@Path("/users")
//	@Produces(MediaType.APPLICATION_JSON)
//	public ProfileEntity getStatusCode(UserRequestModel request) {
//		ProfileEntity pe = service.addUser(request);
//		return pe;
////		return new ProfileEntity("Registered token", 3, null, null);
//	}
//	
//    @POST
//    @Produces(MediaType.APPLICATION_JSON)
//	@Path("/login")
//    public ProfileEntity getStatusCode(CredentialRequestModel request) {
//		System.out.println("got login connection: " + request.getUsername() + request.getPassword());
//		ProfileEntity pe = service.loginUser(request);
//		return pe;
//    }
//    
//    @GET
//    @Produces(MediaType.APPLICATION_JSON)
//    @Path("/topics/{topicname}")
//    public InterviewEntity getStatusCode(@PathParam("topicname")Topic topic) {
//    		System.out.println("topics " + topic.name().toString());
//    		InterviewEntity ie = service.getInterview(topic);
//    		System.out.println("print");
//    		return ie;
//    }
//    
//    @POST
//    @Produces(MediaType.APPLICATION_JSON)
//    public AnswerCollectionResponseModel submitAnswers(AnswerCollectionRequestModel acrm) {
////    	 System.out.println("Got result"+acrm.getUserid());
//    	 	ArrayList<AnswerEntity> answers = new ArrayList<>();
// 		answers = acrm.getAnswers();
// 		Integer skipped = 0;
// 		Integer correct = 0;
// 		Integer wrong = 0;
// 		
// 		for(Integer i = 0; i<answers.size();i++) {	
// 			//回答した答え(a,b,c,d)
// 			String option = answers.get(i).getAnswer();
// 			//回答した問題の番号
// 			Integer questionId = answers.get(i).getQuestionid();
// 			//正解した答え(HashMapを使ってquestionidとanswers(String)を照合し導き出す)
// 			String rightOption = tabAnswers.get(questionId);
// 			if(option == "S") {
// 				skipped++;
// 			}
// 			else if(option==rightOption&&(option!="S")) {
// 				correct++;
// 			}
// 			else if(option!=rightOption&&(option!="S")) {
// 				wrong++;
// 			}
// 		}
// 		
// 		Integer totalQuestions = correct+wrong+skipped;
// 		Integer score = ((correct*100)/totalQuestions);
// 		
// 		// insert into the database
// 		ArrayList<String> parameters = new ArrayList<>();
// 		parameters.add(yourtopic.toString());
// 		parameters.add(Timeformat.getCurrentLocalDateStamp());
// 		parameters.add(correct.toString());
// 		parameters.add(totalQuestions.toString());
// 		parameters.add(Integer.toString(acrm.getUserid()));
//// 		try {
//// 			MySQLConnector.insertUser(parameters);
//// 		} catch (SQLException e) {
//// 			e.printStackTrace();
//// 		}
//// 		
//// 		return new AnswerCollectionResponseModel(aRequestModel.getInterviewId(), aRequestModel.getUserId(), new Date(), score, totalQuestions, correct, wrong, skipped);
// 		return null;
//    		
//    }
//}


