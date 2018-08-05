package com.mis.tutor2.tutor2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.content.SharedPreferences;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
     EditText user,nrp;
     Button login;
     SharedPreferences sharedPreferences;
     SharedPreferences.Editor editor;
     Boolean savelogin;
     CheckBox savelogincheckbox;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        user=(EditText)findViewById(R.id.txtuser);
        nrp=(EditText)findViewById(R.id.txtnrp);
        login=(Button)findViewById(R.id.btnlogin);
        sharedPreferences = getSharedPreferences("loginref",MODE_PRIVATE);
        savelogincheckbox = (CheckBox)findViewById(R.id.checkbox);
        editor = sharedPreferences.edit();
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login();
            }
        });
        savelogin=sharedPreferences.getBoolean("savelogin",false);
        if(savelogin==true){
            user.setText(sharedPreferences.getString("username",null));
            nrp.setText(sharedPreferences.getString("usernrp",null));
            Intent i1 = new Intent(getApplicationContext(),Main2Activity.class);
            startActivity(i1);
            finish();
        }
    }
    public void login(){
        String usrname = user.getText().toString();
        String usrnrp = nrp.getText().toString();
        //if(usrname.equals("NajatulMuslimDinatra") && usrnrp.equals("05111740000079")){
        if(usrname.equals("") && usrnrp.equals("")) {
            Toast.makeText(this,"error",Toast.LENGTH_LONG).show();
        }
        else {
            Toast.makeText(this, "username and nrp matched!", Toast.LENGTH_LONG).show();
            if (savelogincheckbox.isChecked())
                editor.putBoolean("savelogin", true);
            else
                editor.putBoolean("savelogin", false);
            editor.putString("username", usrname);
            editor.putString("usernrp", usrnrp);
            editor.commit();
            editor.apply();
            Intent i1 = new Intent(getApplicationContext(), Main2Activity.class);
            startActivity(i1);
            finish();
        }
    }
}
