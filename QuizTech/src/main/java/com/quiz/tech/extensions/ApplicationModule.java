package com.quiz.tech.extensions;

import android.content.Context;

import com.quiz.tech.annotations.InjectForApplication;
import com.quiz.tech.extensions.base.BaseApplication;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module(library = true)
public class ApplicationModule {
	private final BaseApplication application;

	public ApplicationModule(BaseApplication application) {
		this.application = application;
	}

	@Provides
	@Singleton
	@InjectForApplication
	Context provideApplicationContext() {
		return application;
	}
}