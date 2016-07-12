package com.tahadelen.utils;

import java.util.ArrayList;
import java.util.HashMap;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.tahadelen.connectors.Database;
import com.tahadelen.yemekmenusu.R;

public class LazyAdapter extends BaseAdapter {

	private Activity activity;
	private ArrayList<HashMap<String, String>> data;
	private static LayoutInflater inflater = null;
	public ImageLoader imageLoader;

	public LazyAdapter(Activity a, ArrayList<HashMap<String, String>> d) {
		activity = a;
		data = d;
		inflater = (LayoutInflater) activity
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		imageLoader = new ImageLoader(activity.getApplicationContext());
	}

	public int getCount() {
		return data.size();
	}

	public Object getItem(int position) {
		return position;
	}

	public long getItemId(int position) {
		return position;
	}

	public View getView(int position, View convertView, ViewGroup parent) {
		View vi = convertView;
		if (convertView == null)
			vi = inflater.inflate(R.layout.list_row, null);

		TextView name = (TextView) vi.findViewById(R.id.name);
		TextView description = (TextView) vi.findViewById(R.id.description);
		TextView price = (TextView) vi.findViewById(R.id.price);
		ImageView thumb_image = (ImageView) vi.findViewById(R.id.list_image);

		HashMap<String, String> food = new HashMap<String, String>();
		food = data.get(position);

		name.setText(food.get(Database.NAME));
		description.setText(food.get(Database.DESCRIPTION));
		price.setText(food.get(Database.PRICE) + " TL");
		imageLoader.DisplayImage(
				food.get(Database.IMAGEPATH).replaceAll(" ", "%20"),
				thumb_image);

		return vi;
	}
}