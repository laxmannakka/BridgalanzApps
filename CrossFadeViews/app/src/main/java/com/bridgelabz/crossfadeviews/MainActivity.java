package com.bridgelabz.crossfadeviews;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button mCrossfade,mViewpager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);
        mCrossfade = (Button) findViewById(R.id.crossfade);
        mViewpager=(Button)findViewById(R.id.viewpager);
        mCrossfade.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent fadeIntent = new Intent(MainActivity.this, CrossFade.class);
                startActivity(fadeIntent);
            }
        });
        mViewpager.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent viewPager = new Intent(MainActivity.this,ViewPagerAnimation.class);
                startActivity(viewPager);
            }
        });


    }
}
