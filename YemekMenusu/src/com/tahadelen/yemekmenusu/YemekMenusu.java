package com.tahadelen.yemekmenusu;

import java.util.ArrayList;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.tahadelen.connectors.DBService;
import com.tahadelen.connectors.Database;
import com.tahadelen.connectors.ServerConnection;
import com.tahadelen.datatypes.Category;
import com.tahadelen.datatypes.Food;
import com.tahadelen.utils.DatabaseFiller;
import com.tahadelen.utils.Utils;

public class YemekMenusu extends Activity {
	private static final String TAG = "MainMenu";

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_menu);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main_menu, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.menu_sync:
			(new ServerControl(this)).execute();
			// DatabaseFiller.fill(this);
			break;
		case R.id.menu_clear:
			DBService service = new DBService(this);
			service.deleteAll();
			break;
		case R.id.menu_settings:
			startActivity(new Intent(this, SettingsActivity.class));
			break;
		}
		return super.onOptionsItemSelected(item);
	}

	public void fill(View view) {
		DatabaseFiller.fill(this);
	}

	public void feedbackClicked(View view) {
		startActivity(new Intent(this, Feedback.class));
	}

	public void aboutClicked(View view) {
		startActivity(new Intent(this, About.class));
	}

	public void list(View view) {
		Log.d("info", "" + this.getResources().getDisplayMetrics().density);
		Intent intent = new Intent(this, Yemekler.class);
		int id = view.getId();

		switch (id) {
		case R.id.anayemekler:
			Log.d(TAG, "anayemekler tiklandi ordinal -> "
					+ Category.ANAYEMEKLER.ordinal());
			intent.putExtra(Database.CAT, Category.ANAYEMEKLER.ordinal());
			break;
		case R.id.arasicaklar:
			Log.d(TAG, "arasicaklar tiklandi ordinal -> "
					+ Category.ARASICAKLAR.ordinal());
			intent.putExtra(Database.CAT, Category.ARASICAKLAR.ordinal());
			break;
		case R.id.corbalar:
			Log.d(TAG,
					"corbalar tiklandi ordinal -> "
							+ Category.CORBALAR.ordinal());
			intent.putExtra(Database.CAT, Category.CORBALAR.ordinal());
			break;
		case R.id.denizurunleri:
			Log.d(TAG, "denizurunleri tiklandi ordinal -> "
					+ Category.DENIZURUNLERI.ordinal());
			intent.putExtra(Database.CAT, Category.DENIZURUNLERI.ordinal());
			break;
		case R.id.hamurisleri:
			Log.d(TAG, "hamurisleri tiklandi ordinal -> "
					+ Category.HAMURISLERI.ordinal());
			intent.putExtra(Database.CAT, Category.HAMURISLERI.ordinal());
			break;
		case R.id.salatalar:
			Log.d(TAG,
					"salatalar tiklandi ordinal -> "
							+ Category.SALATALAR.ordinal());
			intent.putExtra(Database.CAT, Category.SALATALAR.ordinal());
			break;
		case R.id.sicakicecekler:
			Log.d(TAG, "sicakicecekler tiklandi ordinal -> "
					+ Category.SICAKICECEKLER.ordinal());
			intent.putExtra(Database.CAT, Category.SICAKICECEKLER.ordinal());
			break;
		case R.id.sogukicecekler:
			Log.d(TAG, "sogukicecekler tiklandi ordinal -> "
					+ Category.SOGUKICECEKLER.ordinal());
			intent.putExtra(Database.CAT, Category.SOGUKICECEKLER.ordinal());
			break;
		case R.id.tatlilar:
			Log.d(TAG,
					"tatlilar tiklandi ordinal -> "
							+ Category.TATLILAR.ordinal());
			intent.putExtra(Database.CAT, Category.TATLILAR.ordinal());
			break;
		default:
			return;
		}
		startActivity(intent);

	}

	private class ServerControl extends AsyncTask<Void, Void, Integer> {

		private Context context;
		private ProgressDialog pDialog;

		public ServerControl(Context context) {
			this.context = context;
			this.pDialog = new ProgressDialog(context);
		}

		@Override
		protected void onPreExecute() {
			Log.d("YemekMenusu", "ServerControl::onPreExecute()");
			if (!Utils.isOnline(YemekMenusu.this)) {
				final AlertDialog.Builder infoDialog = new AlertDialog.Builder(
						YemekMenusu.this);
				infoDialog.setMessage("Ýnternet baðlantýsý yok...");
				infoDialog.setPositiveButton("Tamam", new OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int arg1) {
						dialog.dismiss();
					}
				});
				infoDialog.create().show();
				this.cancel(false);
			} else {
				pDialog.setMessage("Lütfen Bekleyiniz...");
				pDialog.setCancelable(false);
				pDialog.show();
			}
		}

		@Override
		protected void onPostExecute(Integer result) {
			Log.d("YemekMenusu", "ServerControl::onPostExecute()");
			if (pDialog.isShowing())
				pDialog.dismiss();

			if (result == 0) {
				final AlertDialog.Builder infoDialog = new AlertDialog.Builder(
						YemekMenusu.this);
				infoDialog.setMessage("Güncelleme iþlemi baþarýsýz...");
				infoDialog.setPositiveButton("Tamam", new OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int arg1) {
						dialog.dismiss();
					}
				});
				infoDialog.create().show();
				this.cancel(false);
			} else {
				final AlertDialog.Builder infoDialog = new AlertDialog.Builder(
						YemekMenusu.this);
				infoDialog.setMessage("Güncelleme iþlemi baþarýlý...");
				infoDialog.setPositiveButton("Tamam", new OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int arg1) {
						dialog.dismiss();
					}
				});
				infoDialog.create().show();
				this.cancel(false);
			}
		}

		@Override
		protected Integer doInBackground(Void... arg0) {
			Log.d("YemekMenusu", "ServerControl::doInBackground()");
			ServerConnection server = new ServerConnection(context);
			ArrayList<Food> result = server.sync();

			if (result == null)
				return 0;
			return 1;
		}
	}

	public void orders(View view) {
		startActivity(new Intent(this, Siparisler.class));
	}
}
