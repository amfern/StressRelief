package com.amfern.stressrelief;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g3d.Model;
import com.badlogic.gdx.graphics.g3d.ModelInstance;

class StressRelief extends Game implements LoadingScreenListener {
    @Override
    public void doneLoading(Model assModel) {
        AssInstance assInstance = new AssInstance(assModel);
        ModelInstance[] instances = new ModelInstance[]{ assInstance };

        setScreen( new GameScreen(instances) );
    }

    @Override
    public void create() {
        setScreen( new LoadingScreen(this) );
    }
}