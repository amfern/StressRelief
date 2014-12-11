package com.amfern.stressrelief;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g3d.Model;
import com.badlogic.gdx.graphics.g3d.ModelInstance;

class StressRelief extends Game implements LoadingScreenListener {
    AssController assController;

    @Override
    public void doneLoading(Model assModel) {
        AssInstance assInstance = new AssInstance(assModel);
        assController = new AssController(assInstance);
        setScreen( new GameScreen(assInstance) );
    }

    @Override
    public void create() {
        setScreen( new LoadingScreen(this) );
    }
}