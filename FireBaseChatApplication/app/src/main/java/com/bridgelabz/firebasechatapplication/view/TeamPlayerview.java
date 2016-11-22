package com.bridgelabz.firebasechatapplication.view;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.bridgelabz.firebasechatapplication.R;
import com.bridgelabz.firebasechatapplication.model.PlayersModel;
import com.bridgelabz.firebasechatapplication.model.TeamsModel;
import com.bridgelabz.firebasechatapplication.viewholder.PlayersviewHolder;
import com.bridgelabz.firebasechatapplication.viewholder.TeamviewHolder;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

public class TeamPlayerview extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team_playerview);
        // Return the intent that started this activity
        Intent intent = getIntent();
        // Getting the key value
        int value = intent.getIntExtra("Key", 0);

        // Stroring the team Firebase database team referances in array
         String[] firebaseteamreferance = {"sunrisers", "Mubhai", "royalchalengers","rising","kingspunjab","delhidaredevils","gujaratlions","kolkatata"};

        //Creating the fire database referance
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference(firebaseteamreferance[value]);

        // Initilizing the recycler view
        final RecyclerView playerrecycleview = (RecyclerView) findViewById(R.id.playerrecyclerview);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        playerrecycleview.setLayoutManager(mLayoutManager);


        /*Creating the FireBaseRecycler adapter
        * it will take model class  ,modelview class,layout and reference
        * Automatically fetch the data from firebase
        * */
        FirebaseRecyclerAdapter<PlayersModel, PlayersviewHolder> playeradapter = new FirebaseRecyclerAdapter<PlayersModel, PlayersviewHolder>(PlayersModel.class, R.layout.playersinfo, PlayersviewHolder.class, myRef) {

            /* Populateview holer Method  we have to set the viewholder data */
            @Override
            protected void populateViewHolder(final PlayersviewHolder viewHolder, PlayersModel model, int position) {

                viewHolder.name.setText(model.getPlayer_name());
                viewHolder.role.setText(model.getPlayer_role());
                viewHolder.dob.setText(model.getPlayer_dob());
                viewHolder.battingstyle.setText(model.getPlayer_batting_style());
                viewHolder.bowlingstyle.setText(model.getPlayer_bowling_style());

                StorageReference mystorage = FirebaseStorage.getInstance().getReference();
                mystorage = mystorage.getRoot();
                String uri = model.getPlayer_img_url();
                mystorage = mystorage.child(uri);

                final long ONE_MEGABYTE = 1024 * 1024;
                mystorage.getBytes(ONE_MEGABYTE).addOnSuccessListener(new OnSuccessListener<byte[]>() {
                    @Override
                    public void onSuccess(byte[] bytes) {
                        // Data for "images/island.jpg" is returns, use this as needed
                        Bitmap bitmap = BitmapFactory.decodeByteArray(bytes , 0, bytes .length);
                        viewHolder.playerphoto.setImageBitmap(bitmap);

                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception exception) {
                        // Handle any errors
                    }
                });
            }
        };
        playerrecycleview.setAdapter(playeradapter);
    }
}