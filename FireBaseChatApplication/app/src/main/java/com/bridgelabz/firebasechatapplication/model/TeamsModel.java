package com.bridgelabz.firebasechatapplication.model;

import android.widget.ImageView;

/**
 * Created by bridgelabz1 on 11/7/16.
 */

public class TeamsModel {
    String teamname;
    String owner;
    String url;
    ImageView logo;

    public TeamsModel(){}
    public TeamsModel(String teamname, String owner) {
        this.teamname = teamname;
        this.owner = owner;
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

    public ImageView getLogo() {
        return logo;
    }

    public void setLogo(ImageView logo) {
        this.logo = logo;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}

