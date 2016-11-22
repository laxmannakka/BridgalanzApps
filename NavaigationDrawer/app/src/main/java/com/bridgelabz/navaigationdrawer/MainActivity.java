package com.bridgelabz.navaigationdrawer;

import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import static com.bridgelabz.navaigationdrawer.R.string.closedrawer;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    DrawerLayout drawerlayout;

    String[] Planets;
    Toolbar tol_bar;
    ActionBarDrawerToggle drawerlisner;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        drawerlayout = (DrawerLayout) findViewById(R.id.drawerlayout);
         tol_bar = (Toolbar) findViewById(R.id.toollbar);
            tol_bar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerlisner = new ActionBarDrawerToggle(MainActivity.this, drawerlayout, tol_bar, R.string.opendrawer, R.string.closedrawer) {

                    @Override
                    public void syncState() {
                        super.syncState();
                    }

                    @Override
                    public void onDrawerOpened(View drawerView) {
                        super.onDrawerOpened(drawerView);
                        Toast.makeText(MainActivity.this,"message:opened",Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onDrawerClosed(View drawerView) {
                        super.onDrawerClosed(drawerView);
                        Toast.makeText(MainActivity.this,"message:opened",Toast.LENGTH_LONG).show();
                    }
                };
            }
        });


        ListView list = (ListView) findViewById(R.id.list);
        Planets = getResources().getStringArray(R.array.planets);
        list.setAdapter(new ArrayAdapter<String>(MainActivity.this, R.layout.support_simple_spinner_dropdown_item, Planets));
        list.setOnItemClickListener(MainActivity.this);

    }



    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        Toast.makeText(this,"planet postition is "+position+"string is "+Planets[position],Toast.LENGTH_SHORT).show();
        //setTitlein(position);
    }

    private void setTitlein(int position) {
        setSupportActionBar(tol_bar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle(Planets[position]);
    }
}
