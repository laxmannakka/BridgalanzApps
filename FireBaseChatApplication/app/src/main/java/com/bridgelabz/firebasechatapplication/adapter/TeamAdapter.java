package com.bridgelabz.firebasechatapplication.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bridgelabz.firebasechatapplication.utility.ImageDownloaderInterface;
import com.bridgelabz.firebasechatapplication.R;
import com.bridgelabz.firebasechatapplication.controller.Imagedownload;
import com.bridgelabz.firebasechatapplication.viewmodel.TeamViewmodel;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by bridgelabz1 on 19/7/16.
 */

public class TeamAdapter extends RecyclerView.Adapter<TeamAdapter.MyViewHolder> {

   List<TeamViewmodel> listofTeams;
    Context mContext;

    public TeamAdapter(List<TeamViewmodel> listofTeams, Context mContext) {
        this.listofTeams = listofTeams;
        this.mContext = mContext;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemview = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyle,parent,false);
        return new MyViewHolder(itemview);

    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {

    TeamViewmodel model = listofTeams.get(position);
        holder.ownerName.setText(model.getTeamname());
        holder.teamName.setText(model.getOwner());
        //holder.imageView.setImageBitmap(model.getImage());
        Imagedownload.imageDownload(model.getUrl(), new ImageDownloaderInterface() {

            @Override
            public void imagaeDownloded(Uri uri) {
                Picasso.with(mContext).load(uri).into(holder.imageView);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listofTeams.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView ownerName,teamName;
                ImageView imageView;
        public MyViewHolder(View itemView) {
            super(itemView);
            ownerName = (TextView) itemView.findViewById(R.id.setownername);
            teamName = (TextView) itemView.findViewById(R.id.setteamname);
            imageView = (ImageView) itemView.findViewById(R.id.logoteam);

        }
    }
}
