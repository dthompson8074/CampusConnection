package com.codingcrew.campusconnection.tabs;

/**
 * Created by Saul on 10/13/2016.
 */

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.codingcrew.campusconnection.R;
import com.codingcrew.campusconnection.data.EventData;
import com.codingcrew.campusconnection.data.StudyEventList;

import java.util.List;

public class TabFragment1 extends Fragment {

    private RecyclerView mTabFragment1RecyclerView;
    private TabFragment1Adapter mTabFragment1Adapter;
    Intent i;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab_fragment_1, container, false);
        mTabFragment1RecyclerView = (RecyclerView) view.findViewById(R.id.tab_1_recycleView);
        mTabFragment1RecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
//        updateUI();

        return view;
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
        StudyEventList mStudyEventList = StudyEventList.getInstance(getActivity());
        List<EventData> events = mStudyEventList.getEvents();

        if (mTabFragment1Adapter == null) {
            mTabFragment1Adapter = new TabFragment1Adapter(events);
            mTabFragment1RecyclerView.setAdapter(mTabFragment1Adapter);
        } else {
            mTabFragment1Adapter.notifyDataSetChanged();
        }
    }

/*  EventHolder(class)
    This class will hold all the information regarding what the user will see per item(View)
    in the RecyclerView. It also implements a onClickListener(this) in the class. This allow
    us not to have to make a new instance of onClickListener( new View).
 */
private class TabFragment1Holder extends RecyclerView.ViewHolder implements View.OnClickListener{

    private EventData mEventData;
    private TextView mTitleTextView;
    private TextView mTimeStart;
    private TextView mTimeEnd;
    private TextView mMaxpeopleTextView;

    //EventHolder(Constructor)
    public TabFragment1Holder(View itemView) {
        super(itemView);
        itemView.setOnClickListener(this);
        mTitleTextView = (TextView) itemView.findViewById(R.id.mTitle);
        mTimeStart = (TextView) itemView.findViewById(R.id.mTimeStart);
        mTimeEnd = (TextView) itemView.findViewById(R.id.mTineEnd);
        mMaxpeopleTextView = (TextView) itemView.findViewById(R.id.number_of_people);
    }
        // Allows FeedActivity to start when ever a view is clicked.
    @Override
    public void onClick(View v) {
        //TODO Delete Toast
        Toast.makeText(getActivity(),
                mEventData.getTitle() + " clicked!", Toast.LENGTH_SHORT)
                .show();

       //i = NewStudyEvent.newIntentStudy(TabFragment1.this, mEventData.getID());
       // startActivity(i);
    }

    /*  bindEvent(EventData)
        Sets the data for each individual views
     */
    public void bindEvent(EventData events)  {
        mEventData = events;
        mTitleTextView.setText(mEventData.getTitle());
        mTimeStart.setText(mEventData.getTimeStart());
        mMaxpeopleTextView.setText(mEventData.getMaxpeople());
        mTimeEnd.setText(mEventData.getTimeEnd());
    }
}

/*  EventAdapter(class)
    Is a class that connects the views to a RecycleView.
    This class also inflates the the custom layout(item_study_event).
    The custom layout holds the design for view that the RecycleView is
    showing.
 */
private class TabFragment1Adapter extends RecyclerView.Adapter<TabFragment1Holder> {
    private List<EventData> mEvent;

    // EventAdapter(Constructor)
    public TabFragment1Adapter(List<EventData> events) {
        mEvent = events;
    }

    @Override
    public TabFragment1Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
        View view = layoutInflater
                .inflate(R.layout.item_study_event, parent, false);
        return new TabFragment1Holder(view);
    }

    // Sets the data for the current view.
    @Override
    public void onBindViewHolder(TabFragment1Holder holder, int position) {
        EventData event = mEvent.get(position);
        holder.bindEvent(event);
    }

    // Returns the current number of items in the RecycleView
    @Override
    public int getItemCount() {
        return mEvent.size();
    }
}


}