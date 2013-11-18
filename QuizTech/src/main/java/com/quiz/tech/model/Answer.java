package com.quiz.tech.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "answer")
public class Answer extends BaseModel {
	public static final String QUESTION_ID = "question_id";
	public static final String OPTION_ID = "option_id";

	// No-arg constructor
	public Answer() {
	}

	@DatabaseField(columnName = QUESTION_ID, canBeNull = false, foreign = true)
	public Question question;

	@DatabaseField(columnName = OPTION_ID, canBeNull = false, foreign = true)
	public Options option;
}
