package com.example.kieran.somvp.inject.presentation;

import com.example.kieran.somvp.ui.searchform.SearchView;
import com.example.kieran.somvp.ui.searchform.SearchViewPresenter;
import com.example.kieran.somvp.ui.searchresults.SearchResultsActivity;

public class PresenterFactoryImpl implements PresenterFactory {

    @Override
    public SearchViewPresenter getPresenter(SearchView searchView) {
        return new SearchViewPresenter(searchView, new SearchResultsActivity.IntentCreator());
    }

}
