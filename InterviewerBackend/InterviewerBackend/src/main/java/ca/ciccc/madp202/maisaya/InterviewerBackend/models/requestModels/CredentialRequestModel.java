package ca.ciccc.madp202.maisaya.InterviewerBackend.models.requestModels;

public class CredentialRequestModel {
	
	//from : CredentialEntity
	private String username;
	private String password;
	
	public CredentialRequestModel() {
		
	}
	
	public CredentialRequestModel(String username, String password) {
		this.username = username;
		this.password = password;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	 
}
