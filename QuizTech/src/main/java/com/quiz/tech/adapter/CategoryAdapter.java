package com.quiz.tech.adapter;


import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.j256.ormlite.dao.Dao;
import com.quiz.tech.adapter.viewholder.CategoryViewHolder;
import com.quiz.tech.adapter.viewholder.CategoryViewHolder_;
import com.quiz.tech.database.DatabaseHelper;
import com.quiz.tech.model.Category;

import org.androidannotations.annotations.AfterInject;
import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.OrmLiteDao;
import org.androidannotations.annotations.RootContext;

import java.sql.SQLException;
import java.util.List;

@EBean
public class CategoryAdapter extends BaseAdapter {
	private static final String TAG = "CategoryAdapter";
	List<Category> categories;
	@OrmLiteDao(helper = DatabaseHelper.class, model = Category.class)
	Dao<Category, Long> categoryDao;
	@RootContext
	Context context;

	@AfterInject
	void initAdapter() {
		try {
			categories = categoryDao.queryForAll();
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
		return categories.size();
	}

	@Override
	public Category getItem(int position) {
		return categories.get(position);
	}

	@Override
	public long getItemId(int position) {
		return getItem(position).id;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		CategoryViewHolder holder = (convertView == null) ? CategoryViewHolder_.build(context) : (CategoryViewHolder_) convertView;

		holder.bind(getItem(position));

		return holder;
	}
}