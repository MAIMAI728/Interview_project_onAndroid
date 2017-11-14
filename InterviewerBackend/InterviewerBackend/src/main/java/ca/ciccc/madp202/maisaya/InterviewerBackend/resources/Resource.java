package ca.ciccc.madp202.maisaya.InterviewerBackend.resources;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


import ca.ciccc.madp202.maisaya.InterviewerBackend.models.entities.HistoryEntity;
import ca.ciccc.madp202.maisaya.InterviewerBackend.models.entities.InterviewEntity;
import ca.ciccc.madp202.maisaya.InterviewerBackend.models.entities.ProfileEntity;
import ca.ciccc.madp202.maisaya.InterviewerBackend.models.entities.Topic;
import ca.ciccc.madp202.maisaya.InterviewerBackend.models.requestModels.AnswerCollectionRequestModel;
import ca.ciccc.madp202.maisaya.InterviewerBackend.models.requestModels.CredentialRequestModel;
import ca.ciccc.madp202.maisaya.InterviewerBackend.models.requestModels.UserRequestModel;
import ca.ciccc.madp202.maisaya.InterviewerBackend.models.responseModels.AnswerCollectionResponseModel;
import ca.ciccc.madp202.maisaya.InterviewerBackend.services.Service;

@Path("interview")
public class Resource {
	
	public static HashMap<Integer, String> tabAnswers = new HashMap<>();
	
	Service service = new Service();
	public String getIt() {
        return "Got it!";
    }
	
	Calendar calendar = Calendar.getInstance();
	Timestamp timestamp = new Timestamp(calendar.getTime().getTime());
	
	@POST
	@Path("/users")
	@Produces(MediaType.APPLICATION_JSON)
	public ProfileEntity getStatusCode(UserRequestModel request) {
		ProfileEntity pe = service.addUser(request);
		return pe;
//		return new ProfileEntity("Registered token", 3, null, null);
	}
	
    @POST
    @Produces(MediaType.APPLICATION_JSON)
	@Path("/login")
    public Response getStatusCode(CredentialRequestModel request) {
		System.out.println("got login connection: " + request.getUsername() + " " + request.getPassword());
		Response response = service.loginUser(request);
		return response;
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/topics/{topicname}")
    public InterviewEntity getStatusCode(@PathParam("topicname")Topic topic) {
    		System.out.println("topics " + topic.name().toString());
    		InterviewEntity ie = service.getInterview(topic);
    		System.out.println("print");
    		return ie;
    }
    
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/interview/{interview_id}")
    public AnswerCollectionResponseModel submitAnswers(@PathParam("interview_id")int interviewid, AnswerCollectionRequestModel acrm) {
    	 	System.out.println("Got result"+acrm.getAnswers());
    	 	Topic.getTopicById(interviewid);
    	 	AnswerCollectionResponseModel result = service.submitAnswer(interviewid,acrm);
    	 	System.out.println("after submitAnswer Service");
 		return result;
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/history/user/{user_id}")
    public List<HistoryEntity> history(@PathParam("user_id")int userid) {
    		System.out.println("get history"+userid);
    		List<HistoryEntity> he = service.getHistory(userid);
    		System.out.println("show history"+he.size());
    		return he;
    }
}
