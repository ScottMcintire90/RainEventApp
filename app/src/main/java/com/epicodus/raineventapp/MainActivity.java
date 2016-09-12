package com.epicodus.raineventapp;

import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class MainActivity extends BaseActivity {
    private WebView myWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        super.onCreateDrawer();
        DrawerLayout drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

        myWebView = (WebView) findViewById(R.id.webView);
        myWebView.getSettings().setJavaScriptEnabled(true);
        myWebView.getSettings().setDomStorageEnabled(true);
        myWebView.setWebViewClient(new WebViewClient() {
            @Override
            public void onLoadResource(WebView view, String url) {
                myWebView.loadUrl("javascript:(function() { " + "document.getElementsByClassName('dl-trigger')[0].style.display = 'none'; " + "})()");
                myWebView.loadUrl("javascript:(function() { " + "document.getElementsByClassName('msp-cn-1-11')[0].style.display = 'none'; " + "})()");

            }
        });
        myWebView.loadUrl("https://rainrfid.acceptto.com");
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

        if(id == 1) {
            myWebView.loadUrl("http://rainrfid.acceptto.com/program/");
            return true;
        }


        return super.onOptionsItemSelected(item);
    }


}
