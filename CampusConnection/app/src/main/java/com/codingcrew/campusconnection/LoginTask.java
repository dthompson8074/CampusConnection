package com.codingcrew.campusconnection;

import android.os.AsyncTask;

import com.codingcrew.webservices.Account;
import com.codingcrew.webservices.Login;

/**
 * Created by Quan on 10/18/2016.
 */

public class LoginTask extends AsyncTask<String, Void, Account> {
    @Override
    protected Account doInBackground(String... params) {
        Login loginSrv = new Login();
        Account acc =  loginSrv.DoLogin(params[1], params[2]);
        return  acc;
    }
}
