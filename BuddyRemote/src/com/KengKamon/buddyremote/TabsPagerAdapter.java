package com.KengKamon.buddyremote;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;



public class TabsPagerAdapter  extends FragmentPagerAdapter {
	  public TabsPagerAdapter(FragmentManager fm) {
	        super(fm);
	    }
	 
	    @Override
	    public Fragment getItem(int index) {
	 
	        switch (index) {
	        case 0:
	            // Top Rated fragment activity
	            return new NumRemoteFragment();
	        case 1:
	            // Games fragment activity
	            return new PadFragment();
	       
	        }
	        return null;
	    }
	 



		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return 2;
		}
}