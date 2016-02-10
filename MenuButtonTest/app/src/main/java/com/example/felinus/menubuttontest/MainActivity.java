package com.example.felinus.menubuttontest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "Main";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.ICE_CREAM_SANDWICH) {
            MenuItemCompat.OnActionExpandListener expandListener = new MenuItemCompat.OnActionExpandListener() {
                @Override
                public boolean onMenuItemActionExpand(MenuItem item) {
                    Log.v(TAG, "onMenuItemActionExpand");
                    return true;
                }

                @Override
                public boolean onMenuItemActionCollapse(MenuItem item) {
                    Log.v(TAG, "onMenuItemActionCollapse");
                    return true;
                }
            };
            MenuItem actionMenuItem = menu.findItem(R.id.action_search);
            MenuItemCompat.setOnActionExpandListener(actionMenuItem, expandListener);
        }
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.action_search:
                Log.v(TAG, "action_search");
                return true;
            case R.id.action_settings:
                return true;
            case R.id.action_favorite:
                startActivity(new Intent(this,MyChildActivity.class));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}