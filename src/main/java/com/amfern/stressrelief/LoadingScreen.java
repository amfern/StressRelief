package com.amfern.stressrelief;

import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.g3d.Model;

public class LoadingScreen extends ScreenAdapter {
    private static final String BUTT_MODEL_PATH = "butt.g3dj";

    private AssetManager assets;
    private LoadingScreenListener listener;

    // constructor
    public LoadingScreen(LoadingScreenListener listener) {
        super();
        this.listener = listener;
        assets = new AssetManager();
        assets.load(BUTT_MODEL_PATH, Model.class);
    }

    @Override
    public void render(float delta) {
        if(assets.update()) {
            Model buttModel = assets.get(BUTT_MODEL_PATH, Model.class);
            listener.doneLoading(buttModel);
        }
    }
}