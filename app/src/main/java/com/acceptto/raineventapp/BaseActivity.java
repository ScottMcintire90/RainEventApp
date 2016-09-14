package com.acceptto.raineventapp;

import android.app.ActionBar;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import butterknife.Bind;
import butterknife.ButterKnife;

public class BaseActivity extends AppCompatActivity {
    private WebView myWebView;
    @Bind(R.id.navList)
    ListView mDrawerList;
    private ArrayAdapter<String> mAdapter;
    private ActionBarDrawerToggle mDrawerToggle;
    @Bind(R.id.drawer_layout)
    DrawerLayout mDrawerLayout;
    private String mActivityTitle;


    protected void onCreateDrawer() {
        setContentView(R.layout.activity_main);

        myWebView = (WebView) findViewById(R.id.webView);
        myWebView.getSettings().setJavaScriptEnabled(true);
        myWebView.getSettings().setDomStorageEnabled(true);
        myWebView.setWebViewClient(new WebViewClient() {
            @Override
            public void onLoadResource(WebView view, String url) {
                myWebView.loadUrl("javascript:(function() { " + "document.getElementsByClassName('dl-trigger')[0].style.display = 'none'; " + "})()");
            }
        });

    ButterKnife.bind(this);
        mActivityTitle = getTitle().toString();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        addDrawerItems();
        setupDrawer();
    }

    private void addDrawerItems() {
        String[] navArray = {"Homepage", "Program", "Sightseeing", "Accommodation", "Transportation", "Members", "Sponsors", "Contact Us" };
        mAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, navArray);
        mDrawerList.setAdapter(mAdapter);

        mDrawerList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position == 1) {
                    myWebView.loadUrl("http://rainrfid.acceptto.com/program/");
                    mDrawerLayout.closeDrawers();
                }
                if(position == 0) {
                    myWebView.loadUrl("http://rainrfid.acceptto.com");
                    mDrawerLayout.closeDrawers();
                }
                if(position == 2) {
                    myWebView.loadUrl("http://rainrfid.acceptto.com/sightseeing/");
                }
                if(position == 3) {
                    myWebView.loadUrl("http://rainrfid.acceptto.com/accommodation/");
                    mDrawerLayout.closeDrawers();
                }
                if(position == 4) {
                    myWebView.loadUrl("http://rainrfid.acceptto.com/transportation/");
                    mDrawerLayout.closeDrawers();
                }
                if(position == 5) {
                    myWebView.loadUrl("http://rainrfid.acceptto.com/members/");
                    mDrawerLayout.closeDrawers();
                }
                if(position == 6) {
                    myWebView.loadUrl("http://rainrfid.acceptto.com/sponsors/");
                    mDrawerLayout.closeDrawers();
                }
                if(position == 7) {
                    myWebView.loadUrl("http://rainrfid.acceptto.com/contact/");
                    mDrawerLayout.closeDrawers();
                }
            }
        });
    }


    private void setupDrawer() {
        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.drawer_open, R.string.drawer_close) {

            /** Called when a drawer has settled in a completely open state. */
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                getSupportActionBar().setTitle("Tabs");
                invalidateOptionsMenu(); // creates call to onPrepareOptionsMenu()
            }

            /** Called when a drawer has settled in a completely closed state. */
            public void onDrawerClosed(View view) {
                super.onDrawerClosed(view);
                getSupportActionBar().setTitle(mActivityTitle);
                invalidateOptionsMenu(); // creates call to onPrepareOptionsMenu()
            }
        };

        mDrawerToggle.setDrawerIndicatorEnabled(true);
        mDrawerLayout.addDrawerListener(mDrawerToggle);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        // Sync the toggle state after onRestoreInstanceState has occurred.
        mDrawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        mDrawerToggle.onConfigurationChanged(newConfig);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        // Activate the navigation drawer toggle
        if (mDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}