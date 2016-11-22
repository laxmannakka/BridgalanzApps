package com.bridgelabz.firebasechatapplication.controller;

import com.bridgelabz.firebasechatapplication.model.TeamsModel;
import com.bridgelabz.firebasechatapplication.viewmodel.TeamViewmodel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bridgelabz1 on 19/7/16.
 */

public class TeamsInfoController {



    public static ArrayList viewToViewModel(List<TeamsModel> model){
        final ArrayList<TeamViewmodel> viewmodellist;
        viewmodellist = new ArrayList<>();
        for(int i=0;i<model.size();i++){
            TeamsModel teamData = model.get(i);
            final String mteamownername = teamData.getOwner();
            final String mTeamname =teamData.getTeamname();
            String url = teamData.getUrl();
            viewmodellist.add(new TeamViewmodel(mteamownername,mTeamname,url));

        }
        return viewmodellist;
    }
}
