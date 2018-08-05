package com.mis.tutor2.tutor2;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {
    TextView masuk;
    Button logout;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        masuk = (TextView)findViewById(R.id.loggedas);
        logout = (Button)findViewById(R.id.btnlogout);
        sharedPreferences = getSharedPreferences("loginref",MODE_PRIVATE);
        masuk.setText(sharedPreferences.getString("username",null));
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editor = sharedPreferences.edit();
                editor.putBoolean("savelogin",false);
                editor.apply();
                Intent i1 = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(i1);
                finish();
            }
        });
    }
}
