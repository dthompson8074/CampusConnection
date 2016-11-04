package com.codingcrew.campusconnection.data;

/**
 * Created by Saul on 9/25/2016.
 */

public class User {
    private static User sUserClass;

    private String mUsername;
    private String mEmail;
    private String mPassword;

    public String getPassword() {
        return mPassword;
    }

    public void setPassword(String password) {
        mPassword = password;
    }

    public static User getInstance() {
        if(sUserClass == null) {
            sUserClass = new User();

        }

        return sUserClass;
    }
    private User(){
        mEmail = "Default@ttu.edu";
        mUsername = "Default";
        mPassword = "";
    }

    public String getUsername() {
        return mUsername;
    }

    public void setUsername(String username) {
        mUsername = username;
    }

    public String getEmail() {
        return mEmail;
    }

    public void setEmail(String email) {
        mEmail = email;
    }
}
