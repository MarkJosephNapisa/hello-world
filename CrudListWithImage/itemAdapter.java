package com.example.midtermlab;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class itemAdapter extends BaseAdapter {
	
	Context context;
	ArrayList<Person> list;
	LayoutInflater inflater;
	
	

	public itemAdapter(Context context, ArrayList<Person> list) {
		super();
		this.context = context;
		this.list = list;
		this.inflater=LayoutInflater.from(context);
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return list.size();
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return list.get(arg0);
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return arg0;
	}

	@Override
	public View getView(int arg0, View arg1, ViewGroup arg2) {
		// TODO Auto-generated method stub
		
		ItemHandler handler=null;
		
		if(arg1==null){
			
			arg1=inflater.inflate(R.layout.itemlayout, null);
			handler=new ItemHandler();
			handler.iv=(ImageView) arg1.findViewById(R.id.imageView1);
			handler.tv=(TextView) arg1.findViewById(R.id.textView1);
			arg1.setTag(handler);
		}
		else handler=(ItemHandler)arg1.getTag();
		
			handler.iv.setImageURI(list.get(arg0).getImageUri());
			handler.tv.setText(list.get(arg0).getName());
		return arg1;
	}
	
	static class ItemHandler{
		ImageView iv;
		TextView tv;
	}
	
}
