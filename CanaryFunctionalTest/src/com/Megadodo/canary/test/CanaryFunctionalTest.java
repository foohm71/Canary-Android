package com.Megadodo.canary.test;

import com.Megadodo.canary.*;
import com.jayway.android.robotium.solo.Solo;

import android.test.ActivityInstrumentationTestCase2;

public class CanaryFunctionalTest extends
		ActivityInstrumentationTestCase2<MainActivity> {

	private Solo mSolo = null;
	
	public CanaryFunctionalTest() {
		super("com.Megadodo.canary", MainActivity.class);
		// TODO Auto-generated constructor stub
	}

	protected void setUp() throws Exception {
		super.setUp();
		
		mSolo = new Solo(getInstrumentation(), getActivity());
	}

	public void testClickSwitchViewButton() {
		mSolo.assertCurrentActivity("Checks correct Actvity Class", MainActivity.class);
		mSolo.clickOnButton("Switch View");
		mSolo.sleep(3000);
		mSolo.assertCurrentActivity("Checks correct Actvity Class", SecondActivity.class);
	}
	
	protected void tearDown() throws Exception {
		super.tearDown();
	}

}
