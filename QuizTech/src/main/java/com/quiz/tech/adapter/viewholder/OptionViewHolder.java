package com.quiz.tech.adapter.viewholder;

import android.content.Context;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.quiz.tech.activity.R;
import com.quiz.tech.model.Options;

import org.androidannotations.annotations.EViewGroup;
import org.androidannotations.annotations.ViewById;

@EViewGroup(R.layout.list_item_options)
public class OptionViewHolder extends LinearLayout {
	@ViewById(R.id.tv_option)
	TextView tvOption;

	public OptionViewHolder(Context context) {
		super(context);
	}

	public void bind(Options option) {
		tvOption.setText(option.option);
	}
}