package com.example.userlogin;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener {

	EditText txtUsername,pwdPassword;
	Button btnLogin;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        this.txtUsername=(EditText) this.findViewById(R.id.editText1);
        this.pwdPassword=(EditText) this.findViewById(R.id.editText2);
        
        this.btnLogin=(Button) this.findViewById(R.id.button1);

        
        this.btnLogin.setOnClickListener(this);
        
        
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }


	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
	
		String username=this.txtUsername.getText().toString();
		String password=this.pwdPassword.getText().toString();
		
		if((username.equals("admin")) && (password.equals("helloworld"))){
			
			Toast.makeText(this, "SUCCESS !!!", Toast.LENGTH_SHORT).show();
		}
		else{
			AlertDialog.Builder builder=new AlertDialog.Builder(this);
				builder.setTitle("Error");
				builder.setMessage("Invalid User !!!");
				builder.setNeutralButton("Okey", null);
				
				AlertDialog dialog=builder.create();
					dialog.show();
			
		}

	}
    
}
