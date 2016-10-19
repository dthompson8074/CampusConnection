package com.codingcrew.campusconnection;

import android.os.AsyncTask;

import com.codingcrew.webservices.accmgr.*;

/**
 * Created by Quan on 10/18/2016.
 */

public class LoginTask extends AsyncTask<String, Void, Account> {
    @Override
    protected Account doInBackground(String... params) {
        accmgr loginSrv = new accmgr();
        Account acc =  loginSrv.DoLogin(params[1], params[2]);
        return  acc;
    }
}
