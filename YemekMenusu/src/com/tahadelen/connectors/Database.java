package com.tahadelen.connectors;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Database extends SQLiteOpenHelper {

	public static final String ID = "id";
	public static final String NAME = "name";
	public static final String CAT = "category";
	public static final String DESCRIPTION = "description";
	public static final String PRICE = "price";
	public static final String IMAGEPATH = "imagepath";

	public static final String TABLE = "food";

	private static final String CREATETABLE = "create table " + TABLE + " ("
			+ ID + " integer, " + NAME + " text not null, " + CAT
			+ " integer not null, " + DESCRIPTION + " text not null, " + PRICE
			+ " real not null, " + IMAGEPATH + " text);";

	private static final String DB_NAME = "monu.db";
	private static final int DB_VERSION = 5;

	public Database(Context context) {
		super(context, DB_NAME, null, DB_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL(CREATETABLE);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int arg1, int arg2) {
		db.execSQL("DROP TABLE IF EXISTS " + TABLE);
		onCreate(db);
	}

}
