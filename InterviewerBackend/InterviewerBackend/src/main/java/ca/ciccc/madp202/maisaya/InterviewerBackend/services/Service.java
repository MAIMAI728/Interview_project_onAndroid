package ca.ciccc.madp202.maisaya.InterviewerBackend.services;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import ca.ciccc.madp202.maisaya.InterviewerBackend.database.Database;
import ca.ciccc.madp202.maisaya.InterviewerBackend.models.entities.AnswerEntity;
import ca.ciccc.madp202.maisaya.InterviewerBackend.models.entities.HistoryEntity;
import ca.ciccc.madp202.maisaya.InterviewerBackend.models.entities.InterviewEntity;
import ca.ciccc.madp202.maisaya.InterviewerBackend.models.entities.ProfileEntity;
import ca.ciccc.madp202.maisaya.InterviewerBackend.models.entities.Question;
import ca.ciccc.madp202.maisaya.InterviewerBackend.models.entities.Topic;
import ca.ciccc.madp202.maisaya.InterviewerBackend.models.entities.UserEntity;
import ca.ciccc.madp202.maisaya.InterviewerBackend.models.requestModels.AnswerCollectionRequestModel;
import ca.ciccc.madp202.maisaya.InterviewerBackend.models.requestModels.CredentialRequestModel;
import ca.ciccc.madp202.maisaya.InterviewerBackend.models.requestModels.UserRequestModel;
import ca.ciccc.madp202.maisaya.InterviewerBackend.models.responseModels.AnswerCollectionResponseModel;

public class Service {
	
	//POST(登録する時)
	public ProfileEntity addUser(UserRequestModel request) {
		String token = generateAuthToken(request.getUsername());
		//request /* データを取得 */
	    UserEntity ue = new UserEntity(request.getFirstName(),request.getLastName(),request.getCountry(),request.getUsername(),request.getPassword());
	    int userId = Database.getInstance().getProfileEntitys().size() + 1;
	    ProfileEntity pe = new ProfileEntity(token,userId,new Date(),ue);
	    Database.getInstance().saveProfileEntity(pe);
	    return pe;
	}
	
	//POST(ログインする時)
	public Response loginUser(CredentialRequestModel request) {
		ProfileEntity pe = Database.getInstance().getProfileEntity(request.getUsername());
		if(pe == null) {
			return Response.status(Status.BAD_REQUEST).entity("you don't have your account").build();
		}
		else if(request.getPassword().equals(pe.getUserProfile().getPassword())) {
			/* データを取得 */
			return Response.status(Status.OK).entity(pe).build();
		}
		else {
			return Response.status(Status.BAD_REQUEST).entity("Wrong password").build();
		}
	}
	public static String generateAuthToken(String value) {
	    @SuppressWarnings("deprecation")
	    String token = UUID.randomUUID().toString().toUpperCase() + value + new Date().getSeconds();
	    return token;
	}

		
	//GET(インタビューのトピックからquestionを取得)
	public InterviewEntity getInterview(Topic topic) {
		/* データを取得 */
		InterviewEntity ie = Database.getInstance().getInterview(topic);
		System.out.println("get interview");
		return ie;
	}
		
	//POST(Resultを格納)
	public AnswerCollectionResponseModel submitAnswer(int interviewid, AnswerCollectionRequestModel request) {
		//AnswerEntityはqidとanswerのみ持っている
		//AnswerCollectionEntityはuseridとqidとanswersを持っている
		/* データを取得 */
		ArrayList<AnswerEntity> answers = request.getAnswers();
 		Integer skipped = 0;
 		Integer correct = 0;
 		Integer wrong = 0;
 		for(Integer i = 0; i<answers.size();i++) {
 			//回答した答え(a,b,c,d)
 			String option = answers.get(i).getAnswer();
 			//回答した問題の番号
 			Integer questionId = answers.get(i).getQuestionid();
 			//正解した答え(HashMapを使ってquestionidとanswers(String)を照合し導き出す)
 			Question question = Database.getInstance().getQuestion(questionId);
 			if(option.equalsIgnoreCase("S")) {
 				skipped++;
 			}
 			else if(question.getRight_option().equalsIgnoreCase(option)) {
 				correct++;
 			}
 			else {
 				wrong++;
 			}
 		}
 		Integer score = ((correct*100)/answers.size());
 		Integer questionid = answers.size();
 		Integer duration = 0;
		AnswerCollectionResponseModel acrm = new AnswerCollectionResponseModel(request.getInterviewid(),questionid, correct, wrong, skipped,Topic.getTopicById(interviewid), duration, score,new Date());
		System.out.println("submitAnswer Service");
		HistoryEntity hEntity = new HistoryEntity(Topic.getTopicById(interviewid),new Date(),score,correct,request.getUserid());
		Database.getInstance().saveHistory(hEntity);
		System.out.println("saved history" + hEntity.getScore());
		return acrm;
	}
	//GET(ユーザIDからhistoryを取得)
	public List<HistoryEntity> getHistory(int userID) {
		/* データを取得 */
		List<HistoryEntity> historylist = Database.getInstance().getHistories(userID);
		return historylist;
	}

}