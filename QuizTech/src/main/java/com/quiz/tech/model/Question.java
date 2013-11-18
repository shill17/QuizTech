package com.quiz.tech.model;

import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;

public class Question extends BaseModel{
	public static final String CATEGORY_ID = "category_id";
	public static final String QUESTION = "question";

	// No-arg constructor
	public Question() {
	}

	@DatabaseField(columnName = CATEGORY_ID, canBeNull = false, foreign = true)
	public Category category;

	@DatabaseField(columnName = QUESTION, canBeNull = false, dataType = DataType.STRING)
	public String question;
}