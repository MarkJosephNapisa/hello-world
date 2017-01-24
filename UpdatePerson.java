package com.example.midtermlab;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class UpdatePerson extends Activity implements OnClickListener {

	ImageView iv;
	EditText txtName;
	Button btnOk,btnCancel;
	Uri uri;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.updateperson_layout);
		
		this.iv=(ImageView) this.findViewById(R.id.imageView1);
		this.txtName=(EditText) this.findViewById(R.id.editText1);
		this.btnOk=(Button) this.findViewById(R.id.button1);
		this.btnCancel=(Button) this.findViewById(R.id.button2);
		
		this.iv.setOnClickListener(this);
		this.btnOk.setOnClickListener(this);
		this.btnCancel.setOnClickListener(this);
	}
	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		int id=arg0.getId();
		switch(id){
		
		case R.id.imageView1: //create an imagepicker
			
			Intent intent=new Intent(Intent.ACTION_PICK,android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
			this.startActivityForResult(intent,111);
		case R.id.button1: //save
			
			String name=this.txtName.getText().toString();
			
			if(uri!=null && name.equals("")){
			intent=new Intent();
			intent.putExtra("image", uri);
			intent.putExtra("name", name);
			this.setResult(Activity.RESULT_OK, intent);
			
			}
			else Toast.makeText(this, "Fill All Field", Toast.LENGTH_SHORT).show();
			//break;
		case R.id.button2: //cancel
			this.finish(); //terminate
			
		}
	}
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
		
		uri=data.getData();
		
		this.iv.setImageURI(uri);
	}
	
	
}
