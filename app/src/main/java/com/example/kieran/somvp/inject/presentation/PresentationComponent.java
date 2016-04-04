package com.example.kieran.somvp.inject.presentation;

import com.example.kieran.somvp.ui.searchform.SearchFragment;

import dagger.Component;

/**
 * Created by kieran on 03/04/2016.
 */
@Component(modules = PresentationModule.class)
public interface PresentationComponent {
    void inject(SearchFragment searchFragment);
}
