package com.bridgelabz.databindingpractice;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;


import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    User obj;
    List<User> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActivityMainBinding binding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        obj = new User("laxman","Nakka");
        binding.setUser(obj);
        list = new ArrayList<>();
        list.add(new User("eshawar","mali"));
        list.add(new User("maohumudf","chhota"));
        list.add(new User("mukesh","-----"));
        list.add(new User("ippe","venkat"));
    }
}
