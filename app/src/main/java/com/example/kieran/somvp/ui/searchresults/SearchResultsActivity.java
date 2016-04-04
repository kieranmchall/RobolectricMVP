package com.example.kieran.somvp.ui.searchresults;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import com.example.kieran.somvp.R;
import com.example.kieran.somvp.ui.base.BaseActivity;

public class SearchResultsActivity extends BaseActivity {

    @Override
    protected Fragment getContentFragment() {
        return new SearchResultsFragment();
    }

    @Override
    protected int getContentView() {
        return R.layout.activity_search_results;
    }

    public static class IntentCreator {

        public static final String EXTRA_SEARCH_TEXT = "IntentCreator.SearchText";

        public Intent createSearchActivityIntent(String search, Context context) {
            Intent intent = new Intent(context, SearchResultsActivity.class);
            intent.putExtra(EXTRA_SEARCH_TEXT, search);
            return intent;
        }
    }

}
