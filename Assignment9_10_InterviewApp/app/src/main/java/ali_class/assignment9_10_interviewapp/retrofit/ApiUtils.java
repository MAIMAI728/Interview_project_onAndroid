package ali_class.assignment9_10_interviewapp.retrofit;

public class ApiUtils {

//    public static final String BASE_URL = "http://localhost:8080/InterviewerBackend/webapi/";
//    public static final String BASE_URL = "http://m7a2i8.ddns.net/webapi/";
    public static final String BASE_URL = "http://10.0.2.2:8080/InterviewerBackend/webapi/";

    public static SOService getSOService() {
        return RetrofitClient.getClient(BASE_URL).create(SOService.class);
    }
}
