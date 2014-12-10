package com.amfern.stressrelief;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;

class StressRelief extends Game implements LoadingScreenListener{
    @Override
    public void doneLoading() {
        setScreen(new GameScreen());
    }

    @Override
    public void create() {
        setScreen(new LoadingScreen(this));
    }
}