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
import com.bridgelabz.firebasechatapplication.viewmodel.PlayersViewModel;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by bridgelabz1 on 19/7/16.
 *
 */

public class PlayerAdapter extends RecyclerView.Adapter<PlayerAdapter.MyViewHolder> {

    Context mcontext;
    List<PlayersViewModel> model;

    public PlayerAdapter(Context mcontext, List<PlayersViewModel> model) {
        this.mcontext = mcontext;
        this.model = model;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemview = LayoutInflater.from(parent.getContext()).inflate(R.layout.playersinfo,parent,false);
        return new PlayerAdapter.MyViewHolder(itemview);

    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
    PlayersViewModel viewmodel = model.get(position);
        holder.name.setText(viewmodel.getPlayer_name());
        holder.role.setText(viewmodel.getPlayer_role());
        holder.batstyle.setText(viewmodel.getPlayer_batting_style());
        holder.bowlstyle.setText(viewmodel.getPlayer_bowling_style());
        holder.nationality.setText(viewmodel.getPlayer_nationality());
        holder.dob.setText(viewmodel.getPlayer_dob());
        //holder.image.setImageBitmap(viewmodel.getBitmap());

       /* Imagedownload.imageDownload(viewmodel.getPlayer_img_url(), new ImageDownloaderInterface() {
            @Override
            public void imagaeDownloded(Bitmap bitmap) {
                holder.image.setImageBitmap(bitmap);
            }
        });*/
        Imagedownload.imageDownload(viewmodel.getPlayer_img_url(), new ImageDownloaderInterface() {
            @Override
            public void imagaeDownloded(Uri uri) {
                Picasso.with(mcontext).load(uri).into(holder.image);
            }
        });

    }

    @Override
    public int getItemCount() {
        return model.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView name,role,batstyle,bowlstyle,nationality,dob;
        ImageView image;
        public MyViewHolder(View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.setnameTextview);
            role = (TextView) itemView.findViewById(R.id.setplayrole);
            batstyle=(TextView)itemView.findViewById(R.id.setbattingstyle);
            bowlstyle=(TextView)itemView.findViewById(R.id.setbowl);
            nationality=(TextView)itemView.findViewById(R.id.setnatonality);
            dob=(TextView)itemView.findViewById(R.id.setdob);
            image=(ImageView)itemView.findViewById(R.id.imageview1);
        }
    }
}
