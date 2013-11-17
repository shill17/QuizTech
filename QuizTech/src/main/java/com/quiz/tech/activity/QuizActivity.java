package com.quiz.tech.activity;

import com.quiz.tech.extensions.base.BaseActivity;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;

@EActivity(R.layout.activity_quiz)
public class QuizActivity extends BaseActivity {

	@AfterViews
	public void addFragment() {

	}
}