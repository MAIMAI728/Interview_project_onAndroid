package ali_class.assignment9_10_interviewapp.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import ali_class.assignment9_10_interviewapp.retrofit.ApiUtils;
import ali_class.assignment9_10_interviewapp.entities.InterviewEntity;
import ali_class.assignment9_10_interviewapp.Events;
import ali_class.assignment9_10_interviewapp.GlobalBus;
import ali_class.assignment9_10_interviewapp.R;
import ali_class.assignment9_10_interviewapp.retrofit.SOService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TopicFragment extends Fragment {

    private SOService mService;

    RadioGroup radioGroup;
    RadioButton java;
    RadioButton sql;
    TextView announce;
    Button loadButton;

    public TopicFragment() {
    }

    public static TopicFragment newInstance() {
        return new TopicFragment();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public View onCreateView(LayoutInflater inflater,@Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_topic, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);

        radioGroup = (RadioGroup) view.findViewById(R.id.radioGroup);
        java = (RadioButton) view.findViewById(R.id.java);
        sql = (RadioButton) view.findViewById(R.id.sql);
        announce = (TextView) view.findViewById(R.id.announce);
        loadButton = (Button) view.findViewById(R.id.loadButton);
        loadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedValueID = radioGroup.getCheckedRadioButtonId();
                if (selectedValueID == java.getId()) {
                    announce.setText("JAVA Interview Questions");
                    getTopic(1);
                } else if (selectedValueID == sql.getId()) {
                    announce.setText("SQL Interview Questions");
                    getTopic(2);
                }
            }
        });
    }

    public void getTopic(int topic){
        mService = ApiUtils.getSOService();
        if (topic == 1) {
            mService.interviewTopic("JAVA").enqueue(new Callback<InterviewEntity>() {
                @Override
                public void onResponse(Call<InterviewEntity> call, Response<InterviewEntity> response) {
                    if (response.isSuccessful()) {
                        Events.FragmentTopicToFragmentInterview topic2interview = new Events.FragmentTopicToFragmentInterview(response.body());
                        GlobalBus.getBus().post(topic2interview);
                    } else {
                        int statusCode = response.code();
                        //handle request errors depending on status code
                    }
                }
                @Override
                public void onFailure(Call<InterviewEntity> call, Throwable t) {
                    Log.d("MainActivity", "error loading from API");
                }
            });
        }

        if (topic == 2) {
            mService.interviewTopic("SQL").enqueue(new Callback<InterviewEntity>() {
                @Override
                public void onResponse(Call<InterviewEntity> call, Response<InterviewEntity> response) {
                    if (response.isSuccessful()) {
                        Events.FragmentTopicToFragmentInterview topic2interview = new Events.FragmentTopicToFragmentInterview(response.body());
                        GlobalBus.getBus().post(topic2interview);
                    } else {
                        int statusCode = response.code();
                        //handle request errors depending on status code
                    }
                }
                @Override
                public void onFailure(Call<InterviewEntity> call, Throwable t) {
                }
            });
        }
    }


//    @Override
//    public void onDetach() {
//        super.onDetach();
//        mListener = null;
//    }



}
