package com.quiz.tech.model;

import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.misc.BaseDaoEnabled;

import java.util.Date;
import java.util.UUID;

public class BaseModel {

	// No-arg constructor
	public BaseModel() {
	}

	@DatabaseField(columnName = "_id", generatedId = true, dataType = DataType.UUID)
	public UUID id = UUID.randomUUID();

	@DatabaseField(columnName = "created_at", canBeNull = false, dataType = DataType.DATE_STRING)
	public Date createdAt;

	@DatabaseField(columnName = "last_modified_at", canBeNull = false, dataType = DataType.DATE_STRING)
	public Date lastModifiedAt;
}