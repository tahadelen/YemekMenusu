package com.tahadelen.yemekmenusu;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

public class Feedback extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.feedback);
	}

	public void backClicked(View view) {
		onBackPressed();
	}

}
