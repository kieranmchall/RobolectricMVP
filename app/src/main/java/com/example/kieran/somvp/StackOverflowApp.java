package com.example.kieran.somvp;

import android.app.Application;

import com.example.kieran.somvp.inject.presentation.DaggerPresentationComponent;
import com.example.kieran.somvp.inject.presentation.PresentationComponent;
import com.example.kieran.somvp.inject.presentation.PresentationModule;

/**
 * Created by kieran on 04/04/2016.
 */
public class StackOverflowApp extends Application {

    private PresentationComponent mPresentationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        initComponent();
    }

    PresentationModule getPresentationModule() {
        return new PresentationModule();
    }

    public PresentationComponent getPresentationComponent() {
        return mPresentationComponent;
    }

    void initComponent() {
        mPresentationComponent = DaggerPresentationComponent.builder()
                .presentationModule(getPresentationModule())
                .build();
    }

}
