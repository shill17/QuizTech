package com.quiz.tech.activity;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.net.Uri;
import android.widget.ListView;
import android.widget.Toast;

import com.quiz.tech.adapter.CategoryAdapter;
import com.quiz.tech.database.DatabaseLoader;
import com.quiz.tech.database.loader.CSVLoader;
import com.quiz.tech.model.Category;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ItemClick;
import org.androidannotations.annotations.OnActivityResult;
import org.androidannotations.annotations.OptionsItem;
import org.androidannotations.annotations.OptionsMenu;
import org.androidannotations.annotations.ViewById;

@EActivity(R.layout.activity_category)
@OptionsMenu(R.menu.category)
public class CategoryActivity extends Activity {
	private static String TAG = "CategoryActivity";
	private static final int CHOOSE_FILE_CODE = 1;

	@Bean
	CategoryAdapter adapter;

	@Bean(value = CSVLoader.class)
	DatabaseLoader dataLoader;

	@ViewById(R.id.list_category)
	ListView categoryList;

	@OptionsItem(R.id.action_load_questions)
	void chooseFile() {
		getFilePath();
	}

	private void getFilePath() {
		Intent openFileIntent = new Intent(Intent.ACTION_GET_CONTENT);
		openFileIntent.setType("text/csv");
		startActivityForResult(openFileIntent, CHOOSE_FILE_CODE);
	}

	@AfterViews
	void wireUpViews() {
		categoryList.setAdapter(adapter);
	}

	@ItemClick(R.id.list_category)
	void categoryListItemClicked(Category category) {
		QuizActivity_.intent(CategoryActivity.this).start();
	}

	@OnActivityResult(CHOOSE_FILE_CODE)
	void onResult(Intent data) {
		if(data == null) return;

		dataLoader.loadData(data.getData().getPath());
		adapter.notifyDataSetInvalidated();
		categoryList.setAdapter(adapter);
	}
}