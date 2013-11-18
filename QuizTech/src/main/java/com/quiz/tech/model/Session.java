package com.quiz.tech.model;

import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.util.UUID;

@DatabaseTable(tableName = "session")
public class Session extends BaseModel {
	public static final String QUESTION_ID = "question_id";
	public static final String CHOSEN_OPTION_ID = "chosen_option_id";

	// No-arg constructor
	public Session() {
	}

	@DatabaseField(columnName = QUESTION_ID, canBeNull = false, foreign = true)
	public Question question;

	@DatabaseField(columnName = CHOSEN_OPTION_ID, dataType = DataType.UUID)
	public UUID chosenOptionId;
}
