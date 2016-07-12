package com.tahadelen.connectors;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.Environment;
import android.util.Log;

import com.tahadelen.datatypes.Food;

public class ServerConnection {
	private static final String TAG = "ServerConnection";

	private Context context;
	private static final String url = "jdbc:mysql://halit.biz:3306/halit_taha";
	private static final String user = "halit_tahadelen";
	private static final String pass = "taha1989";

	public ServerConnection(Context context) {
		this.context = context;
	}

	public boolean controlVersion() {
		DBService dbService = new DBService(context);
		int localLastId = dbService.getLastInsertedId();
		int serverLastId = 0;

		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(url, user, pass);
			Statement statement = connection.createStatement();
			ResultSet result = statement.executeQuery("select max(id) as id "
					+ "from " + Database.TABLE + ";");
			result.first();
			serverLastId = result.getInt(result.findColumn("id"));
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		Log.d("controlVersion", "localLastId=" + localLastId + " serverLastId="
				+ serverLastId);

		if (localLastId == serverLastId)
			return true;
		else
			return false;
	}

	public ArrayList<Food> sync() {
		DBService dbService = new DBService(context);
		dbService.deleteAll();
		Connection connection = null;
		ArrayList<Food> foods = new ArrayList<Food>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(url, user, pass);
			Statement statement = connection.createStatement();
			ResultSet result = statement.executeQuery("select * from "
					+ Database.TABLE + ";");
			if (result.first()) {
				Log.d("snyc", "resultset size -> " + result.getRow());
				while (!result.isAfterLast()) {
					Food food = resultSetToFood(result);
					foods.add(dbService.insert(food));
					result.next();
				}
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

		return foods;
	}

	public Food resultSetToFood(ResultSet result) throws SQLException {
		Food food = new Food();
		food.setCategory(result.getInt(Database.CAT));
		food.setDescription(result.getString(Database.DESCRIPTION));
		food.setId(result.getInt(Database.ID));
		food.setImagePath(result.getString(Database.IMAGEPATH));
		food.setName(result.getString(Database.NAME));
		food.setPrice(result.getDouble(Database.PRICE));
		return food;
	}
}
