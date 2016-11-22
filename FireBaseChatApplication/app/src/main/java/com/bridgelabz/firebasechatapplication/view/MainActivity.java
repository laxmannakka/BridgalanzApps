package com.bridgelabz.firebasechatapplication.view;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.bridgelabz.firebasechatapplication.R;
import com.bridgelabz.firebasechatapplication.adapter.TeamAdapter;
import com.bridgelabz.firebasechatapplication.controller.TeamsInfoController;
import com.bridgelabz.firebasechatapplication.utility.ClickListener;
import com.bridgelabz.firebasechatapplication.utility.RecyclerviewTouchEvent;
import com.bridgelabz.firebasechatapplication.viewholder.TeamviewHolder;
import com.bridgelabz.firebasechatapplication.model.TeamsModel;
import com.bridgelabz.firebasechatapplication.viewmodel.TeamViewmodel;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static com.bridgelabz.firebasechatapplication.R.id.recyclerview;

public class MainActivity extends AppCompatActivity {


    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Creating the fire database referance

        FirebaseDatabase database = FirebaseDatabase.getInstance();

        // getting the REfernce
        DatabaseReference myRef = database.getReference("ipl");

        // Initilizing the recylerview
        final RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);



        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot)
            {
                GenericTypeIndicator<List<TeamsModel>> t = new GenericTypeIndicator<List<TeamsModel>>() {};
                List<TeamsModel> messages = dataSnapshot.getValue(t);
                ArrayList<TeamViewmodel> viewmodel = TeamsInfoController.viewToViewModel(messages);
                TeamAdapter adapter = new TeamAdapter(viewmodel,MainActivity.this);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });

        recyclerView.addOnItemTouchListener(new RecyclerviewTouchEvent(getApplicationContext(), recyclerView, new ClickListener() {

            @Override
            public void onClick(View view, int position) {
                //IplTeamsinfoViewmodel obj = viewmodel.get(position);
                // Toast.makeText(getApplicationContext(), "message clicked on" + position + "---" + obj.getTeamname(), Toast.LENGTH_LONG).show();
                Intent displyteaminfo;

                displyteaminfo = new Intent(MainActivity.this, IplPlayersview.class);
                displyteaminfo.putExtra("Key",position);
                startActivity(displyteaminfo);
            }
            @Override
            public void onLongClick(View view, int position) {

            }
        }));

    }


}

  /*Creating the FireBaseRecycler adapter
        * it will take model class  ,modelview class,layout and referance
        * Automatically fetch the data from firebase
        * */

        /*FirebaseRecyclerAdapter<TeamsModel, TeamviewHolder> adapter = new FirebaseRecyclerAdapter<TeamsModel, TeamviewHolder>(TeamsModel.class, R.layout.recyle, TeamviewHolder.class, myRef) {

            /*//* Populateview holer Method  we have to set the viewholder data *//**//*

            @Override
            protected void populateViewHolder(final TeamviewHolder viewHolder, TeamsModel model, final int position) {

                viewHolder.Teamname.setText(model.getTeamname());
                viewHolder.owner.setText(model.getOwner());

                // Creating the Firebase Refferance
                StorageReference mystorage = FirebaseStorage.getInstance().getReference();
                // Pointing to root node
                mystorage = mystorage.getRoot();
                // Taking url from model
                String uri = model.getUrl();
                mystorage = mystorage.child(uri);

                //Method for Downloading the image
                final long ONE_MEGABYTE = 1024 * 1024;
                mystorage.getBytes(ONE_MEGABYTE).addOnSuccessListener(new OnSuccessListener<byte[]>() {
                    @Override
                    public void onSuccess(byte[] bytes) {
                        // Converting bytes array to Bitmap
                        Bitmap bitmap = BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
                        // Setting the image to our view
                        viewHolder.imageView.setImageBitmap(bitmap);

                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception exception) {
                        // Handle any errors
                    }
                });

                // when image clicks it will open new activity
                viewHolder.imageView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(MainActivity.this, TeamPlayerview.class);
                        // Storing the position of intent
                        intent.putExtra("Key", position);
                        Toast.makeText(getApplicationContext(), "Message" + position, Toast.LENGTH_LONG).show();
                        startActivity(intent);
                    }
                });

            }
        };



        // Recycler view setthe adapter
        recyclerView.setAdapter(adapter);*/

