package com.amfern.stressrelief;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g3d.Model;
import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.graphics.Camera;

class StressRelief extends Game implements LoadingScreenListener {
    AssController assController;

    @Override
    public void doneLoading(Model assModel) {
        AssInstance assInstance = new AssInstance(assModel);
        GameScreen gScreen = new GameScreen(assInstance);
        Camera cam = gScreen.getScene().getCamera();
        
        setScreen(gScreen);
        assController = new AssController(assInstance, cam);
    }

    @Override
    public void create() {
        setScreen( new LoadingScreen(this) );
    }
}