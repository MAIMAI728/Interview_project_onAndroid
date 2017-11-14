package ali_class.assignment9_10_interviewapp.fragments;

import android.content.Context;
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
import android.widget.Toast;

import java.util.regex.Pattern;

import ali_class.assignment9_10_interviewapp.retrofit.ApiUtils;
import ali_class.assignment9_10_interviewapp.entities.ProfileEntity;
import ali_class.assignment9_10_interviewapp.entities.UserEntity;
import ali_class.assignment9_10_interviewapp.R;
import ali_class.assignment9_10_interviewapp.retrofit.SOService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterFragment extends Fragment {
    private SOService mService;

    EditText firstName, lastName, country, username, password;
//    Pattern patternForUsername = Pattern.compile("^[0-9a-zA-Z]+@[.0-9a-zA-Z]+$");
//    Pattern patternForPassword = Pattern.compile("(?=([a-zA-Z0-9].*(\\W))|((\\W).*[a-zA-Z0-9])$).{8,12}");

    public RegisterFragment() {
        // Required empty public constructor
    }

    public static RegisterFragment newInstance() {
        return new RegisterFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mService = ApiUtils.getSOService();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_register, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        firstName = (EditText) view.findViewById(R.id.firstname);
        lastName = (EditText) view.findViewById(R.id.lastname);
        country = (EditText) view.findViewById(R.id.country);
        username = (EditText) view.findViewById(R.id.username);
        password = (EditText) view.findViewById(R.id.password);

        Button register = (Button) view.findViewById(R.id.register_button);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doRegister(String.valueOf(firstName.getText()),
                        String.valueOf(lastName.getText()),
                        String.valueOf(country.getText()),
                        String.valueOf(username.getText()),
                        String.valueOf(password.getText()));
            }
        });
    }

    //正規表現のやつ
//    public void onClick1(View v){
//        String un = username.getText().toString();
//
//        if(patternForUsername.matcher().matches(un)) {
//            Toast.makeText(getActivity(),"match",Toast.LENGTH_SHORT).show();
//        } else {
//            Toast.makeText(getActivity(),"un match",Toast.LENGTH_SHORT).show();
//        }
//    }


    public void doRegister(final String firstName, final String lastName, String country, final String username, final String password) {
        mService = ApiUtils.getSOService();
        UserEntity userEntity = new UserEntity(firstName, lastName, country, username, password);
        mService.createUser(userEntity).enqueue(new Callback<ProfileEntity>() {
            @Override
            public void onResponse(Call<ProfileEntity> call, Response<ProfileEntity> response) {
                if (response.isSuccessful()) {
                    Log.d("MainActivity", "posts loaded from API");

                    //ユーザアカウント登録する
                    ProfileEntity profile = response.body();
                    profile.getClass();
                    //登録した値を呼び出せるSharedPreferencesを使う
                    SharedPreferences sharedPreferences = getContext().getSharedPreferences("userEntity", Context.MODE_PRIVATE);
                    //Editorを使うと内容をsetできる
                    SharedPreferences.Editor edit = sharedPreferences.edit();
                    edit.putString("firstName", firstName);
                    edit.putString("lastName", lastName);
                    edit.putString("username", username);
                    edit.putString("password", password);
                    edit.putInt("userId", profile.getUserid());
                    edit.apply();

                    //StartActivityに戻る
                    getFragmentManager().popBackStack();
                } else {
                    int statusCode = response.code();
                    // handle request errors depending on status code
                }
            }

            @Override
            public void onFailure(Call<ProfileEntity> call, Throwable t) {
                Log.d("MainActivity", "error loading from API");
            }
        });

    }


//    @Override
//    public void onDetach() {
//        super.onDetach();
//        mListener = null;
//    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        //Bus.getBus().unregister(this);
    }
}
