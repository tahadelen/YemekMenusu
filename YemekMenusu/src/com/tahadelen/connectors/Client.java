package com.tahadelen.connectors;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import com.tahadelen.datatypes.Food;
import com.tahadelen.datatypes.Settings;
import com.tahadelen.datatypes.User;
import com.tahadelen.yemekmenusu.Siparisler;

public class Client extends AsyncTask<Void, Void, Boolean> {
	private static final String TAG = "Client";

	private ArrayList<Food> _foods;
	private Socket _clientSocket;
	private ObjectOutputStream _outputStream;

	private Context _context;
	private Siparisler _activity;
	private ProgressDialog _dialog;

	public Client(ArrayList<Food> foods, Siparisler activity) {
		this._activity = activity;
		_context = activity;
		_dialog = new ProgressDialog(_context);
		_foods = foods;
	}

	protected void onPreExecute() {
		_dialog.setTitle("Sipariþler");
		_dialog.setMessage("Sipariþ iþlemi tamamlanýyor...");
		_dialog.setCancelable(false);
		_dialog.show();
	}

	@Override
	protected Boolean doInBackground(Void... params) {
		try {
			_clientSocket = new Socket("192.168.2.73", Settings.PORT);
			_outputStream = new ObjectOutputStream(
					_clientSocket.getOutputStream());
			for (Food food : _foods) {
				_outputStream.writeObject(food);
			}

			Food endFood = new Food();
			endFood.setId(-1);
			_outputStream.writeObject(endFood);
		} catch (UnknownHostException e) {
			Log.e(TAG, "run()-> UnknownHostException");
			e.printStackTrace();
			return false;
		} catch (IOException e) {
			Log.e(TAG, "run()-> IOException");
			e.printStackTrace();
			return false;
		}

		User.freeOrders();
		return true;
	}

	protected void onPostExecute(Boolean result) {
		if (_dialog.isShowing())
			_dialog.dismiss();

		if (result) {
			User.freeOrders();
			_activity.fillListView();
			Toast.makeText(_context, "Sipariþ iþlemi tamamlandý",
					Toast.LENGTH_LONG).show();
		} else
			Toast.makeText(_context, "Sipariþ iþlemi tamamlanamadý",
					Toast.LENGTH_LONG).show();
	}
}
