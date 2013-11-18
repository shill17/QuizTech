package com.quiz.tech.activity.fragment;


import android.support.v4.app.Fragment;
import android.util.Log;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.j256.ormlite.dao.Dao;
import com.quiz.tech.activity.R;
import com.quiz.tech.adapter.OptionsAdapter;
import com.quiz.tech.database.DatabaseHelper;
import com.quiz.tech.model.Options;
import com.quiz.tech.model.Question;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.FragmentArg;
import org.androidannotations.annotations.ItemClick;
import org.androidannotations.annotations.OrmLiteDao;
import org.androidannotations.annotations.ViewById;

import java.sql.SQLException;

@EFragment(R.layout.fragment_quiz)
public class QuizFragment extends Fragment {
	private static final String TAG = "QuizFragment";

	@ViewById(R.id.list_quiz_options)
	ListView optionsList;

	OptionsAdapter adapter;

	@OrmLiteDao(helper = DatabaseHelper.class, model = Question.class)
	Dao<Question, Long> questionDao;

	@FragmentArg("questionId")
	Long questionId;

	@ViewById(R.id.tv_question)
	TextView tvQuestion;

	@AfterViews
	public void playQuiz() {
		try {
			tvQuestion.setText(questionDao.queryForId(questionId).question);
		} catch (SQLException e) {
			Log.e(TAG, "Unable to retrieve question", e);
		}
		adapter = new OptionsAdapter(getActivity(), questionId);
		optionsList.setAdapter(adapter);
	}

	@ItemClick(R.id.list_quiz_options)
	void optionsListItemClicked(Options option) {
		Toast.makeText(getActivity(), "Soemthing", Toast.LENGTH_LONG).show();
	}
}