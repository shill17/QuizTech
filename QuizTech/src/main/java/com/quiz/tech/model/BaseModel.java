package com.quiz.tech.model;

import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;

import java.util.Date;

public class BaseModel {
	public static final String ID = "_id";
	public static final String CREATED_AT = "created_at";
	public static final String LAST_MODIFIED_AT = "last_modified_at";

	// No-arg constructor
	public BaseModel() {
	}

	@DatabaseField(columnName = ID, generatedId = true, dataType = DataType.LONG_OBJ)
	public Long id;

	@DatabaseField(columnName = CREATED_AT, canBeNull = false, dataType = DataType.DATE_STRING)
	public Date createdAt = new Date();

	@DatabaseField(columnName = LAST_MODIFIED_AT, canBeNull = false, dataType = DataType.DATE_STRING)
	public Date lastModifiedAt = new Date();
}