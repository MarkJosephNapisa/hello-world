package com.example.studentform;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener, OnItemSelectedListener {

	EditText idno;
	EditText name;
	RadioGroup sex;
	Spinner course;
	Button ok;
	Button cancel;
	private String selected_course;
	private int selected_sex;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        idno=(EditText)this.findViewById(R.id.editText1);
        name=(EditText)this.findViewById(R.id.editText2);
        sex=(RadioGroup)this.findViewById(R.id.radioGroup1);
        course=(Spinner)this.findViewById(R.id.spinner1);
        ok=(Button)this.findViewById(R.id.button1);
        cancel=(Button)this.findViewById(R.id.button2);
        
        ok.setOnClickListener(this);
        cancel.setOnClickListener(this);
        
        course.setOnItemSelectedListener(this);
        
        selected_sex=sex.getCheckedRadioButtonId();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }


	@Override
	public void onClick(View arg0) {
		
		int id=arg0.getId();
		switch(id){
		case R.id.button1:
			
			String idnum=idno.getText().toString();
			String nm=name.getText().toString();
			
			if(idnum.equals("")&&nm.equals(""))
			{
				Toast.makeText(this, "Please Fill IDNO and NAME", Toast.LENGTH_SHORT).show();
			}
			else
			{
				RadioButton sexbutton=(RadioButton) this.findViewById(selected_sex);
				String mysex=sexbutton.getText().toString();
				
				String message="IDNO"+idnum+"\nNAME: "+nm+"\nSEX :"+mysex+"\nCOURSE :"+this.selected_course;
				
				AlertDialog.Builder builder=new AlertDialog.Builder(this);
					builder.setTitle("Student Information");
					builder.setMessage(message);
					builder.setNeutralButton("OK", null);
					
					AlertDialog dialog=builder.create();
						dialog.show();
			}
			break;
			
		case R.id.button2:	
			
			name.setText("");
			idno.setText("");
			sex.clearCheck();
			course.setSelection(0);
			idno.requestFocus();
		}
		
		
	}


	@Override
	public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2,
			long arg3) {
		
		selected_course=course.getItemAtPosition(arg2).toString();
		
	}


	@Override
	public void onNothingSelected(AdapterView<?> arg0) {
		// TODO Auto-generated method stub
		
	}
    
}
