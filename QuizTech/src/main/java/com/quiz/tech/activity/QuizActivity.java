package com.quiz.tech.activity;

import android.support.v4.app.FragmentActivity;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.widget.Toast;

import com.quiz.tech.adapter.QuizPagerAdapter;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.Extra;
import org.androidannotations.annotations.OptionsMenu;
import org.androidannotations.annotations.ViewById;

@EActivity(R.layout.activity_quiz)
public class QuizActivity extends FragmentActivity {
	@Extra("categoryId")
	Long categoryId;

	@ViewById(R.id.viewpager_quiz)
	public ViewPager quizPager;

	@Bean(QuizPagerAdapter.class)
	PagerAdapter pagerAdapter;

	@AfterViews
	public void wireUpViews() {
		quizPager.setAdapter(pagerAdapter);
	}
}