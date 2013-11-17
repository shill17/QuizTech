package com.quiz.tech.model;

import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;

public class Question extends BaseModel{

	// No-arg constructor
	public Question() {
	}

	@DatabaseField(columnName = "category_id", canBeNull = false, foreign = true)
	public Category category;

	@DatabaseField(columnName = "question_text", canBeNull = false, dataType = DataType.STRING)
	public String questionText;
}