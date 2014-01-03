package com.Megadodo.canary;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import android.os.Bundle;
import android.app.Activity;
import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class SecondActivity extends ListActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_second);

		Intent intent = getIntent();
		// Bundle books = intent.getExtras().getBundle("books");
		Bundle books = intent.getExtras();
	
		/*
		final ArrayList<String> list = new ArrayList<String>();		
		for (int i = 0; i < 10; i++) { list.add("Item " + (i + 1)); } 
		setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, list));
		*/
		
		Set<String> keys = books.keySet();
		String[] titles = new String[keys.size()];
		Log.i("OnCreate", "Size " + keys.size());
		Iterator<String> it = keys.iterator(); 
		int i = 0;
		while (it.hasNext()) {
			titles[i] = it.next();
			Log.i("OnCreate", "Key " + titles[i]);
			i++;
		}
		setListAdapter(new ListAdapter(this, books, titles));
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.second, menu);
		return true;
	}

	
	private class ListAdapter extends ArrayAdapter<String> {

		private Bundle mBundle = null;
		private Context mContext = null;
		private String[] mKeys = null; 
		
		public ListAdapter(Context context, Bundle bundle, String[] keys) {
			super(context, R.layout.book_layout, keys);
			// TODO Auto-generated constructor stub
			mContext = context;
			mBundle = bundle;
			mKeys = keys;			

		}
	
		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
		    LayoutInflater inflater = (LayoutInflater) mContext
		            .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		    View rowView = inflater.inflate(R.layout.book_layout, parent, false);
		    TextView title = (TextView) rowView.findViewById(R.id.title);
		    title.setText(mKeys[position]);
		    TextView author = (TextView) rowView.findViewById(R.id.author);
		    author.setText(mBundle.getString(mKeys[position]));
		    Log.i("getView", "Position:" + position + " Title:" + mKeys[position] + 
		    		" Author:" + mBundle.getString(mKeys[position]));
		        
			return rowView;
		}
	}
	
}
