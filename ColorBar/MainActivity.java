package com.example.colorbar;

import android.os.Bundle;
import android.app.Activity;
import android.graphics.Color;
import android.view.Menu;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;

public class MainActivity extends Activity implements OnSeekBarChangeListener {

	SeekBar seekBarRed;
	SeekBar seekBarGreen;
	SeekBar seekBarBlue;
	TextView result;
	
	int redColor, greenColor, blueColor;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        this.seekBarRed=(SeekBar) this.findViewById(R.id.seekBar1);
        this.seekBarGreen=(SeekBar) this.findViewById(R.id.seekBar2);
        this.seekBarBlue=(SeekBar) this.findViewById(R.id.seekBar3);
        
        this.seekBarRed.setOnSeekBarChangeListener(this);
        this.seekBarGreen.setOnSeekBarChangeListener(this);
        this.seekBarBlue.setOnSeekBarChangeListener(this);
        
        this.result=(TextView) this.findViewById(R.id.textView4);
        
        
    }

	@Override
	public void onProgressChanged(SeekBar arg0, int arg1, boolean arg2) {
		// TODO Auto-generated method stub
		
		int id=arg0.getId();
		switch(id){
			case R.id.seekBar1: this.redColor=this.seekBarRed.getProgress(); break;
			case R.id.seekBar2: this.greenColor=this.seekBarGreen.getProgress(); break;
			case R.id.seekBar3: this.blueColor=this.seekBarBlue.getProgress();
		}
		String colorText=String.format("#%02X-%02X-%02X",redColor,greenColor,blueColor);
		this.result.setText(colorText);
		this.result.setTextColor(Color.rgb(255-redColor,255-greenColor,255-blueColor));
		this.result.setBackgroundColor(Color.rgb(redColor, greenColor, blueColor));
		
	}

	@Override
	public void onStartTrackingTouch(SeekBar arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStopTrackingTouch(SeekBar arg0) {
		// TODO Auto-generated method stub
		
	}

}
