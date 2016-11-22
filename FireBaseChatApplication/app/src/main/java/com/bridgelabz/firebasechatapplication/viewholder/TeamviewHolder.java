package com.bridgelabz.firebasechatapplication.viewholder;

import android.databinding.BaseObservable;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bridgelabz.firebasechatapplication.R;

/**
 * Created by bridgelabz1 on 11/7/16.
 */



public class TeamviewHolder extends RecyclerView.ViewHolder {
  public  TextView Teamname,owner;
    public ImageView imageView;
    public TeamviewHolder(View itemView) {
        super(itemView);

        Teamname= (TextView) itemView.findViewById(R.id.setownername);
        owner =(TextView)itemView.findViewById(R.id.setteamname);
        imageView = (ImageView) itemView.findViewById(R.id.logoteam);

    }
}
