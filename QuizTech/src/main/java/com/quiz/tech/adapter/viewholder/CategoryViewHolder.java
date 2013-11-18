package com.quiz.tech.adapter.viewholder;

import android.content.Context;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.quiz.tech.activity.R;
import com.quiz.tech.model.Category;

import org.androidannotations.annotations.EViewGroup;
import org.androidannotations.annotations.ViewById;

@EViewGroup(R.layout.list_item_category)
public class CategoryViewHolder extends LinearLayout {

	@ViewById(R.id.tv_category)
	TextView tvCategory;

	public CategoryViewHolder(Context context) {
		super(context);
	}

	public void bind(Category category) {
		tvCategory.setText(category.category);
	}
}