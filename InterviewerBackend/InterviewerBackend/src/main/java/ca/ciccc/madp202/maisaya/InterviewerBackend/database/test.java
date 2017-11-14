package ca.ciccc.madp202.maisaya.InterviewerBackend.database;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

import ca.ciccc.madp202.maisaya.InterviewerBackend.models.entities.InterviewEntity;
import ca.ciccc.madp202.maisaya.InterviewerBackend.models.entities.ProfileEntity;
import ca.ciccc.madp202.maisaya.InterviewerBackend.models.entities.Question;
import ca.ciccc.madp202.maisaya.InterviewerBackend.models.entities.Topic;
import ca.ciccc.madp202.maisaya.InterviewerBackend.models.entities.UserEntity;

//public class test {
//	public static void main(String args[]) {
//			ArrayList<String[]> data = new ArrayList<>();
//			data = MySQLConnector.getQuestion("SELECT * FROM question where topic="+"'"+"JAVA"+"' order by RAND()");
//			
//			/* データを取得 */		
//			
//			System.out.println("get interview 1");
//			
//			Integer totalq = data.size();
//			//all things of question table
//			Question q[] = new Question[totalq];
//			for(Integer i=0;i<totalq;i++) {
//				String[] questionRow = data.get(i);
//				
//				int questionid = Integer.parseInt(questionRow[0].toString());
//				String description = questionRow[1].toString();
//				String optionA = questionRow[2].toString();
//				String optionB = questionRow[3].toString();
//				String optionC = questionRow[4].toString();
//				String optionD = questionRow[5].toString();
//				String right_option = questionRow[6].toString();
//				int difficultyLevel = Integer.parseInt(questionRow[7].toString());
//				
//				Question question = new Question(questionid,description,optionA,optionB,optionC,optionD,right_option,difficultyLevel,Topic.JAVA);
//				q[i] = question;
//			}
//			
//			System.out.println("get interview 2");
//			
//			int duration = 20;
//			InterviewEntity ie = new InterviewEntity(1,q.length,duration,Topic.JAVA,q);
//			System.out.println("get interview 3");
//	}
//}
