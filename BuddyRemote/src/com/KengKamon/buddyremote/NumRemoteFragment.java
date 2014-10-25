package com.KengKamon.buddyremote;

import android.support.v4.app.Fragment;
//import android.app.Fragment;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;

//เอาใว้ดูlogตำแหน่งที่ถูกลือก

public class NumRemoteFragment extends Fragment { // Error ตรงfragment
	// แก้เป็นActivityเเล้วจะหาย

	Button button1;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_num_remote, container,
				false);
		// PowerButton
		button1 = (Button) view.findViewById(R.id.button1);
		button1.setOnClickListener(new OnClickListener() {
			//เล่นเพลงบนปุ่มpow
			public void onClick(View v) {
				MediaPlayer mpEffect = MediaPlayer.create(getActivity(),
						R.raw.power);
				mpEffect.start();
				//รอจับเพลงว่าเล่นจบยัง เพื่อรอเคลียบัฟเฟอร์
				mpEffect.setOnCompletionListener(new OnCompletionListener() {
				    public void onCompletion(MediaPlayer mp) {
				    	 mp.release();

				    }
				});

			}
		});

		return view;
	}

}
