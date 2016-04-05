package com.example.kieran.somvp.ui.base;

import android.support.v4.app.Fragment;

import com.example.kieran.somvp.BuildConfig;
import com.example.kieran.somvp.R;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;

import static org.junit.Assert.assertNull;

@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 21)
public class BaseFragmentActivityTest {

    private MyBaseFragmentActivity underTest;

    @Before
    public void setup() throws Exception {
        underTest = Robolectric.buildActivity(MyBaseFragmentActivity.class).create().get();
    }

    @Test
    public void testOnCreate_ShouldNotCreateFragment() throws Exception {
        assertNull(underTest.getSupportFragmentManager().findFragmentById(R.id.content));
    }

    private static class MyBaseFragmentActivity extends BaseFragmentActivity {

        @Override
        protected int getContentView() {
            return R.layout.activity_base;
        }

        @Override
        protected Fragment getContentFragment() {
            // We want to test the null case here - implementing activities should test that the
            // right fragment has been inserted
            return null;
        }
    }

}