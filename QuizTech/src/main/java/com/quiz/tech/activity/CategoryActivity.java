package com.quiz.tech.activity;

import android.app.Activity;
import android.app.ListActivity;
import android.widget.ListView;
import android.widget.Toast;

import com.quiz.tech.adapter.CategoryAdapter;
import com.quiz.tech.model.Category;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ItemClick;
import org.androidannotations.annotations.OptionsItem;
import org.androidannotations.annotations.OptionsMenu;
import org.androidannotations.annotations.ViewById;

@EActivity(R.layout.activity_category)
@OptionsMenu(R.menu.category)
public class CategoryActivity extends Activity {
	private static String TAG = "CategoryActivity";

	@Bean
	CategoryAdapter adapter;

	@ViewById(R.id.list_category)
	ListView categoryList;

	@OptionsItem(R.id.action_load_questions)
	public void loadData() {

	}

	@AfterViews
	public void wireUpViews() {
		categoryList.setAdapter(adapter);
	}

	@ItemClick(R.id.list_category)
	public void categoryListItemClicked(Category category) {
		QuizActivity_.intent(CategoryActivity.this).start();
	}
}