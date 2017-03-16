package com.example.mygesture;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.gesture.Gesture;
import android.gesture.GestureLibraries;
import android.gesture.GestureLibrary;
import android.gesture.GestureOverlayView;
import android.gesture.GestureOverlayView.OnGestureListener;
import android.gesture.GestureOverlayView.OnGesturePerformedListener;
import android.gesture.Prediction;
import android.view.Menu;
import android.view.MotionEvent;
import android.widget.Toast;

public class MainActivity extends Activity implements OnGesturePerformedListener {

	GestureOverlayView golv;
	private GestureLibrary lib;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		this.golv = (GestureOverlayView) this.findViewById(R.id.gestureOverlayView1);
		this.golv.addOnGesturePerformedListener(this);
		lib = GestureLibraries.fromRawResource(this, R.raw.gestures);
		if(!lib.load()){
			finish();
		}
	}
	public void onGesturePerformed(GestureOverlayView arg0, Gesture arg1) {
		// TODO Auto-generated method stub
		ArrayList<Prediction> list = lib.recognize(arg1);
		 for(Prediction p:list){
			 if(p.score>1.0)
				 Toast.makeText(this, p.name, Toast.LENGTH_LONG).show();
		 }
	}
	
}
