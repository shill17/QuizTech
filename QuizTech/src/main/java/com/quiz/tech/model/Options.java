package com.quiz.tech.model;

import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "options")
public class Options extends BaseModel {

	// No-arg constructor
	public Options() {
	}

	@DatabaseField(columnName = "question_id", canBeNull = false, foreign = true)
	public Question question;

	@DatabaseField(columnName = "option_text", dataType = DataType.STRING)
	public String optionText;
}