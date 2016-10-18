package com.codingcrew.campusconnection;


        import android.content.Context;
        import android.content.Intent;
        import android.os.Bundle;
        import android.support.design.widget.TabLayout;
        import android.support.v4.view.ViewPager;
        import android.support.v7.app.AppCompatActivity;
        import android.support.v7.widget.Toolbar;
        import android.view.Menu;
        import android.view.MenuItem;
        import android.widget.TextView;

        import com.codingcrew.campusconnection.R;
        import com.codingcrew.campusconnection.tabs.PagerAdapter;


public class ProfileActivity extends AppCompatActivity {

    private static final String EXTRA_Name =
            "com.codingcrew.campusconnection.name";

    public static Intent newIntent(Context packageContext, String mName) {
        Intent i = new Intent(packageContext, ProfileActivity.class);
        i.putExtra(EXTRA_Name, mName);
        return i;
    }

    TextView mProfileName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        tabLayout.addTab(tabLayout.newTab().setText("Study Event"));
        tabLayout.addTab(tabLayout.newTab().setText("Schedule"));
        //tabLayout.addTab(tabLayout.newTab().setText("Feed"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);


        final ViewPager viewPager = (ViewPager) findViewById(R.id.pager);
        final PagerAdapter adapter = new PagerAdapter
                (getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        mProfileName = (TextView) findViewById(R.id.ProfileName);
        mProfileName.setText(getIntent().getStringExtra(EXTRA_Name));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_add) {
            Intent i = new Intent(ProfileActivity.this, NewStudyEvent.class);
            startActivity(i);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}