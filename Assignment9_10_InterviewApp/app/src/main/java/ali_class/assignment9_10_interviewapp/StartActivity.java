package ali_class.assignment9_10_interviewapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import org.greenrobot.eventbus.Subscribe;

import ali_class.assignment9_10_interviewapp.fragments.StartFragment;

public class StartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //start_activity.xmlを表示
        setContentView(R.layout.start_activity);

        // SharedPreferenceを確認する
        SharedPreferences sharedPreferences = getSharedPreferences("userEntity", Context.MODE_PRIVATE);
        // 中身があればfinishしてMainActivityへ
        String username = sharedPreferences.getString("username", "");
        if (!username.equals("")) {
            finish();
            startActivity(new Intent(this, MainActivity.class));
            return;
        }

        getSupportFragmentManager().beginTransaction()
                .add(R.id.start_container, StartFragment.newInstance())
                .commit();
    }

    //startFragmentから
    @Override
    protected void onStart() {
        super.onStart();
        GlobalBus.getBus().register(this);
    }

    //startFragmentから来たデータ
    @Subscribe
    public void getMessage(Events.FragmentLoginToMainActivity fragmentActivityMessage) {
        String messageView = "test";
    }

    @Override
    protected void onStop() {
        super.onStop();
        GlobalBus.getBus().unregister(this);
    }


}
