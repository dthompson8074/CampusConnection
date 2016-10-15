package com.codingcrew.campusconnection;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    Button mButtonLogin, mButtonRegister;
    EditText mUsername, mPassword;
    User mUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.codingcrew.campusconnection.R.layout.activity_login);

        mUser = new User();

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

                Toast toast = Toast.makeText(getApplicationContext(), "Welcome " + mUser.getUsername() +
                        " " + mUser.getPassword()
                        , Toast.LENGTH_LONG);
                toast.show();

                String name = mUser.getUsername();
                Intent i = ProfileActivity.newIntent(LoginActivity.this, name);
                startActivity(i);
            }
        });

        mButtonRegister.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {


                Toast toast = Toast.makeText(getApplicationContext(), "Thank you for using our services", Toast.LENGTH_LONG);
                toast.show();
            }
        });
    }
}






