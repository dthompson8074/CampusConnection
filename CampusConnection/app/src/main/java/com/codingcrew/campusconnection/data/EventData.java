package com.codingcrew.campusconnection.data;

import java.util.UUID;

/**
 * Created by Saul on 10/14/2016.
 */

public class EventData {
    /* This class will keep track of a single event data
     */
    public static final String MAX_PEOPLE = "20";
    private String mMaxpeople;
    private String mPrefix;
    private String mCourse;
    private String mlocation;
    private String mInformation;
    private boolean mPayed;
    private UUID mID;
    private String mTitle;

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public boolean getPayed() {
        return mPayed;
    }

    public void setPayed(boolean payed) {
        mPayed = payed;
    }

    public EventData() {
        mMaxpeople = MAX_PEOPLE;
        mPrefix = "#####";
        mCourse = "CS";
        mlocation = "Texas Tech";
        mInformation = "Extra";
        mID = UUID.randomUUID();
        mTitle = "Study Event";
    }

    public String getMaxpeople() {
        return mMaxpeople;
    }

    public void setMaxpeople(String maxpeople) {
        mMaxpeople = maxpeople;
    }

    public String getPrefix() {
        return mPrefix;
    }

    public void setPrefix(String prefix) {
        mPrefix = prefix;
    }

    public String getCourse() {
        return mCourse;
    }

    public void setCourse(String courseNumber) {
        mCourse = courseNumber;
    }

    public String getlocation() {
        return mlocation;
    }

    public void setlocation(String mlocation) {
        this.mlocation = mlocation;
    }

    public String getInformation() {
        return mInformation;
    }

    public void setInformation(String information) {
        mInformation = information;
    }

    public UUID getID() {
        return mID;
    }

    public void setID(UUID ID) {
        mID = ID;
    }
}
