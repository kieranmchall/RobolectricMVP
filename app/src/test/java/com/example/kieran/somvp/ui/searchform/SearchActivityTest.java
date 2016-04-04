package com.example.kieran.somvp.ui.searchform;

import android.support.v4.app.Fragment;

import com.example.kieran.somvp.BuildConfig;
import com.example.kieran.somvp.R;
import com.example.kieran.somvp.ui.base.BaseActivity;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;
import org.robolectric.util.ActivityController;

import static org.junit.Assert.*;

/**
 * Created by kieran on 04/04/2016.
 */
@RunWith(RobolectricGradleTestRunner.class)
@Config(sdk = 21, constants = BuildConfig.class)
public class SearchActivityTest {

    private SearchActivity underTest;

    @Before
    public void setUp() throws Exception {
        underTest = Robolectric.buildActivity(SearchActivity.class).create().get();
    }

    @Test
    public void testOnCreate_ShouldInsertSearchFragment() throws Exception {
        //assert
        Fragment fragmentById = underTest.getSupportFragmentManager().findFragmentById(R.id.content);
        assertNotNull(fragmentById);
        assertTrue(fragmentById instanceof SearchFragment);
    }
}