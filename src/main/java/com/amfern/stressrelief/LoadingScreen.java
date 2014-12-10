package com.amfern.stressrelief;

import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.assets.AssetManager;

public class LoadingScreen extends ScreenAdapter {
    // private boolean loading;
    // private AssetManager assets;
    // private Model model;
    private LoadingScreenListener listener;

    // constructor
    public LoadingScreen(LoadingScreenListener listener) {
        super();
        this.listener = listener;

        listener.doneLoading();
    }
}