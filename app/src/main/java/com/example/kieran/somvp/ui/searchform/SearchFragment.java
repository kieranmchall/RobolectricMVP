package com.example.kieran.somvp.ui.searchform;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.example.kieran.somvp.R;
import com.example.kieran.somvp.StackOverflowApp;
import com.example.kieran.somvp.inject.presentation.PresentationComponent;
import com.example.kieran.somvp.inject.presentation.PresenterFactory;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * A placeholder fragment containing a simple view.
 */
public class SearchFragment extends Fragment implements SearchView {

    @Bind(R.id.searchText)
    EditText mSearchText;

    @Inject
    PresenterFactory mPresenterFactory;

    private SearchViewPresenter mPresenter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_search, container, false);
        PresentationComponent component = ((StackOverflowApp) getActivity().getApplicationContext()).getPresentationComponent();
        component.inject(this);
        ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mPresenter = mPresenterFactory.getPresenter(this);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @Override
    public String getSearchText() {
        return mSearchText.getText().toString();
    }

    @OnClick(R.id.searchButton)
    void onSearchClicked() {
        mPresenter.onSearchClicked(getActivity());
    }
}
