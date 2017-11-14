package ali_class.assignment9_10_interviewapp.retrofit;

import ali_class.assignment9_10_interviewapp.entities.AnswerCollectionEntity;
import ali_class.assignment9_10_interviewapp.entities.CredentialEntity;
import ali_class.assignment9_10_interviewapp.entities.InterviewEntity;
import ali_class.assignment9_10_interviewapp.entities.ProfileEntity;
import ali_class.assignment9_10_interviewapp.entities.ResultEntity;
import ali_class.assignment9_10_interviewapp.entities.TopicSelectEntity;
import ali_class.assignment9_10_interviewapp.entities.UserEntity;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;


public interface SOService {


    @POST("interview/users")
    Call<ProfileEntity> createUser(@Body UserEntity userEntity);
    //getAnswers()がCall(ジェネリッククラス)の<ProfileEntity>のクラスの中のものに入る

    @POST("interview/login")
    Call<ProfileEntity> loginUser(@Body CredentialEntity credentialEntity);


    @GET("interview/topics/{id}")
    Call<InterviewEntity> interviewTopic(@Path("id") String topic);


    //idが一致しないっておこられた
    @POST("interview/interview/{id}")
    Call<ResultEntity> result(@Path("id")int id, @Body AnswerCollectionEntity answers);

    //タグ入ってないからおこられた
//    @POST("interview/interview")
//    Call<ResultEntity> result(@Body AnswerCollectionEntity answerCollectionEntity);
}
