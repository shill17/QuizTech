package com.quiz.tech.extensions;

import android.content.Context;

import com.quiz.tech.activity.CategoryActivity_;
import com.quiz.tech.activity.QuizActivity_;
import com.quiz.tech.annotations.InjectForActivity;
import com.quiz.tech.extensions.base.BaseActivity;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module(
		injects = {
				CategoryActivity_.class,
				QuizActivity_.class
		},
		complete = false,
		library = true
)
public class ActivityModule {
	private final BaseActivity activity;

	public ActivityModule(BaseActivity activity) {
		this.activity = activity;
	}

	@Provides
	@Singleton
	@InjectForActivity
	Context provideActivityContext() {
		return activity;
	}
}