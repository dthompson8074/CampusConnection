package com.codingcrew.campusconnection;

import android.accounts.*;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.codingcrew.webservices.*;
import com.codingcrew.webservices.Account;

import java.util.concurrent.ExecutionException;

import okhttp3.Response;

public class LoginActivity extends AppCompatActivity {

    Button mButtonLogin, mButtonRegister;
    EditText mUsername, mPassword;
    User mUser = User.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.codingcrew.campusconnection.R.layout.activity_login);

        //Link the activity_login.xml attributes to current activity
        mUsername = (EditText) findViewById(R.id.textViewUsername);
        mPassword = (EditText) findViewById(R.id.textViewPassword);

        //Store the user name into a string variable
        mUsername.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mUser.setUsername(s.toString());

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

      // Store the user password into a string variable
        mPassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mUser.setPassword(s.toString());

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        // Link the activity_login.xml attributes to current activity
        mButtonLogin = (Button) findViewById(R.id.buttonLogin);
        mButtonRegister = (Button) findViewById(R.id.buttonRegister);

        /* By pressing the button the Intent will launch the next activity*/
        mButtonLogin.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                String name = mUser.getUsername();
                String password = mUser.getPassword();
                String[] params = {"http://129.118.70.18/cc_ws/Login.svc?wsdl", name, password};
                AsyncTask<String, Void, Account> t = new LoginTask().execute(params);
                try {
                    Account acc = t.get();
                    if (acc == null) {
                        Toast toast = Toast.makeText(getApplicationContext(),
                                "Wrong email or password", Toast.LENGTH_LONG);
                        toast.show();
                    }
                    else {
                        Toast toast = Toast.makeText(getApplicationContext(), "Welcome " + acc.fullName
                                , Toast.LENGTH_LONG);
                        toast.show();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }

                // --- Quan commented out temporarily to test calling webservice --- start ---------
                Intent i = FeedActivity.newIntentFeed(LoginActivity.this);
                startActivity(i);
                // --- Quan ------------------------------------------------------ end -------------
            }
        });

        mButtonRegister.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Toast toast = Toast.makeText(getApplicationContext(), "Thank you for registering for " +
                        "our services", Toast.LENGTH_LONG);
                toast.show();
                Intent i = RegisterActivity.newIntentRegister(LoginActivity.this);
                startActivity(i);

            }
        });
    }
}






