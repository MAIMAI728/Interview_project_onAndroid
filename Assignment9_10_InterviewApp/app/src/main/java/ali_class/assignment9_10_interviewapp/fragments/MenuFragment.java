package ali_class.assignment9_10_interviewapp.fragments;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import org.greenrobot.eventbus.Subscribe;

import java.util.ArrayList;
import java.util.List;

import ali_class.assignment9_10_interviewapp.Events;
import ali_class.assignment9_10_interviewapp.GlobalBus;
import ali_class.assignment9_10_interviewapp.MainActivity;
import ali_class.assignment9_10_interviewapp.R;
import ali_class.assignment9_10_interviewapp.StartActivity;
import ali_class.assignment9_10_interviewapp.entities.AnswerCollectionEntity;
import ali_class.assignment9_10_interviewapp.entities.AnswerEntity;
import ali_class.assignment9_10_interviewapp.entities.Question;
import ali_class.assignment9_10_interviewapp.entities.ResultEntity;
import ali_class.assignment9_10_interviewapp.retrofit.ApiUtils;
import ali_class.assignment9_10_interviewapp.retrofit.SOService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MenuFragment extends android.support.v4.app.Fragment {

    private SOService mService;
    Button resultButton, historyButton, logoutButton;

    public static MenuFragment newInstance(){
        return new MenuFragment();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_menu, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        resultButton = (Button) view.findViewById(R.id.result_button);
        logoutButton = (Button) view.findViewById(R.id.logout_button);

        resultButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GlobalBus.getBus().post(new Events.FragmentInterviewToFragmentMenu());
            }
        });


        logoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //experimental terminator
                Intent logout = new Intent(getContext(), StartActivity.class);
                logout.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                SharedPreferences sharedPreferences = getContext().getSharedPreferences("userEntity", Context.MODE_PRIVATE);
                sharedPreferences.edit().clear().apply();
                startActivity(logout);
                getActivity().finish();

            }
        });

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        GlobalBus.getBus().unregister(this);
    }
}
