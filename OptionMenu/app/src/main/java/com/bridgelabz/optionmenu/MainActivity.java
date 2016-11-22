package com.bridgelabz.optionmenu;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Creating The Object Of Fragment Managerclass
        FragmentManager fragmentManager = getFragmentManager();
        // Start a series of edit operations on the Fragments associated with this FragmentManager.
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        // Creating The Object of Login Fragment
        LoginFragment login = new LoginFragment();

        // adding the login xml file to mainactivity xml file in container regeoion
        fragmentTransaction.add(R.id.container, login);
        // commit The Transaction
        fragmentTransaction.commit();
        // Initilize the Text view object
        textView = (TextView) findViewById(R.id.new_user);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Creating The Object Of Fragment Managerclass
                FragmentManager fragmentManager = getFragmentManager();
                // Start a series of edit operations on the Fragments associated with this FragmentManager
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

                NewRegistrationLogin newuser = new NewRegistrationLogin();
                // adding the newuserlogin xml file to mainactivity xml file in container regeoion
                fragmentTransaction.replace(R.id.container, newuser);
                fragmentTransaction.commit();


            }
        });

    }
}
