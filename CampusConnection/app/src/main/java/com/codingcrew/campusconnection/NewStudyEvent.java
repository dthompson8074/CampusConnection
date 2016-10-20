package com.codingcrew.campusconnection;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

public class NewStudyEvent extends AppCompatActivity {

    EditText mLocation, mExtraInfo, mCoursePrefix, mCourseNumber,
            mMaxResponse;
    // CheckBox mPay;
    Button mCreateButton;
    EventData mEvent = new EventData();

    public static Intent newIntentStudy(Context packageContext) {
        Intent i = new Intent(packageContext, NewStudyEvent.class);
        return i;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_study_event);

        mLocation = (EditText) findViewById(R.id.textLocation);
        mExtraInfo = (EditText) findViewById(R.id.extraInfo);
        mCourseNumber = (EditText) findViewById(R.id.courseNumber);
        mCoursePrefix = (EditText) findViewById(R.id.coursePrefix);
        mMaxResponse = (EditText) findViewById(R.id.maxResponders);
        // mPay = (CheckBox) findViewById(R.id.payBox);

        /* Enable the user to choose a Course Prefix*/

        mCoursePrefix.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mEvent.setPrefix(s.toString());

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        /* Enable the user to choose a Course Number*/

        mCourseNumber.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mEvent.setCourse(s.toString());

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        /* Enable the user to choose a maximum number of responders*/
        mMaxResponse.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mEvent.setMaxpeople(s.toString());

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        /* Enable the user to choose a location to meet
        *  As of now we have not implemented a means to launch the google
        *  map.  */
        /*TODO
          Code for map is already developed. Just need a way to connected it to this activity and
          retrieve the data*/
        mLocation.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mEvent.setlocation(s.toString());

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        /* Enable the user to input extra infomation*/
        mExtraInfo.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mEvent.setInformation(s.toString());

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        /* Enable the user to choose they will pay or not
        mPay.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            // Set the crime's solved property
                  mEvent.setPayed(isChecked);
                }    });
                */

        /* create event*/
        mCreateButton = (Button) findViewById(R.id.createEvent);
        mCreateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast = Toast.makeText(getApplicationContext(), "Event created for " + mEvent.getPrefix() +
                                " " + mEvent.getCourse() + ". " + "The maximum number of people is " +
                                mEvent.getMaxpeople() + " and the location is at " + mEvent.getlocation()
                                + ". Additional information is: " + mEvent.getInformation()
                        , Toast.LENGTH_LONG);
                toast.show();

            }
        });
    }

}
