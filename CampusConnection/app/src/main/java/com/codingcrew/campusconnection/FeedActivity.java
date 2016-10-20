package com.codingcrew.campusconnection;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class FeedActivity extends AppCompatActivity {

    User mUser = User.getInstance();

    public static Intent newIntentFeed(Context packageContext) {
        Intent i = new Intent(packageContext, FeedActivity.class);
        return i;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_feed);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_feed, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        Intent i;
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
