package com.Megadodo.Canary.test;

import java.util.Set;

import com.Megadodo.canary.Books;
import com.Megadodo.canary.MainActivity;
import com.Megadodo.canary.R;

import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import android.content.Context;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

@RunWith(RobolectricTestRunner.class)
public class CanaryUnitTests {

	private Books mBooks = null;
	
	@Before
	public void setup() {
		Context context = Robolectric.getShadowApplication().getApplicationContext();
		mBooks = new Books(context);
	}
	
    @Test
    public void testTitles() throws Exception {
    	Set<String> titles = mBooks.getTitles();
        assertTrue(titles.size() > 0);
    }
    
    @Test
    public void testGetAuthor() throws Exception {
    	assertEquals("Get Author for 'The art of war'", mBooks.getAuthor("The art of war"), "Sun Tzu");
    }
}