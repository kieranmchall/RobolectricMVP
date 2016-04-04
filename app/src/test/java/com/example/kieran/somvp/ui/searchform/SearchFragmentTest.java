package com.example.kieran.somvp.ui.searchform;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.kieran.somvp.BuildConfig;
import com.example.kieran.somvp.R;
import com.example.kieran.somvp.TestApplication;
import com.example.kieran.somvp.inject.presentation.PresentationModule;
import com.example.kieran.somvp.inject.presentation.PresenterFactory;
import com.example.kieran.somvp.inject.presentation.PresenterFactoryImpl;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.annotation.Config;
import org.robolectric.shadows.support.v4.SupportFragmentTestUtil;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class, manifest = "/main/AndroidManifest.xml", sdk = 21, application = TestApplication.class)
//have to set SDK to 21 as sdk > 22 not yet working properly with Robolectric :(
public class SearchFragmentTest {

    private static final String SOME_SEARCH_TEXT = "some search text";

    private SearchFragment underTest;
    private View mRootView;

    @Mock
    private SearchViewPresenter mPresenter;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        setupMockModules();

        underTest = new SearchFragment();
        assertNull(underTest.mSearchText);

        SupportFragmentTestUtil.startFragment(underTest);
        mRootView = underTest.getView();
    }

    private void setupMockModules() {
        TestApplication app = (TestApplication) RuntimeEnvironment.application;
        MockPresentationModule presentationModule = new MockPresentationModule(mPresenter);
        app.setPresentationModule(presentationModule);
    }

    @Test
    public void testOnCreateView_ShouldCreateSearchText() throws Exception {
        assertNotNull(underTest.mSearchText);
    }

    @Test
    public void testGetSearchText() throws Exception {
        EditText editText = (EditText) mRootView.findViewById(R.id.searchText);
        editText.setText(SOME_SEARCH_TEXT);

        String text = underTest.getSearchText();

        assertEquals(SOME_SEARCH_TEXT, text);
    }

    @Test
    public void testOnSearchClicked() {
        Button button = (Button) mRootView.findViewById(R.id.searchButton);

        button.performClick();

        verify(mPresenter).onSearchClicked(underTest.getActivity());
        verifyNoMoreInteractions(mPresenter);
    }

    private static class MockPresentationModule extends PresentationModule {

        private SearchViewPresenter mSearchViewPresenter;

        public MockPresentationModule(SearchViewPresenter mSearchViewPresenter) {
            this.mSearchViewPresenter = mSearchViewPresenter;
        }

        @Override
        public PresenterFactory providesSearchFormViewPresenter() {
            return new PresenterFactoryImpl() {
                @Override
                public SearchViewPresenter getPresenter(SearchView searchView) {
                    return mSearchViewPresenter;
                }
            };
        }
    }

}