package com.KengKamon.buddyremote;

import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.ActionBar.TabListener;
//import android.app.Activity;
//import android.support.v4.app.Fragment;
import android.view.Window;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.util.Log; //เน€เธญเธฒเน�เธงเน�เธ”เธนlogเธ•เธณเน�เธซเธ�เน�เธ�เธ—เธตเน�เธ–เธนเธ�เธฅเธทเธญเธ�
import android.widget.Button;

public class Main extends FragmentActivity implements TabListener {

	Button button1;

	private static final String STATE_SELECTED_NAVIGATION_ITEM = "selected_nav_item";
	private static final String TAG = "tabapp";

	private ViewPager viewPager;
	private TabsPagerAdapter mAdapter;
	private ActionBar actionBar;

	// Tab titles
	// private String[] tabs = { "Num", "Pad" };

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		//splash screen
		 //requestWindowFeature(Window.FEATURE_NO_TITLE);
			

	// Initilization
		viewPager = (ViewPager) findViewById(R.id.fragment_container);
		actionBar = getActionBar();
		mAdapter = new TabsPagerAdapter(getSupportFragmentManager());

		viewPager.setAdapter(mAdapter);
		actionBar.setHomeButtonEnabled(false);
		// actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

		// Create Tab
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

		actionBar.addTab(actionBar.newTab().setText("NUM") //create num tab
															
				.setTabListener(this));

		actionBar.addTab(actionBar.newTab().setText("Pad") //create pad tap
															
				.setTabListener(this));

		viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

			@Override
			public void onPageSelected(int position) {
				// on changing the page
				// keep position when you touch tab
				actionBar.setSelectedNavigationItem(position);
			}

			@Override
			public void onPageScrollStateChanged(int arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {
				// TODO Auto-generated method stub

			}
		});

	}

	// Method เน€เธงเธฅเธฒเน€เธ�เธ�เธ�เน�เธฒเน€เธกเธทเน�เธญเธซเธกเธธเธ�เธซเธ�เน�เธฒเธ�เธญ (เธ�เน�เธฒเธ�เธฐเธฅเธ�เธ—เธดเน�เธ�เน�เธ”เน�)
	@Override
	public void onSaveInstanceState(Bundle outState) {
		outState.putInt(STATE_SELECTED_NAVIGATION_ITEM, getActionBar()
				.getSelectedNavigationIndex());
	}

	// Method เน€เธงเธฅเธฒเธ�เธทเธ�เธ�เน�เธฒเน€เธกเธทเน�เธญเธซเธกเธธเธ�เธซเธ�เน�เธฒเธ�เธญ (เธ�เน�เธฒเธ�เธฐเธฅเธ�เธ—เธดเน�เธ�เน�เธ”เน�)
	@Override
	public void onRestoreInstanceState(Bundle savedInstanceState) {
		if (savedInstanceState.containsKey(STATE_SELECTED_NAVIGATION_ITEM)) {
			getActionBar().setSelectedNavigationItem(
					savedInstanceState.getInt(STATE_SELECTED_NAVIGATION_ITEM));
		}
	}

	@Override
	public void onTabSelected(Tab tab, FragmentTransaction ft) {

		Log.d(TAG, "tab pos " + tab.getPosition()); // keep log when tap

		viewPager.setCurrentItem(tab.getPosition());
	}

	@Override
	public void onTabUnselected(Tab tab, FragmentTransaction ft) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onTabReselected(Tab tab, FragmentTransaction ft) {
		// TODO Auto-generated method stub

	}
}
