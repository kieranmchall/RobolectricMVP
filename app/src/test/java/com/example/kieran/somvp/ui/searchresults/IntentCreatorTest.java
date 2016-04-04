package com.example.kieran.somvp.ui.searchresults;

import android.content.Context;
import android.content.Intent;

import com.example.kieran.somvp.BuildConfig;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;

import static org.junit.Assert.assertEquals;
import static org.mockito.MockitoAnnotations.initMocks;

/**
 * Created by kieran on 04/04/2016.
 */
@RunWith(RobolectricGradleTestRunner.class)
@Config(sdk = 21, constants = BuildConfig.class)
public class IntentCreatorTest {

    private SearchResultsActivity.IntentCreator underTest;

    @Mock
    Context mContext;

    @Before
    public void setup() throws Exception {
        initMocks(this);
        underTest = new SearchResultsActivity.IntentCreator();
    }

    @Test
    public void testStartSearchActivityIntent() throws Exception {
        String someString = "some_string";

        Intent intent = underTest.createSearchActivityIntent(someString, mContext);

        assertEquals(intent.getStringExtra(SearchResultsActivity.IntentCreator.EXTRA_SEARCH_TEXT), someString);
        assertEquals(intent.getComponent().getClassName(), SearchResultsActivity.class.getName());
    }
}