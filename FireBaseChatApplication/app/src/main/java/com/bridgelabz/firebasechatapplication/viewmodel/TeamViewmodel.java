package com.bridgelabz.firebasechatapplication.viewmodel;

import android.graphics.Bitmap;
import android.widget.ImageView;

/**
 * Created by bridgelabz1 on 19/7/16.
 */

public class TeamViewmodel {

    String teamname;
    String owner;
    Bitmap image;
    String url;


    public TeamViewmodel(String teamownername, String teamname, String url) {
        this.teamname = teamname;
        this.owner = teamownername;
        this.url=url;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTeamname() {
        return teamname;
    }

    public void setTeamname(String teamname) {
        this.teamname = teamname;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }


    public Bitmap getImage() {
        return image;
    }

    public void setImage(Bitmap image) {
        this.image = image;
    }
}
