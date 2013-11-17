package com.quiz.tech.model;

import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.util.UUID;

@DatabaseTable(tableName = "session")
public class Session extends BaseModel {

	// No-arg constructor
	public Session() {
	}

	@DatabaseField(columnName = "question_id", canBeNull = false, foreign = true)
	public Question question;

	@DatabaseField(columnName = "chosen_option_id", dataType = DataType.UUID)
	public UUID chosenOptionId;
}
