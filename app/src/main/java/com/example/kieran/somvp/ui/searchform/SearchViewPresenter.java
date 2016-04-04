package com.example.kieran.somvp.ui.searchform;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;

import com.example.kieran.somvp.ui.searchresults.SearchResultsActivity;

/**
 * Created by kieran on 02/04/2016.
 */
public class SearchViewPresenter {

    private final SearchView mView;
    private final SearchResultsActivity.IntentCreator mIntentCreator;

    public SearchViewPresenter(SearchView view, SearchResultsActivity.IntentCreator intentCreator) {
        mView = view;
        mIntentCreator = intentCreator;
    }

    public void onSearchClicked(final Context context) {
        final String search = mView.getSearchText();
        final Intent searchActivityIntent = getSearchActivityIntent(search, context);
        context.startActivity(searchActivityIntent);
    }

    @NonNull
    private Intent getSearchActivityIntent(String search, Context context) {
        return mIntentCreator.createSearchActivityIntent(search, context);
    }
}
