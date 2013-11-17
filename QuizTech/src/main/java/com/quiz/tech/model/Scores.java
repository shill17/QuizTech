package com.quiz.tech.model;

import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "results")
public class Scores extends BaseModel {

	// No-arg constructor
	public Scores() {
	}

	@DatabaseField(columnName = "session_id", canBeNull = false, foreign = true)
	public Session session;

	@DatabaseField(columnName = "score", dataType = DataType.INTEGER_OBJ)
	public Integer score;
}
