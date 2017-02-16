package com.example.myweatherapp;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.os.Bundle;
import android.os.StrictMode;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener {
	
	ImageButton btngo;
	EditText txtCity;
	ImageView iv;
	TextView weathertype,cityName,temp,humidity;
	
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        this.iv=(ImageView) this.findViewById(R.id.imageView1);
        this.weathertype=(TextView) this.findViewById(R.id.textView1);
        this.cityName=(TextView) this.findViewById(R.id.textView2);
        this.temp=(TextView) this.findViewById(R.id.textView3);
        this.humidity=(TextView) this.findViewById(R.id.textView4);
        this.btngo=(ImageButton) this.findViewById(R.id.imageButton1);
        this.txtCity=(EditText) this.findViewById(R.id.editText1);
        StrictMode.ThreadPolicy policy= new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
       
        this.btngo.setOnClickListener(this);
}


	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		String mycity=txtCity.getText().toString();
		try {
			URL url=new URL("http://api.openweathermap.org/data/2.5/weather?q="+mycity+"&units=metric&appid=f41e22bde578f60572af3c009982ac4e");			try {
				HttpURLConnection conn=(HttpURLConnection)url.openConnection();
				StringBuffer sb=new StringBuffer();
				InputStream is=conn.getInputStream();
				int c=0;
				while ((c=is.read())!=-1){
					sb.append((char)c);
				}
				
				is.close();
				conn.disconnect();
				
				//Toast.makeText(this,sb.toString(),Toast.LENGTH_LONG).show();
			
				JSONObject json=new JSONObject(sb.toString());
				JSONArray weather=json.getJSONArray("weather");
				JSONObject desc=weather.getJSONObject(0);
				String ds=desc.getString("description");
				String icon=desc.getString("icon");
				
				url=new URL("http://openweathermap.org/img/w/"+icon+".png");
				conn=(HttpURLConnection)url.openConnection();
				is=conn.getInputStream();
				Bitmap bmp=BitmapFactory.decodeStream(is);
				iv.setImageBitmap(bmp);
				is.close();
				conn.disconnect();
				this.weathertype.setText(ds);
			
				String city=json.getString("name");
				JSONObject main=json.getJSONObject("main");
				String temp=main.getString("temp");
				String hum=main.getString("humidity");
				
				//double celsius=Double.parseDouble(temp)-272.3;
				
				this.cityName.setText(city);
				this.temp.setText(temp+"°C");
				this.humidity.setText(hum+"%");
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        } catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
      
	}
}
