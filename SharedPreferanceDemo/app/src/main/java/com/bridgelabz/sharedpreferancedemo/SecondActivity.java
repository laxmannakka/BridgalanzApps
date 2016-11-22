package com.bridgelabz.sharedpreferancedemo;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class SecondActivity extends AppCompatActivity {
    private static final String NAME_KEY="namE";
    private static final String PASS_KEY = "passworD";
    public final String DEAFAULT = "N/A";
    EditText Textusername;
    EditText Textpassword;
    TextView txtName;
    TextView txtPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        txtName= (TextView) findViewById(R.id.txtName);
        txtPass= (TextView) findViewById(R.id.txtPass);


        SharedPreferences sharedPreferences = getSharedPreferences("Mydata", Context.MODE_PRIVATE);
        String name = sharedPreferences.getString(NAME_KEY, DEAFAULT);
        String password = sharedPreferences.getString(PASS_KEY, DEAFAULT);

        if (name.equals("N/A") && password.equals("N/A")) {
            Toast.makeText(getApplicationContext(), "NO data Found", Toast.LENGTH_SHORT).show();
        } else {
            txtName.setText(name);
            txtPass.setText(password);
        }


    }
}



