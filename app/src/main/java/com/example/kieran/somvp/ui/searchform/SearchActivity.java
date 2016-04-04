package com.example.kieran.somvp.ui.searchform;

import android.support.v4.app.Fragment;

import com.example.kieran.somvp.R;
import com.example.kieran.somvp.ui.base.BaseActivity;

public class SearchActivity extends BaseActivity {

    @Override
    protected Fragment getContentFragment() {
        return new SearchFragment();
    }

    @Override
    protected int getContentView() {
        return R.layout.activity_search;
    }
}
