package com.codingcrew.campusconnection;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.codingcrew.campusconnection.data.EventData;
import com.codingcrew.campusconnection.data.StudyEventList;

import java.util.UUID;

public class NewStudyEvent extends AppCompatActivity{

    public static final String EXTRA_EVENT_ID = "com.codingcrew.campusconnection.event_id";

    EditText mLocation, mExtraInfo, mCoursePrefix, mCourseNumber,
            mMaxResponse;
    // CheckBox mPay;
    Button mCreateButton;
    EventData mEvent = new EventData();

    public static Intent newIntentStudy(Context packageContext) {
        Intent i = new Intent(packageContext, NewStudyEvent.class);
        return i;
    }

    public static Intent newIntentStudy(Context packageContext, UUID eventId) {
        Intent intent = new Intent(packageContext, NewStudyEvent.class);
        intent.putExtra(EXTRA_EVENT_ID, eventId);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_study_event);

        UUID eventId = (UUID) getIntent().getSerializableExtra(EXTRA_EVENT_ID);
        if(eventId != null) {
            mEvent = StudyEventList.getInstance(getApplicationContext()).getEvent(eventId);
        }
        mLocation = (EditText) findViewById(R.id.textLocation);
        mExtraInfo = (EditText) findViewById(R.id.extraInfo);
        mCourseNumber = (EditText) findViewById(R.id.courseNumber);
        mCoursePrefix = (EditText) findViewById(R.id.coursePrefix);
        mMaxResponse = (EditText) findViewById(R.id.maxResponders);
        // mPay = (CheckBox) findViewById(R.id.payBox);

        /* Enable the user to choose a Course Prefix*/

        mCoursePrefix.setText(mEvent.getCourse());
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

        Spinner spinner = (Spinner) findViewById(R.id.Spinner_Course);
// Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.course_name, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                mEvent.setTitle(parent.getItemAtPosition(position).toString());
            }
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });



        mCreateButton = (Button) findViewById(R.id.createEvent);
        mCreateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast = Toast.makeText(getApplicationContext(), "Event created for " + mEvent.getTitle() +
                                " " + mEvent.getCourse() + ". " + "The maximum number of people is " +
                                mEvent.getMaxpeople() + " and the location is at " + mEvent.getlocation()
                                + ". Additional information is: " + mEvent.getInformation()
                        , Toast.LENGTH_LONG);
                toast.show();

                StudyEventList listofevent = StudyEventList.getInstance(getApplicationContext());
                listofevent.addNewItem(mEvent);


            }
        });


    }

}
