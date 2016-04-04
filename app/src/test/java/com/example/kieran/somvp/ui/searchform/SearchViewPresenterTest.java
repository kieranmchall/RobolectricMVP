package com.example.kieran.somvp.ui.searchform;

import android.content.Context;
import android.content.Intent;

import com.example.kieran.somvp.ui.searchresults.SearchResultsActivity;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

public class SearchViewPresenterTest {

    SearchViewPresenter mPresenter;

    @Mock
    private SearchView mSearchView;

    @Mock
    private Context mContext;

    @Mock
    private SearchResultsActivity.IntentCreator mIntentCreator;

    @Mock
    private Intent mIntent;

    @Before
    public void setup() throws Exception {
        initMocks(this);
        mPresenter = new SearchViewPresenter(mSearchView, mIntentCreator);
    }

    @Test
    public void testOnClick_ShouldGetSearchTextFromView () {
        //arrange
        String someSeachText = "some search";
        when(mSearchView.getSearchText()).thenReturn(someSeachText);
        when(mIntentCreator.createSearchActivityIntent(someSeachText, mContext)).thenReturn(mIntent);

        //act
        mPresenter.onSearchClicked(mContext);

        //assert
        verify(mSearchView).getSearchText();

        verify(mIntentCreator).createSearchActivityIntent(someSeachText, mContext);
        verify(mContext).startActivity(mIntent);
        verifyNoMoreInteractions(mContext);
    }

}