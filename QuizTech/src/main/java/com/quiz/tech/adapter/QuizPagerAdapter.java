package com.quiz.tech.adapter;


import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.util.Log;

import com.j256.ormlite.dao.Dao;
import com.quiz.tech.activity.fragment.QuizFragment_;
import com.quiz.tech.database.DatabaseHelper;
import com.quiz.tech.model.Question;
import com.quiz.tech.utils.HelperMethods;

import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.OrmLiteDao;

import java.sql.SQLException;

@EBean
public class QuizPagerAdapter extends FragmentStatePagerAdapter {
	private static final String TAG = "QuizPagerAdapter";

	@OrmLiteDao(helper = DatabaseHelper.class, model = Question.class)
	Dao<Question, Long> questionDao;

	public QuizPagerAdapter(Context context) {
		super(((FragmentActivity) context).getSupportFragmentManager());
	}

	@Override
	public Fragment getItem(int id) {
		return QuizFragment_.builder().questionId((long) ++id).build();
	}

	@Override
	public int getCount() {
		int count = 0;

		try {
			count = HelperMethods.safeLongToInt(questionDao.countOf());
		} catch (SQLException e) {
			Log.e(TAG, "Error while counting questions", e);
		}

		return count;
	}
}