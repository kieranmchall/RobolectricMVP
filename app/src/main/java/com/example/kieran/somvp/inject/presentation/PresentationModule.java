package com.example.kieran.somvp.inject.presentation;

import dagger.Module;
import dagger.Provides;

/**
 * Created by kieran on 03/04/2016.
 */
@Module
public class PresentationModule {

    @Provides
    public PresenterFactory providesSearchFormViewPresenter() {
        return new PresenterFactoryImpl();
    }

}
