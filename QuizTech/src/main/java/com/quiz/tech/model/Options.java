package com.quiz.tech.model;

import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "options")
public class Options extends BaseModel {
	public static final String QUESTION_ID = "question_id";
	public static final String OPTION = "option";

	// No-arg constructor
	public Options() {
	}

	@DatabaseField(columnName = QUESTION_ID, canBeNull = false, foreign = true)
	public Question question;

	@DatabaseField(columnName = OPTION, dataType = DataType.STRING)
	public String option;
}