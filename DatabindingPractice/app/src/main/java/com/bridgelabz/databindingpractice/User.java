package com.bridgelabz.databindingpractice;

import android.databinding.BaseObservable;

/**
 * Created by bridgelabz1 on 1/7/16.
 */

public class User extends BaseObservable{
    String firstname;
    String Lastname;

    public User(String firstname, String lastname) {
        this.firstname = firstname;
        Lastname = lastname;
    }

    public String getLastname() {
        return Lastname;
    }

    public void setLastname(String lastname) {
        Lastname = lastname;
        notifyPropertyChanged(com.bridgelabz.databindingpractice.BR._all);
    }

    public String getFirstname() {

        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
        notifyPropertyChanged(com.bridgelabz.databindingpractice.BR._all);
    }
}
