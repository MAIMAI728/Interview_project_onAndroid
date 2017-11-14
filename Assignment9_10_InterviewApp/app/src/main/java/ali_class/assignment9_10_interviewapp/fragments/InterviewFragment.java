package ali_class.assignment9_10_interviewapp.fragments;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import org.greenrobot.eventbus.Subscribe;

import java.util.ArrayList;

import ali_class.assignment9_10_interviewapp.entities.AnswerCollectionEntity;
import ali_class.assignment9_10_interviewapp.entities.AnswerEntity;
import ali_class.assignment9_10_interviewapp.entities.InterviewEntity;
import ali_class.assignment9_10_interviewapp.entities.Question;
import ali_class.assignment9_10_interviewapp.Events;
import ali_class.assignment9_10_interviewapp.GlobalBus;
import ali_class.assignment9_10_interviewapp.R;
import ali_class.assignment9_10_interviewapp.entities.ResultEntity;
import ali_class.assignment9_10_interviewapp.retrofit.ApiUtils;
import ali_class.assignment9_10_interviewapp.retrofit.RetrofitClient;
import ali_class.assignment9_10_interviewapp.retrofit.SOService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

// Adapter

public class InterviewFragment extends Fragment {
//    private OnFragmentInteractionListener mListener;
    RecyclerView recyclerView;
    SOService mService = ApiUtils.getSOService();

    //answerCollectionEntityコンストラクタの引数は(interviewId,userId)
    public AnswerCollectionEntity mAnswerCollectionEntity;
    private int mInterviewid;
    private InterviewAdapter mAdapter;

//    public InterviewFragment() {
//        // Required empty public constructor
//    }

    public static InterviewFragment newInstance() {
        return new InterviewFragment();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    //こっちのやり方がオフィシャル
    @Override
    public void onStart() {
        super.onStart();
        GlobalBus.getBus().register(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,@Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_interview,container,false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = (RecyclerView) view.findViewById(R.id.interview_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
    }

    @Subscribe
    public void getMessage(Events.FragmentTopicToFragmentInterview receivedEvent) {
        mInterviewid = receivedEvent.getReceivedData().getInterviewid();
        mAdapter = new InterviewAdapter(getContext(), receivedEvent.getReceivedData().getInterviewQuestions());
        recyclerView.setAdapter(mAdapter);
        recyclerView.addItemDecoration(new DividerItemDecoration(getContext(),LinearLayoutManager.VERTICAL));
    }

    @Override
    public void onStop() {
        super.onStop();
        GlobalBus.getBus().unregister(this);
    }

    @Subscribe
    public void onResultEvent(Events.FragmentInterviewToFragmentMenu event) {
        ArrayList<AnswerEntity> answers = new ArrayList<AnswerEntity>();
        for (Question q : mAdapter.getInterviews()) {
            AnswerEntity answer = new AnswerEntity(q.getQuestionid(), q.getSelectedOption());
            answers.add(answer);
        }

        SharedPreferences sharedPreferences = getContext().getSharedPreferences("userEntity", Context.MODE_PRIVATE);
        int userId = sharedPreferences.getInt("userId", -1);

        AnswerCollectionEntity answerCollectionEntity = new AnswerCollectionEntity(mInterviewid,userId,answers);

        mService = ApiUtils.getSOService();

        //interviewIdとuserIdとArrayList<AnswerEntity>送信(AnswerCollectionEntity)、インタビュー結果受信
        mService.result(mInterviewid, answerCollectionEntity).enqueue(new Callback<ResultEntity>() {
            @Override
            public void onResponse(Call<ResultEntity> call, Response<ResultEntity> response) {
                if (response.isSuccessful()) {

                    Events.FragmentInterviewToFragmentResult interviewToFragmentMenu = new Events.FragmentInterviewToFragmentResult(response.body());
                    GlobalBus.getBus().postSticky(interviewToFragmentMenu);

                    getFragmentManager()
                            .beginTransaction()
                            .replace(R.id.fragmentsInterview_container, ResultFragment.newInstance())
                            .commit();

                } else {
                    int statusCode = response.code();
                    //handle request errors depending on status code
                }
            }

            @Override
            public void onFailure(Call<ResultEntity> call, Throwable t) {
                Log.d("MainActivity", "error loading from API");
            }
        });
    }


    public class InterviewAdapter extends RecyclerView.Adapter<InterviewAdapter.MyViewHolder>{

        private ArrayList<Question> interviews = new ArrayList<>();
        private Context mContext;

        public InterviewAdapter(Context context, ArrayList<Question> arrayLists) {
            interviews = arrayLists;
            mContext = context;
        }

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View itemView = LayoutInflater.from(mContext)
                    .inflate(R.layout.questions,parent,false);
            return new MyViewHolder(itemView);
        }

        @Override
        public void onBindViewHolder(final MyViewHolder holder, final int position) {
            holder.description.setText(interviews.get(position).getQuestionid() +": "+ interviews.get(position).getDescription());
            holder.difficultyLevel.setText(String.valueOf(interviews.get(position).getDifficultyLevel()));
            holder.optionA.setText(interviews.get(position).getOptionA());
            holder.optionB.setText(interviews.get(position).getOptionB());
            holder.optionC.setText(interviews.get(position).getOptionC());
            holder.optionD.setText(interviews.get(position).getOptionD());

            //チェックしたものをgetする
            holder.checked.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                    switch (checkedId) {
                        case R.id.option1:
                            interviews.get(position).setSelectedOption("A");
                            break;
                        case R.id.option2:
                            interviews.get(position).setSelectedOption("B");
                            break;
                        case R.id.option3:
                            interviews.get(position).setSelectedOption("C");
                            break;
                        case R.id.option4:
                            interviews.get(position).setSelectedOption("D");
                            break;
                        default:
                            interviews.get(position).setSelectedOption("S");
                            break;
                    }
                }
            });
        }

        @Override
        public int getItemCount() {
            return interviews.size();
        }


        public ArrayList<Question> getInterviews() {
            return interviews;
        }

        public class MyViewHolder extends RecyclerView.ViewHolder {
            final TextView description;
            final TextView difficultyLevel;
            final RadioButton optionA;
            final RadioButton optionB;
            final RadioButton optionC;
            final RadioButton optionD;
            final RadioGroup checked;

            public MyViewHolder(View itemView) {
                super(itemView);
                description = itemView.findViewById(R.id.description);
                difficultyLevel = itemView.findViewById(R.id.difficultyLevel);
                optionA = itemView.findViewById(R.id.option1);
                optionB = itemView.findViewById(R.id.option2);
                optionC = itemView.findViewById(R.id.option3);
                optionD = itemView.findViewById(R.id.option4);
                checked = itemView.findViewById(R.id.options);
            }

        }
    }
}


//    @Override
//    public void onDetach() {
//        super.onDetach();
//        mListener = null;
//    }

//    public interface OnFragmentInteractionListener {
//        // TODO: Update argument type and name
//        void onFragmentInteraction(Uri uri);
//    }



