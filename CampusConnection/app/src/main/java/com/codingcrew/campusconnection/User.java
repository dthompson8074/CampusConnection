package com.codingcrew.campusconnection;

import java.util.List;

/**
 * Created by Saul on 9/25/2016.
 */

public class User {

    private String mUsername;
    private String mPassword;

    User(){
        mPassword = "";
        mUsername = "";
    }

    public String getUsername() {
        return mUsername;
    }

    public void setUsername(String username) {
        mUsername = username;
    }

    public String getPassword() {
        return mPassword;
    }

    public void setPassword(String password) {
        mPassword = password;
    }
}
