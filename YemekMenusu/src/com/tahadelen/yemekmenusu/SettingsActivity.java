package com.tahadelen.yemekmenusu;

import com.tahadelen.datatypes.Food;
import com.tahadelen.datatypes.Settings;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class SettingsActivity extends Activity {

	private TextView _tableNumberTextView;
	private TextView _ipNumberTextView;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.settings);

		_tableNumberTextView = (TextView) findViewById(R.id.settings_tablenum);
		_ipNumberTextView = (TextView) findViewById(R.id.settings_ipnum);

	}

	public void saveClicked(View view) {
		Settings._serverAddress = _ipNumberTextView.getText().toString();
		Settings._tableNum = Integer.parseInt(_tableNumberTextView.getText()
				.toString());
	}
}
