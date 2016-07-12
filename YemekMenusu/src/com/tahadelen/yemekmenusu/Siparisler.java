package com.tahadelen.yemekmenusu;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashMap;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.tahadelen.connectors.Client;
import com.tahadelen.connectors.Database;
import com.tahadelen.datatypes.Food;
import com.tahadelen.datatypes.Settings;
import com.tahadelen.datatypes.User;
import com.tahadelen.utils.LazyAdapter;

public class Siparisler extends Activity {

	private ListView list;
	private TextView priceInfo;

	private AlertDialog.Builder infoDialog;

	private ArrayList<Food> foods;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.user);

		list = (ListView) findViewById(R.id.user_list);
		priceInfo = (TextView) findViewById(R.id.user_priceinfo);

		infoDialog = new AlertDialog.Builder(this);
	}

	@Override
	public void onResume() {
		super.onResume();
		fillListView();
		User.calculateTotalPrice();
		priceInfo.setText("Toplam Tutar: " + User.getTotalPrice());
	}

	public void fillListView() {
		foods = User.getOrders();
		ArrayList<HashMap<String, String>> foodList = new ArrayList<HashMap<String, String>>();

		for (Food food : foods) {
			HashMap<String, String> map = new HashMap<String, String>();

			map.put(Database.NAME, food.getName());
			map.put(Database.DESCRIPTION, food.getDescription());
			map.put(Database.IMAGEPATH, food.getImagePath());
			map.put(Database.PRICE, "" + food.getPrice());

			foodList.add(map);
		}

		LazyAdapter adapter = new LazyAdapter(this, foodList);
		list.setAdapter(adapter);
		list.setOnItemClickListener(new ListItemClickListener());
	}

	public void backPressed(View view) {
		startActivity(new Intent(this, YemekMenusu.class));
	}

	public void finishOrder(View view) {
		(new Client(foods, this)).execute();
	}

	private class ListItemClickListener implements OnItemClickListener {
		@Override
		public void onItemClick(AdapterView<?> parent, View view,
				final int position, long which) {
			infoDialog.setMessage(foods.get(position).getName()
					+ " - Silmek istediðinizden emin misiniz?");
			infoDialog.setPositiveButton("Evet",
					new DialogInterface.OnClickListener() {
						@Override
						public void onClick(DialogInterface arg0, int arg1) {
							arg0.dismiss();
							User.deleteOrder(position);
							fillListView();
						}
					});
			infoDialog.setNegativeButton("Hayýr",
					new DialogInterface.OnClickListener() {
						@Override
						public void onClick(DialogInterface arg0, int arg1) {
							arg0.dismiss();
						}
					});
			infoDialog.create().show();
		}
	}
}
