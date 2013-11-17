package com.quiz.tech.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "answer")
public class Answer extends BaseModel {

	// No-arg constructor
	public Answer() {
	}

	@DatabaseField(columnName = "question_id", canBeNull = false, foreign = true)
	public Question question;

	@DatabaseField(columnName = "option_id", canBeNull = false, foreign = true)
	public Options option;
}
