package com.codingcrew.campusconnection;

/**
 * Created by Saul on 11/8/2016.
 */

import android.app.TimePickerDialog;
import android.os.Bundle;
import android.app.Fragment;
import android.widget.TextView;
import android.app.DialogFragment;
import android.app.Dialog;
import java.util.Calendar;
import android.widget.TimePicker;


/**
 * A simple {@link Fragment} subclass.
 */
public class TimePickerFragment extends DialogFragment implements TimePickerDialog.OnTimeSetListener {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
//Use the current time as the default values for the time picker
        final Calendar c = Calendar.getInstance();
        int hour = c.get(Calendar.HOUR_OF_DAY);
        int minute = c.get(Calendar.MINUTE);

        //Create and return a new instance of TimePickerDialog
        return new TimePickerDialog(getActivity(), this, hour, minute,
                false);
    }

    //onTimeSet() callback method
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        //Do something with the user chosen time
        //Get reference of host activity (XML Layout File) TextView widget
        TextView tv = (TextView) getActivity().findViewById(R.id.beginTime);
        //Set a message for user
        //Display the user changed time on TextView

        String amOrpm = "AM";
        String currentHour = "0";
        String currentMin = "0";
        if (hourOfDay > 11) {
            amOrpm = "PM";
        }
        if (hourOfDay < 10) {
            currentHour += String.valueOf(hourOfDay);

        }
        if (hourOfDay >= 10 & hourOfDay <= 11) {
            currentHour = String.valueOf(hourOfDay);
        }
        if (hourOfDay == 0 || hourOfDay == 12) {
            currentHour = String.valueOf(12);
        }
        if (hourOfDay > 12) {
            currentHour = String.valueOf(hourOfDay - 12);
        }
        if (minute < 10) {
            currentMin += String.valueOf(minute);
        } else {
            currentMin = String.valueOf(minute);
        }

        tv.setText(currentHour
                + ":" + currentMin + amOrpm);
    }
}
