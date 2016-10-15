package com.codingcrew.campusconnection;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Saul on 10/14/2016.
 */

public class RegistorActivity extends AppCompatActivity {

    Button mButtonSend;
    EditText mEmail, mPassword, mCPassword;
    User mUser = new User();

    public static Intent newIntentRegistor(Context packageContext) {
        Intent i = new Intent(packageContext, RegistorActivity.class);
        return i;
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mCPassword = (EditText) findViewById(R.id.confirmPassword);
        mPassword = (EditText) findViewById(R.id.registorPassword);
        mEmail = (EditText) findViewById(R.id.registorEmail);


        mEmail.addTextChangedListener(new TextWatcher() {
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
        mButtonSend = (Button) findViewById(R.id.buttonSend);

        mCPassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                ;

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        mButtonSend.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Toast toast = Toast.makeText(getApplicationContext(), mUser.getUsername() + " " + mUser.getPassword(), Toast.LENGTH_LONG);
                toast.show();
                String name = mUser.getUsername();
                Intent i = ProfileActivity.newIntent(RegistorActivity.this, name);
                startActivity(i);
            }
        });
    }
}
