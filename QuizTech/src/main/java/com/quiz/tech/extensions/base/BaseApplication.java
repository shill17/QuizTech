package com.quiz.tech.extensions.base;

import android.app.Application;

import com.quiz.tech.extensions.ApplicationModule;

import java.util.Arrays;
import java.util.List;

import dagger.ObjectGraph;

public class BaseApplication extends Application {
	private ObjectGraph appGraph;

	@Override
	public void onCreate() {
		super.onCreate();
		appGraph = ObjectGraph.create(getModules().toArray());
	}

	protected List<Object> getModules() {
		return Arrays.<Object>asList(new ApplicationModule(this));
	}

	ObjectGraph getAppGraph() {
		return appGraph;
	}
}