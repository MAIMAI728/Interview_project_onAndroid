package ali_class.assignment9_10_interviewapp.entities;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ProfileEntity {
    //exposeはJSONに表示する要素
    @SerializedName("authtoken")
    @Expose
    private String authtoken;
    @SerializedName("userid")
    @Expose
    private int userid;
    @SerializedName("joined")
    @Expose
    private long joined;
    @SerializedName("userProfile")
    @Expose
    private UserEntity userProfile;


    public ProfileEntity() {
        // TODO Auto-generated constructor stub
    }

    public ProfileEntity(String authtoken, int userid, long joined, UserEntity userProfile) {
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

    public long getJoined() {
        return joined;
    }

    public void setJoined(long joined) {
        this.joined = joined;
    }

    public UserEntity getUserProfile() {
        return userProfile;
    }

    public void setUserProfile(UserEntity userProfile) {
        this.userProfile = userProfile;
    }



}
