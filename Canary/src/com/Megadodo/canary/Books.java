package com.Megadodo.canary;

import java.io.IOException;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import android.content.Context;
import android.content.res.XmlResourceParser;
import android.os.Bundle;
import android.util.Log;

public class Books {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected HashMap<String, String> mAuthors = null;
	protected Context mContext = null;
	
	public Books(Context aContext) {
		mAuthors = new HashMap<String,String>();
		mContext = aContext;
		
		System.out.println("Books is HERE");
		readData();
	}
	
	public Books() {
		mAuthors = new HashMap<String,String>();
		
		System.out.println("Books is HERE");
		readData();		
	}
	
	public Set<String> getTitles() {
		return mAuthors.keySet();
	}
	
	public String getAuthor(String aTitle) {
		return mAuthors.get(aTitle);
	}
	
	public Bundle getAsBundle() {
		Bundle bun = new Bundle();
		
		Set<String> titles = getTitles();
		Iterator<String> it = titles.iterator();
		
		while (it.hasNext()) {
			String title = it.next();
			String author = getAuthor(title);
			bun.putString(title, author);
		}
		
		return bun;
	}
	
	private void readData() {
		System.out.println("ReadData is HERE");
		XmlResourceParser xrp = mContext.getResources().getXml(R.xml.books);

		try {
			xrp.next();
			int eventType = xrp.getEventType();
			String title = ""; String author = "";
			while (eventType != XmlPullParser.END_DOCUMENT) {
			    if (eventType == XmlPullParser.START_TAG) {			    	
			    	if (xrp.getName().equalsIgnoreCase("book")) {
			    		title = ""; author = "";
			    	} else {
			    		if (xrp.getName().equalsIgnoreCase("title")) 
			    			title = xrp.nextText();
			    		else if (xrp.getName().equalsIgnoreCase("author"))
			    			author = xrp.nextText();
			    	}
			    } else {
			    	if (title.equalsIgnoreCase("") && author.equalsIgnoreCase("")) {
			    		
			    	} else {
			    		mAuthors.put(title, author);
			    		System.out.println("Title:" + title + "\tAuthor:" + author);
			    		Log.i("Books", "Title:" + title + "\tAuthor:" + author);
			    	}
			    }
			    eventType = xrp.next();
			}
		} catch (XmlPullParserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}
}
