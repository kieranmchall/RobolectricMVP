package com.example.kieran.somvp.ui.base;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.example.kieran.somvp.R;

/**
 * Created by kieran on 04/04/2016.
 */
public abstract class BaseFragmentActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentView());
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        insertContentFragment();
    }

    private void insertContentFragment() {
        if (getContentFragment() == null) {
            return;
        }

        Fragment searchFragment = getContentFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.content, searchFragment).commitAllowingStateLoss();
    }

    protected abstract int getContentView();

    protected abstract Fragment getContentFragment();
}
