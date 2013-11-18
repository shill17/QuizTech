package com.quiz.tech.model;

import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "results")
public class Scores extends BaseModel {
	public static final String SESSION_ID = "session_id";
	public static final String SCORE = "score";

	// No-arg constructor
	public Scores() {
	}

	@DatabaseField(columnName = SESSION_ID, canBeNull = false, foreign = true)
	public Session session;

	@DatabaseField(columnName = SCORE, dataType = DataType.INTEGER_OBJ)
	public Integer score;
}
