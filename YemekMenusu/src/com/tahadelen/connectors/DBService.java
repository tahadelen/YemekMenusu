package com.tahadelen.connectors;

import java.util.ArrayList;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.tahadelen.datatypes.Food;

public class DBService {

	private String[] columns = { Database.CAT, Database.DESCRIPTION,
			Database.ID, Database.IMAGEPATH, Database.NAME, Database.PRICE };

	private Database db;
	private SQLiteDatabase database;

	public DBService(Context context) {
		db = new Database(context);
	}

	public Food insert(Food food) {
		ContentValues values = new ContentValues();
		values.put(Database.ID, food.getId());
		values.put(Database.NAME, food.getName());
		values.put(Database.CAT, food.getCategory());
		values.put(Database.DESCRIPTION, food.getDescription());
		values.put(Database.IMAGEPATH, food.getImagePath());
		values.put(Database.PRICE, food.getPrice());

		database = db.getWritableDatabase();
		long id = database.insert(Database.TABLE, null, values);
		database.close();

		food.setId((int) id);

		return food;
	}

	public ArrayList<Food> getFoodsByCat(int category) {
		ArrayList<Food> result = new ArrayList<Food>();

		database = db.getReadableDatabase();
		Cursor cursor = database.query(Database.TABLE, columns, Database.CAT
				+ " = " + category, null, null, null, null);

		if (!cursor.moveToFirst()) {
			database.close();
			cursor.close();
			return result;
		}

		while (!cursor.isAfterLast()) {
			result.add(cursorToFood(cursor));
			cursor.moveToNext();
		}

		database.close();
		cursor.close();

		return result;
	}

	public ArrayList<Food> getAllFoods() {
		ArrayList<Food> result = new ArrayList<Food>();

		database = db.getReadableDatabase();
		Cursor cursor = database.query(Database.TABLE, columns, null, null,
				null, null, null);

		if (!cursor.moveToFirst()) {
			database.close();
			cursor.close();
			return result;
		}

		while (!cursor.isAfterLast()) {
			result.add(cursorToFood(cursor));
			cursor.moveToNext();
		}

		database.close();
		cursor.close();

		return result;
	}

	public int getLastInsertedId() {
		database = db.getReadableDatabase();
		String query = "select max(id) as max_id from " + Database.TABLE;
		Cursor cursor = database.rawQuery(query, null);
		int lastInserted = 0;
		if (cursor.moveToFirst())
			lastInserted = cursor.getInt(0);
		database.close();
		cursor.close();
		return lastInserted;
	}

	public void deleteAll() {
		database = db.getWritableDatabase();
		database.delete(Database.TABLE, null, null);
		database.close();
	}

	private Food cursorToFood(Cursor cursor) {
		Food food = new Food();
		food.setCategory(cursor.getInt(cursor.getColumnIndex(Database.CAT)));
		food.setDescription(cursor.getString(cursor
				.getColumnIndex(Database.DESCRIPTION)));
		food.setId(cursor.getInt(cursor.getColumnIndex(Database.ID)));
		food.setImagePath(cursor.getString(cursor
				.getColumnIndex(Database.IMAGEPATH)));
		food.setName(cursor.getString(cursor.getColumnIndex(Database.NAME)));
		food.setPrice(cursor.getDouble(cursor.getColumnIndex(Database.PRICE)));
		return food;
	}
}
