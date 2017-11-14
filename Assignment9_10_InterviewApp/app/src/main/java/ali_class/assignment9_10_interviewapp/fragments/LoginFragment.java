package ali_class.assignment9_10_interviewapp.fragments;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import ali_class.assignment9_10_interviewapp.Events;
import ali_class.assignment9_10_interviewapp.GlobalBus;
import ali_class.assignment9_10_interviewapp.MainActivity;
import ali_class.assignment9_10_interviewapp.R;
import ali_class.assignment9_10_interviewapp.StartActivity;
import ali_class.assignment9_10_interviewapp.entities.CredentialEntity;
import ali_class.assignment9_10_interviewapp.entities.ProfileEntity;
import ali_class.assignment9_10_interviewapp.retrofit.ApiUtils;
import ali_class.assignment9_10_interviewapp.retrofit.SOService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginFragment extends Fragment {

    private SOService mService;

    EditText userName_login, password_login;
    Button loginButton;


    public static LoginFragment newInstance() {
        return new LoginFragment();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        userName_login = (EditText) view.findViewById(R.id.login_username);
        password_login = (EditText) view.findViewById(R.id.login_password);

        loginButton = (Button) view.findViewById(R.id.login_button);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                doLogin(String.valueOf(userName_login.getText()), String.valueOf(password_login.getText()));
            }
        });
    }

    public void doLogin(String username, String password) {

        mService = ApiUtils.getSOService();

        CredentialEntity requestBody = new CredentialEntity(username, password);
        mService.loginUser(requestBody).enqueue(new Callback<ProfileEntity>() {

            @Override
            public void onResponse(Call<ProfileEntity> call, Response<ProfileEntity> response) {
                if (response.isSuccessful()) {

                    ProfileEntity profile = response.body();
                    //登録した値を呼び出せるSharedPreferencesを使う
                    SharedPreferences sharedPreferences = getContext().getSharedPreferences("userEntity", Context.MODE_PRIVATE);
                    //Editorを使うと内容をsetできる
                    SharedPreferences.Editor edit = sharedPreferences.edit();
                    edit.putString("firstName", profile.getUserProfile().getFirstName());
                    edit.putString("lastName", profile.getUserProfile().getLastName());
                    edit.putString("username", profile.getUserProfile().getUsername());
                    edit.putInt("userId", profile.getUserid());
                    edit.apply();

                    Intent intent = new Intent(getContext(), MainActivity.class);
                    startActivity(intent);

                    getActivity().finish();

                } else {
                    int statusCode = response.code();
                }

            }


            @Override
            public void onFailure(Call<ProfileEntity> call, Throwable t) {
                Log.d("MainActivity", "error loading from API");
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        // Unregister the registered event.
        GlobalBus.getBus().unregister(this);
    }
}
