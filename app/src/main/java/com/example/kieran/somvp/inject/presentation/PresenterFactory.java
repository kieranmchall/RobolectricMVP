package com.example.kieran.somvp.inject.presentation;

import com.example.kieran.somvp.ui.searchform.SearchView;
import com.example.kieran.somvp.ui.searchform.SearchViewPresenter;

/**
 * Created by kieran on 04/04/2016.
 */
public interface PresenterFactory {

    SearchViewPresenter getPresenter(SearchView searchView);

}
