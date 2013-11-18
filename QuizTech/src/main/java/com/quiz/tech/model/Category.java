package com.quiz.tech.model;

import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "category")
public class Category extends BaseModel {
	public static final String CATEGORY = "category_name";

	// No-arg constructor
	public Category() {
	}

	@DatabaseField(columnName = CATEGORY,canBeNull = false, dataType = DataType.STRING, width = 30)
	public String category;
}