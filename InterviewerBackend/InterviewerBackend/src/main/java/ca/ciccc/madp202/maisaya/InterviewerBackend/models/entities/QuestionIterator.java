package ca.ciccc.madp202.maisaya.InterviewerBackend.models.entities;

import java.util.Iterator;

public class QuestionIterator implements Iterator<Question> {
	private Question[] questions;
	private int counter;
	
	QuestionIterator(){
	}
	
	QuestionIterator(Question[] questions){
		this.questions = questions;
		this.counter = 0;
	}
	
	@Override
    public boolean hasNext(){
        return this.questions.length>counter;
    }

    @Override
    public Question next(){
        if(hasNext()){
            Question question = this.questions[this.counter];
            this.counter++;
            return question;
        }
        return null;
    }
}
