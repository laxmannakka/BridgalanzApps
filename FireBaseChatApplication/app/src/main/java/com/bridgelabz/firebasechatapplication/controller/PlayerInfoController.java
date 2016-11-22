package com.bridgelabz.firebasechatapplication.controller;

import android.graphics.Bitmap;

import com.bridgelabz.firebasechatapplication.model.PlayersModel;
import com.bridgelabz.firebasechatapplication.viewmodel.PlayersViewModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bridgelabz1 on 19/7/16.
 */


public class PlayerInfoController {


    public static ArrayList playerviewToviewModel(List<PlayersModel> model)
    {
    ArrayList<PlayersViewModel> viewModeldata = new ArrayList<>();
        for(int i=0;i<model.size();i++){
            PlayersModel mplayermodel = model.get(i);
            String name = mplayermodel.getPlayer_name();
            String role =mplayermodel.getPlayer_role();
            String bat_style =mplayermodel.getPlayer_batting_style();
            String bowl_style =mplayermodel.getPlayer_bowling_style();
            String nationality = mplayermodel.getPlayer_nationality();
            String dob = mplayermodel.getPlayer_dob();
            String url = mplayermodel.getPlayer_img_url();
            viewModeldata.add(new PlayersViewModel(name,role,bat_style,bowl_style,nationality,dob,url));
        }

        return viewModeldata;
    }
}
