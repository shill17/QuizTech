package com.quiz.tech.database.loader;

import android.content.Context;
import android.util.Log;

import com.j256.ormlite.dao.Dao;
import com.quiz.tech.database.DatabaseHelper;
import com.quiz.tech.database.DatabaseLoader;
import com.quiz.tech.model.Answer;
import com.quiz.tech.model.Category;
import com.quiz.tech.model.Options;
import com.quiz.tech.model.Question;

import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.OrmLiteDao;
import org.androidannotations.annotations.RootContext;
import org.supercsv.cellprocessor.constraint.StrNotNullOrEmpty;
import org.supercsv.cellprocessor.ift.CellProcessor;
import org.supercsv.io.CsvMapReader;
import org.supercsv.io.ICsvMapReader;
import org.supercsv.prefs.CsvPreference;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@EBean
public class CSVLoader implements DatabaseLoader {
	private static final String TAG = "CSVLoader";

	@RootContext
	Context context;

	@Bean
	DatabaseHelper dbHelper;

	@OrmLiteDao(helper = DatabaseHelper.class, model = Category.class)
	Dao<Category, Long> categoryDao;

	@OrmLiteDao(helper = DatabaseHelper.class, model = Question.class)
	Dao<Question, Long> questionDao;

	@OrmLiteDao(helper = DatabaseHelper.class, model = Options.class)
	Dao<Options, Long> optionsDao;

	@OrmLiteDao(helper = DatabaseHelper.class, model = Answer.class)
	Dao<Answer, Long> answerDao;

	List<Category> categories;

	ICsvMapReader mapReader = null;

	@Override
	public void loadData(String filePath) {
		try {
			mapReader = new CsvMapReader(new FileReader(filePath), CsvPreference.STANDARD_PREFERENCE);

			final String[] header = mapReader.getHeader(true);
			final CellProcessor[] processors = getProcessors();

			Map<String, Object> dataMap;

			categories = new ArrayList<>();
			dbHelper.clearDatabase();

			while ((dataMap = mapReader.read(header, processors)) != null) {
				// Category
				String sCategory = dataMap.get("category").toString();

				Category categoryChecker = categoryDao.queryBuilder().where().eq(Category.CATEGORY, sCategory).queryForFirst();

				if (categoryChecker == null) {
					categoryChecker = new Category();
					categoryChecker.category = sCategory;

					categoryDao.createIfNotExists(categoryChecker);
				}

				// Question
				Question question = new Question();
				question.category = categoryChecker;
				question.question = dataMap.get("question").toString();

				questionDao.createIfNotExists(question);

				// Options
				String[] options = dataMap.get("options").toString().split(";");
				for (int i = 0; i < options.length; i++) {
					String option = options[i];
					Options optionObj = new Options();

					optionObj.question = question;
					optionObj.option = option;

					optionsDao.createIfNotExists(optionObj);
				}
				Options ansOption = new Options();

				ansOption.question = question;
				ansOption.option = dataMap.get("answer").toString();

				optionsDao.createIfNotExists(ansOption);

				// Answer
				Answer answer = new Answer();

				answer.question = question;
				answer.option = ansOption;

				answerDao.createIfNotExists(answer);
			}
		} catch (FileNotFoundException e) {
			Log.e(TAG, "Error loading CSV file", e);
		} catch (IOException e) {
			Log.e(TAG, "Error loading header of the CSV file", e);
		} catch (SQLException e) {
			Log.e(TAG, "Error to read database", e);
		} finally {
			try {
				if (mapReader != null) mapReader.close();
			} catch (IOException e) {
				Log.e(TAG, "Unable to close CSV parser", e);
			}
		}
	}

	CellProcessor[] getProcessors() {
		final CellProcessor[] processors = new CellProcessor[]{
				new StrNotNullOrEmpty(),
				new StrNotNullOrEmpty(),
				new StrNotNullOrEmpty(),
				new StrNotNullOrEmpty()
		};
		return processors;
	}
}