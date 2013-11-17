package com.quiz.tech.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import com.quiz.tech.model.Answer;
import com.quiz.tech.model.Category;
import com.quiz.tech.model.Options;
import com.quiz.tech.model.Question;
import com.quiz.tech.model.Scores;
import com.quiz.tech.model.Session;

import java.sql.SQLException;

public class DatabaseHelper extends OrmLiteSqliteOpenHelper {
	public static final String DB_NAME = "quiz.sqlite";
	public static final int DB_VERSION = 1;
	public static String TAG = "DatabaseHelper";

	private static DatabaseHelper dbHelper;

	private DatabaseHelper(Context context) {
		super(context, DB_NAME, null, DB_VERSION);
	}

	public static DatabaseHelper getInstance(Context context) {
		return (dbHelper == null) ? new DatabaseHelper(context.getApplicationContext()) : dbHelper;
	}

	@Override
	public void onCreate(SQLiteDatabase sqLiteDatabase, ConnectionSource connectionSource) {
		try {
			TableUtils.createTableIfNotExists(connectionSource, Category.class);
			TableUtils.createTableIfNotExists(connectionSource, Question.class);
			TableUtils.createTableIfNotExists(connectionSource, Options.class);
			TableUtils.createTableIfNotExists(connectionSource, Answer.class);
			TableUtils.createTableIfNotExists(connectionSource, Session.class);
			TableUtils.createTableIfNotExists(connectionSource, Scores.class);
		} catch (SQLException e) {
			Log.e(TAG, "Unable to create tables", e);
		}
	}

	@Override
	public void onUpgrade(SQLiteDatabase sqLiteDatabase, ConnectionSource connectionSource, int i, int i2) {

	}
}