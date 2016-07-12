package com.tahadelen.yemekmenusu;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.tahadelen.connectors.Database;
import com.tahadelen.datatypes.Food;
import com.tahadelen.datatypes.User;
import com.tahadelen.utils.ImageLoader;

public class YemekDetayi extends Activity {
	private static final String TAG = "YemekDetayi";

	private Food food;

	private TextView title;
	private TextView name;
	private TextView description;
	private Button backButton;
	private ImageView imageView;
	private ImageLoader imageLoader;

	Dialog dialog;
	private EditText number;
	private Button cancelButton;
	private Button addButton;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.fooddetail);

		title = (TextView) findViewById(R.id.fooddetail_title);
		backButton = (Button) findViewById(R.id.fooddetail_backButton);
		imageView = (ImageView) findViewById(R.id.fooddetail_imageView);
		name = (TextView) findViewById(R.id.fooddetail_name);
		description = (TextView) findViewById(R.id.fooddetail_descirption);

		imageLoader = new ImageLoader(this.getApplicationContext());

	}

	@Override
	public void onResume() {
		super.onResume();
		food = new Food();
		food.setId(this.getIntent().getIntExtra(Database.ID, -1));
		food.setCategory(this.getIntent().getIntExtra(Database.CAT, 0));
		food.setDescription(this.getIntent().getStringExtra(
				Database.DESCRIPTION));
		food.setImagePath(this.getIntent().getStringExtra(Database.IMAGEPATH));
		food.setName(this.getIntent().getStringExtra(Database.NAME));
		food.setPrice(this.getIntent().getDoubleExtra(Database.PRICE, 0.00));

		imageLoader.DisplayImage(food.getImagePath(), imageView);

		title.setText(food.getName());
		name.setText(food.getName());
		description.setText(food.getDescription());
	}

	public void backPressed(View view) {
		onBackPressed();
	}

	public void orders(View view) {
		startActivity(new Intent(this, Siparisler.class));
	}

	public void order(View view) {
		dialog = new Dialog(this);
		dialog.setContentView(R.layout.orderdialog);
		dialog.setTitle("Sipariþ Listeme Ekle");

		TextView foodName = (TextView) dialog.findViewById(R.id.order_foodname);
		foodName.setText(food.getName());

		addButton = (Button) dialog.findViewById(R.id.order_add);
		addButton.setOnClickListener(new AddClicked());

		cancelButton = (Button) dialog.findViewById(R.id.order_cancel);
		cancelButton.setOnClickListener(new CancelClicked());

		dialog.show();
	}

	private class AddClicked implements OnClickListener {
		@Override
		public void onClick(View arg0) {
			number = (EditText) dialog.findViewById(R.id.order_number);

			try {
				User.addOrder(food,
						Integer.parseInt(number.getText().toString()));
				dialog.dismiss();
				Toast.makeText(YemekDetayi.this, "Sipariþ listenize eklendi",
						Toast.LENGTH_LONG).show();
				backPressed(null);
			} catch (NumberFormatException e) {
				Log.e(TAG, "addClicked() -> NumberFormatException");
			}
		}
	}

	private class CancelClicked implements OnClickListener {

		@Override
		public void onClick(View v) {
			if (dialog.isShowing())
				dialog.dismiss();
		}

	}
}
