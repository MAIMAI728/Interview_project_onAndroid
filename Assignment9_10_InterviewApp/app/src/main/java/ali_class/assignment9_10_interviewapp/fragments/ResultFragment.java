package ali_class.assignment9_10_interviewapp.fragments;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import ali_class.assignment9_10_interviewapp.Events;
import ali_class.assignment9_10_interviewapp.GlobalBus;
import ali_class.assignment9_10_interviewapp.MainActivity;
import ali_class.assignment9_10_interviewapp.R;
import ali_class.assignment9_10_interviewapp.entities.ProfileEntity;

public class ResultFragment extends Fragment {

    TextView dashboard;
    String userScore;

    public ResultFragment() {
        // Required empty public constructor
    }

    public static ResultFragment newInstance() {
        return new ResultFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,@Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        GlobalBus.getBus().register(this);
        View view = inflater.inflate(R.layout.fragment_result, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        dashboard = (TextView) view.findViewById(R.id.score_board);
        if(userScore != null){
            dashboard.setText(userScore);
            Button back_button = (Button)view.findViewById(R.id.back_button);
            back_button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
//                    getFragmentManager().popBackStack();

                    Intent intent = new Intent(getContext(), MainActivity.class);
                    startActivity(intent);

                    getActivity().finish();
                }
            });
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        GlobalBus.getBus().unregister(this);
    }

    @Subscribe(sticky = true, threadMode = ThreadMode.MAIN)
    public void getMessage(Events.FragmentInterviewToFragmentResult receivedEvent) {
        //prefからユーザ名を取得したい
        SharedPreferences sharedPreferences = getContext().getSharedPreferences("userEntity", Context.MODE_PRIVATE);
        String firstName = sharedPreferences.getString("firstName","");
        String lastName = sharedPreferences.getString("lastName","");

        userScore = "Dear " + firstName + lastName + "\n" +
                "==============================" + "\n" +
                "Date of test: " + receivedEvent.getReceivedData().getDateAsFormatted() + "\n" +
                "-------------------------------" + "\n"+
                "Your score: " + receivedEvent.getReceivedData().getScore() + " / 100" + "\n" +
                "Total number of questions: " + receivedEvent.getReceivedData().getQuestions() + "\n" +
                "Correct responses: " + receivedEvent.getReceivedData().getCorrectAnswer() + "\n" +
                "Wrong responses: " + receivedEvent.getReceivedData().getWrongAnswer() + "\n" +
                "Skipped responses " + receivedEvent.getReceivedData().getSkippedAnswer() + "\n";
    }


}