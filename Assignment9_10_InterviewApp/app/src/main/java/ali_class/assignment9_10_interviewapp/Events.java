package ali_class.assignment9_10_interviewapp;

import java.util.ArrayList;
import java.util.Arrays;

import ali_class.assignment9_10_interviewapp.entities.AnswerCollectionEntity;
import ali_class.assignment9_10_interviewapp.entities.InterviewEntity;
import ali_class.assignment9_10_interviewapp.entities.Question;
import ali_class.assignment9_10_interviewapp.entities.ResultEntity;
import ali_class.assignment9_10_interviewapp.fragments.ResultFragment;

public class Events {

    public static class FragmentLoginToMainActivity {
        private String receivedData;
        public FragmentLoginToMainActivity(String receivedData) {
            this.receivedData = receivedData;
        }
        public String getReceivedData() {
            return receivedData;
        }
    }


    public static class FragmentTopicToFragmentInterview {
        private InterviewEntity receivedData;
        public FragmentTopicToFragmentInterview(InterviewEntity receivedData) {
            this.receivedData = receivedData;
        }

        public InterviewEntity getReceivedData() {
            return receivedData;
        }
    }

    public static class FragmentInterviewToFragmentMenu {
        public FragmentInterviewToFragmentMenu() {
        }
    }


    public static class FragmentInterviewToFragmentResult {
        private ResultEntity receivedData;

        public FragmentInterviewToFragmentResult(ResultEntity receivedData) {
            this.receivedData = receivedData;
        }
        public ResultEntity getReceivedData() {
            return receivedData;
        }
    }
}

