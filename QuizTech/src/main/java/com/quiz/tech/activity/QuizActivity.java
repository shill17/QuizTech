package com.quiz.tech.activity;

import android.app.Activity;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;

@EActivity(R.layout.activity_quiz)
public class QuizActivity extends Activity {

	@AfterViews
	public void addFragment() {

	}
}