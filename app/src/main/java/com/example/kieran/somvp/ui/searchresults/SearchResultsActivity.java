package com.example.kieran.somvp.ui.searchresults;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;

import com.example.kieran.somvp.R;
import com.example.kieran.somvp.ui.base.BaseFragmentActivity;

public class SearchResultsActivity extends BaseFragmentActivity {

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
