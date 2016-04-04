package com.example.kieran.somvp;

import com.example.kieran.somvp.inject.presentation.PresentationModule;

/**
 * Created by kieran on 04/04/2016.
 */
public class TestApplication extends StackOverflowApp {

    private PresentationModule mPresentationModule;

    @Override
    PresentationModule getPresentationModule() {
        if (mPresentationModule != null) {
            return mPresentationModule;
        }
        return super.getPresentationModule();
    }

    public void setPresentationModule(PresentationModule presentationModule) {
        mPresentationModule = presentationModule;
        initComponent();
    }
}
