package com.codingcrew.campusconnection;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.codingcrew.campusconnection.data.EventData;
import com.codingcrew.campusconnection.data.StudyEventList;

import java.util.List;

public class FeedActivity extends AppCompatActivity {

    /* Global variables use to keep the code D.R.Y.*/
    private RecyclerView mEventRecyclerView;
    private EventAdapter mEventAdapter;

    /* Intent is a class used to store informaion to either lauch another activity
       or to store information for later use.
     */
    Intent i;

    /*  newIntentFeed(Context)
        Takes the Contexts(the current information about an activity) to launch a
        different activity.
     */
    public static Intent newIntentFeed(Context packageContext) {
        Intent i = new Intent(packageContext, FeedActivity.class);
        return i;
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_feed);
        mEventRecyclerView = (RecyclerView)findViewById(R.id.event_recycler_view);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        mEventRecyclerView.setLayoutManager(linearLayoutManager);
        updateUI();

    }

    /*
        The android system calls onResume() when an activity is recreated by default.
        I have overrided the method so when even the activity is recreated to call
        updateUI() so the RecycleView reflect the changes made.
     */
    @Override public void onResume() {
        super.onResume();
        updateUI();
    }

    /*  updateUI()
        When a explicit change to the RecycleView is made. The RecycleView must be update to
        reflect the change. For instance when an new Event is created. The RecycleView will not
        show the change until the fucntion updateUI is called.
     */
    private void updateUI() {
        StudyEventList mStudyEventList = StudyEventList.getInstance(getApplicationContext());
        List<EventData> events = mStudyEventList.getEvents();

        if (mEventAdapter == null) {
            mEventAdapter = new EventAdapter(events);
            mEventRecyclerView.setAdapter(mEventAdapter);
        } else {
            mEventAdapter.notifyDataSetChanged();
        }
    }

    /*  EventHolder(class)
        This class will hold all the information regarding what the user will see per item(View)
        in the RecyclerView. It also implements a onClickListener(this) in the class. This allow
        us not to have to make a new instance of onClickListener( new View).
     */
    private class EventHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private EventData mEventData;
        private TextView mTitleTextView;
        private TextView mCourseTextView;
        private TextView mMaxpeopleTextView;

        //EventHolder(Constructor)
        public EventHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            mTitleTextView = (TextView) itemView.findViewById(R.id.mTitle);
            mCourseTextView = (TextView) itemView.findViewById(R.id.mTime);
            mMaxpeopleTextView = (TextView) itemView.findViewById(R.id.number_of_people);


        }

        // Allows FeedActivity to start when ever a view is clicked.
        @Override
        public void onClick(View v) {
            //TODO Delete Toast
            Toast.makeText(getApplicationContext(),
                    mEventData.getTitle() + " clicked!", Toast.LENGTH_SHORT)
                    .show();

            i = NewStudyEvent.newIntentStudy(FeedActivity.this, mEventData.getID());
            startActivity(i);
        }

        /*  bindEvent(EventData)
            Sets the data for each individual views
         */
        public void bindEvent(EventData events) {
            mEventData = events;
            mTitleTextView.setText(mEventData.getCourse());
            mCourseTextView.setText("12:00");
            mMaxpeopleTextView.setText(mEventData.getMaxpeople());
        }
    }

    /*  EventAdapter(class)
        Is a class that connects the views to a RecycleView.
        This class also inflates the the custom layout(item_study_event).
        The custom layout holds the design for view that the RecycleView is
        showing.
     */
    private class EventAdapter extends RecyclerView.Adapter<EventHolder> {
        private List<EventData> mEvent;

        // EventAdapter(Constructor)
        public EventAdapter(List<EventData> events) {
            mEvent = events;
        }

        @Override
        public EventHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(getApplicationContext());
            View view = layoutInflater
                    .inflate(R.layout.item_study_event, parent, false);
            return new EventHolder(view);
        }

        // Sets the data for the current view.
        @Override
        public void onBindViewHolder(EventHolder holder, int position) {
            EventData event = mEvent.get(position);
            holder.bindEvent(event);
        }

        // Returns the current number of items in the RecycleView
        @Override
        public int getItemCount() {
            return mEvent.size();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_feed, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {

            case R.id.profile:

                i = ProfileActivity.newIntent(FeedActivity.this);
                startActivity(i);
                return true;

            case R.id.createEventPage:

                i = NewStudyEvent.newIntentStudy(FeedActivity.this);
                startActivity(i);
                return true;


            default:
                return super.onOptionsItemSelected(item);
        }
    }
}

