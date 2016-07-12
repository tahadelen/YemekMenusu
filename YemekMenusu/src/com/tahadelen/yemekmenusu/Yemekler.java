package com.tahadelen.yemekmenusu;

import java.util.ArrayList;
import java.util.HashMap;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;

import com.tahadelen.connectors.DBService;
import com.tahadelen.connectors.Database;
import com.tahadelen.datatypes.Category;
import com.tahadelen.datatypes.Food;
import com.tahadelen.utils.LazyAdapter;

public class Yemekler extends Activity {

	private int cat;
	ArrayList<Food> foods;

	private ListView list;
	private TextView title;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.foods);

		title = (TextView) findViewById(R.id.foods_title);
		list = (ListView) findViewById(R.id.list);
	}

	@Override
	public void onResume() {
		super.onResume();
		Bundle extras = this.getIntent().getExtras();
		cat = extras.getInt(Database.CAT);

		title.setText(Category.catNames[cat]);

		fillListView();
	}

	public void backPressed(View view) {
		startActivity(new Intent(this, YemekMenusu.class));
	}

	private void fillListView() {
		DBService service = new DBService(this);
		foods = service.getFoodsByCat(cat);
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

	public void orders(View view) {
		startActivity(new Intent(this, Siparisler.class));
	}

	private class ListItemClickListener implements OnItemClickListener {

		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position,
				long which) {
			Intent intent = new Intent(Yemekler.this, YemekDetayi.class);
			intent.putExtra(Database.ID, foods.get(position).getId());
			intent.putExtra(Database.CAT, foods.get(position).getCategory());
			intent.putExtra(Database.IMAGEPATH, foods.get(position)
					.getImagePath());
			intent.putExtra(Database.NAME, foods.get(position).getName());
			intent.putExtra(Database.DESCRIPTION, foods.get(position)
					.getDescription());
			intent.putExtra(Database.PRICE, foods.get(position).getPrice());
			startActivity(intent);
		}

	}
}
