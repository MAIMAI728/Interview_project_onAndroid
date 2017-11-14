package ali_class.assignment9_10_interviewapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import ali_class.assignment9_10_interviewapp.fragments.InterviewFragment;
import ali_class.assignment9_10_interviewapp.fragments.MenuFragment;
import ali_class.assignment9_10_interviewapp.fragments.TopicFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        transaction.add(R.id.fragmentTopic_container, TopicFragment.newInstance(),"frag_topic");
        transaction.add(R.id.fragmentsInterview_container, InterviewFragment.newInstance(), "frag_interview");
        transaction.add(R.id.fragmentMenu_container, MenuFragment.newInstance(), "frag_menu");

        transaction.commit();
    }
}