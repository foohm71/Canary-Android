package com.Megadodo.canary;

import android.os.Bundle;
import android.os.Parcelable;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

	protected EditText mEditText = null;
	protected TextView mLabel = null;
	protected Button mModifyTextButton = null;
	protected Button mSwitchViewButton = null;
	// protected Bundle mBooksData = null;
	protected Books mBooks = null;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       
        Log.i("MainActivity", "Started!!!!!!");
        mEditText = (EditText) findViewById(R.id.editText);
        mLabel = (TextView) findViewById(R.id.label);
        
        mModifyTextButton = (Button) findViewById(R.id.modifyTextButton);
        mModifyTextButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String text = mEditText.getText().toString();
				
				if (text.contains("idiot")) {
					Toast t = Toast.makeText(MainActivity.this, "Please be civil!!", 3000);
					t.setGravity(Gravity.CENTER, 0, 0);
					t.show();
				} else {
					mLabel.setText(text);
				}
			}
        	
        });
        
        mSwitchViewButton = (Button) findViewById(R.id.switchViewButton);    
        
		mSwitchViewButton.setEnabled(false);
        mBooks = getBooksData();        	
        mSwitchViewButton.setEnabled(true);
        
        mSwitchViewButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(MainActivity.this, SecondActivity.class);
				
				// This part adds additional data as a payload
				intent.putExtras(mBooks.getAsBundle());
				
        		startActivity(intent);
			}
        });
        

        
/*        Thread trd = new Thread(new Runnable() {
        	@Override
        	public void run() {
        		mSwitchViewButton.setEnabled(false);
                mBooks = getBooksData();        	
                mSwitchViewButton.setEnabled(true);
        	}
        });
        trd.run();
*/        
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
    private Books getBooksData() {
    	Books books = new Books(MainActivity.this);
    	
    	return books;
    }
}
