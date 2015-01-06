package com.KengKamon.buddyremote;

import com.KengKamon.Welcome.LogIn_Activity;
import com.KengKamon.library.UserFunctions;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.widget.Button;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class LogOutFragment extends Fragment {
	UserFunctions userFunctions;
	Button btnLogout;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		/**
		 * Dashboard Screen for the application
		 * */

		// Check login status in database
		userFunctions = new UserFunctions();
		if (!userFunctions.isUserLoggedIn(getActivity().getApplicationContext())) {
			
			// user is not logged in show login screen
			Intent login = new Intent(getActivity().getApplicationContext(),
					LogIn_Activity.class);
			login.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			startActivity(login);

		};

		// user is  logged in show dashboard

		View rootview = inflater.inflate(R.layout.frahment_logout, container,
				false);

		btnLogout = (Button) rootview.findViewById(R.id.btnLogout);

		btnLogout.setOnClickListener(new View.OnClickListener() {

			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				userFunctions.logoutUser(getActivity().getApplicationContext());
				Intent login = new Intent(
						getActivity().getApplicationContext(),
						LogIn_Activity.class);
				login.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				startActivity(login);
				// Closing dashboard screen
				// finish();
			}
		});
		return rootview ;
	}
}
