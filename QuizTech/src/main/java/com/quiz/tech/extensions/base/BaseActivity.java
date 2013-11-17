package com.quiz.tech.extensions.base;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.quiz.tech.extensions.ActivityModule;

import java.util.Arrays;
import java.util.List;

import dagger.ObjectGraph;

public abstract class BaseActivity extends FragmentActivity {
	private ObjectGraph activityGraph;

	@Override
	protected void onCreate(Bundle savedInstance) {
		BaseApplication app = (BaseApplication) getApplication();
		activityGraph = app.getAppGraph().plus(getModules().toArray());
		activityGraph.inject(this);
	}

	@Override
	protected void onDestroy() {
		activityGraph = null;
		super.onDestroy();
	}

	private List<Object> getModules() {
		return Arrays.<Object>asList(new ActivityModule(this));
	}

	public void inject(Object object) {
		activityGraph.inject(object);
	}
}