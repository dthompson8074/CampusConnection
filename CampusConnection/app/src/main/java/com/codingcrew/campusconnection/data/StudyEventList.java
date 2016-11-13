package com.codingcrew.campusconnection.data;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by Saul on 10/28/2016.
 */

public class StudyEventList {

    private static StudyEventList sStudyEventList;
    private List<EventData> mStudyEvents;

    public static StudyEventList getInstance(Context context) {
        if (sStudyEventList == null) {
            sStudyEventList = new StudyEventList(context);
        }
        return sStudyEventList;
    }

    private StudyEventList(Context comtext){
        mStudyEvents = new ArrayList<>();

    }

    public List<EventData> getEvents() {
        return mStudyEvents;

    }

    public EventData getEvent(UUID id) {
        for (EventData event : mStudyEvents) {
        if (event.getID().equals(id)) {
            return event;
        }
        }
        return null;
    }

    public boolean getCopy(UUID id) {
        for (EventData event : mStudyEvents) {
            if (event.getID().equals(id)) {
                return true;
            }
        }
        return false;
    }

    public void addNewItem(EventData event){
            mStudyEvents.add(event);
    }

}
