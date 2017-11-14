package ca.ciccc.madp202.maisaya.InterviewerBackend.models.responseModels;

import java.util.Date;

import ca.ciccc.madp202.maisaya.InterviewerBackend.models.entities.UserEntity;

public class CredentialResponseModel {
	
//	String firstname;
//	String lastname;
//	int userid;
//	String username;
//	Date joined;
	
	//チートしたやつ
//	"status":"200",
//	"firsname":"Jack",
//	"lastname":"Peterson",
//	"userId":"5"
//	"username":" jack.peterson@gmail.com "
//	"joined":" 17 July 2017"
	
	
	//from : ProfileEntity
		private String authtoken;
		private int userid;
		private Date joined;
		private UserEntity userProfile;
		
		public CredentialResponseModel() {
			// TODO Auto-generated constructor stub
		}
		
		public CredentialResponseModel(String authtoken, int userid, Date joined, UserEntity userProfile) {
			this.authtoken = authtoken;
			this.userid = userid;
			this.joined = joined;
			this.userProfile = userProfile;
		}

		public String getAuthtoken() {
			return authtoken;
		}
		public void setAuthtoken(String authtoken) {
			this.authtoken = authtoken;
		}
		public int getUserid() {
			return userid;
		}
		public void setUserid(int userid) {
			this.userid = userid;
		}
		public Date getJoined() {
			return joined;
		}
		public void setJoined(Date joined) {
			this.joined = joined;
		}
		public UserEntity getUserProfile() {
			return userProfile;
		}
		public void setUserProfile(UserEntity userProfile) {
			this.userProfile = userProfile;
		}
		
	
}
