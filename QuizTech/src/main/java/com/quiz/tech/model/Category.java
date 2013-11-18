package com.quiz.tech.model;

import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "category")
public class Category extends BaseModel {
	// No-arg constructor
	public Category() {
	}

	public Category(String categoryName) {
		this.categoryName = categoryName;
	}

	@DatabaseField(canBeNull = false, dataType = DataType.STRING, width = 30)
	public String categoryName;
}