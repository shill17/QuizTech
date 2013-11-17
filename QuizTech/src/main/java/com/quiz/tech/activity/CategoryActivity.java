package com.quiz.tech.activity;

import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import com.quiz.tech.database.DatabaseHelper;
import com.quiz.tech.extensions.base.BaseActivity;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;

@EActivity(R.layout.activity_category)
public class CategoryActivity extends BaseActivity {

	public DatabaseHelper dbHelper;

	@AfterViews
	public void connectDB() {
		dbHelper = DatabaseHelper.getInstance(CategoryActivity.this);

		if(dbHelper != null) {
			SQLiteDatabase db = dbHelper.getWritableDatabase();

			Toast.makeText(CategoryActivity.this, "Created", Toast.LENGTH_SHORT).show();
		}
		else
			Toast.makeText(CategoryActivity.this, "Not Created", Toast.LENGTH_SHORT).show();
	}
}