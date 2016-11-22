package com.bridgelabz.firebasechatapplication.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bridgelabz.firebasechatapplication.R;

/**
 * Created by bridgelabz1 on 12/7/16.
 */

public class PlayersviewHolder extends RecyclerView.ViewHolder {
  public  TextView name,role,battingstyle,bowlingstyle,nationality,dob;
   public ImageView playerphoto;

    public PlayersviewHolder(View itemView) {
        super(itemView);
        name = (TextView)itemView.findViewById(R.id.setnameTextview);
        role =(TextView)itemView.findViewById(R.id.setplayrole);
        battingstyle=(TextView)itemView.findViewById(R.id.setbattingstyle);
        bowlingstyle=(TextView)itemView.findViewById(R.id.setbowl);
        nationality=(TextView)itemView.findViewById(R.id.nationality);
        playerphoto=(ImageView)itemView.findViewById(R.id.imageview1);
        dob =(TextView)itemView.findViewById(R.id.setdob);

    }
}
