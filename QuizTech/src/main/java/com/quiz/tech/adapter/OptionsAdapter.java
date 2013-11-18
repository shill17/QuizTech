package com.quiz.tech.adapter;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.quiz.tech.adapter.viewholder.OptionViewHolder;
import com.quiz.tech.adapter.viewholder.OptionViewHolder_;
import com.quiz.tech.database.DatabaseHelper;
import com.quiz.tech.model.Options;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

public class OptionsAdapter extends BaseAdapter {
	private static final String TAG = "OptionsAdapter";

	List<Options> optionsList;
	Dao<Options, Long> optionsDao;
	Context context;
	long questionId = -1;

	public OptionsAdapter(Context context, long questionId) {
		this.context = context;
		this.questionId = questionId;

		try {
			optionsDao = DaoManager.createDao(new DatabaseHelper(context).getConnectionSource(), Options.class);
		} catch (SQLException e) {
			Log.e(TAG, "Unable to create OptionsDAO", e);
		}

		initAdapter();
	}

	void initAdapter() {
		try {
			if(questionId == -1) return;

			optionsList = optionsDao.queryForEq(Options.QUESTION_ID, questionId);
			Collections.shuffle(optionsList);
		} catch (SQLException e) {
			Log.e(TAG, "Unable to retrieve categories", e);
		}
	}

	@Override
	public void notifyDataSetChanged() {
		super.notifyDataSetChanged();
		initAdapter();
	}

	@Override
	public void notifyDataSetInvalidated() {
		super.notifyDataSetInvalidated();
		initAdapter();
	}

	@Override
	public int getCount() {
		if(optionsList == null) return 0;
		return optionsList.size();
	}

	@Override
	public Options getItem(int position) {
		if(optionsList == null) return null;
		return optionsList.get(position);
	}

	@Override
	public long getItemId(int position) {
		if(optionsList == null) return -1;
		return getItem(position).id;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		OptionViewHolder holder = (convertView == null) ? OptionViewHolder_.build(context) : (OptionViewHolder_) convertView;

		holder.bind(getItem(position));

		return holder;
	}
}