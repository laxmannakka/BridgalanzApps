package com.bridgelabz.sharedpreferancedemo;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private static final String NAME_KEY="namE";
    private static final String PASS_KEY = "passworD";

    String name;
    String pw;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences = getSharedPreferences("Mydata", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                EditText username = (EditText) findViewById(R.id.username);
                EditText password = (EditText) findViewById(R.id.editpassword);
                name = username.getText().toString();
                pw = password.getText().toString();
                editor.putString(NAME_KEY,name);
                editor.putString(PASS_KEY, pw);
                editor.commit();
            }
        });
    }

        public void next(View v)
       {
           Intent second = new Intent(MainActivity.this,SecondActivity.class);
           second.putExtra(NAME_KEY,name);
           second.putExtra(PASS_KEY,pw);
           startActivity(second);

    }
}
