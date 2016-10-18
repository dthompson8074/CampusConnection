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
        int id = item.getItemId();

        if (id == R.id.profile) {

            Intent i = ProfileActivity.newIntent(FeedActivity.this, mUser.getUsername() );
            startActivity(i);
            return true;
        } else if (id == R.id.createEventPage){

            Intent i = NewStudyEvent.newIntentStudy(FeedActivity.this, mUser.getUsername());
            startActivity(i);
            return true;

        }

        return super.onOptionsItemSelected(item);
    }
}
