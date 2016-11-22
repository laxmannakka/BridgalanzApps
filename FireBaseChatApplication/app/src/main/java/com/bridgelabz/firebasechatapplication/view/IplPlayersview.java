package com.bridgelabz.firebasechatapplication.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.bridgelabz.firebasechatapplication.R;
import com.bridgelabz.firebasechatapplication.adapter.PlayerAdapter;
import com.bridgelabz.firebasechatapplication.controller.PlayerInfoController;
import com.bridgelabz.firebasechatapplication.model.PlayersModel;
import com.bridgelabz.firebasechatapplication.model.TeamsModel;
import com.bridgelabz.firebasechatapplication.viewmodel.PlayersViewModel;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class IplPlayersview extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ipl_playersview);
        Toast.makeText(getApplicationContext(), "im in another activity", Toast.LENGTH_LONG).show();
        Intent intent = getIntent();
        // Getting the key value
        int value = intent.getIntExtra("Key", 0);

        // Stroring the team Firebase database team referances in array
        String[] firebaseteamreferance = {"sunrisers", "Mubhai", "royalchalengers", "rising", "kingspunjab", "delhidaredevils", "gujaratlions", "kolkatata"};

        //Creating the fire database referance
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference(firebaseteamreferance[value]);

        // Initializing the recycler view
        final RecyclerView playerrecycleview = (RecyclerView) findViewById(R.id.teamrecycleview);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        playerrecycleview.setLayoutManager(mLayoutManager);
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                GenericTypeIndicator<List<PlayersModel>> t = new GenericTypeIndicator<List<PlayersModel>>() {
                };
                List<PlayersModel> firebaseData = dataSnapshot.getValue(t);
                ArrayList<PlayersViewModel> viewModel = PlayerInfoController.playerviewToviewModel(firebaseData);
                PlayerAdapter adapter = new PlayerAdapter(IplPlayersview.this,viewModel);
                playerrecycleview.setAdapter(adapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}
