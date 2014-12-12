package com.amfern.stressrelief;

import android.util.Log;
import android.os.Process;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g3d.Model;
import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.Texture;

class StressRelief extends Game implements LoadingScreenListener {
    AssController assController;

    @Override
    public void doneLoading(Model assModel, Texture background) {
        AssInstance assInstance;

        try {
            assInstance = new AssInstance(assModel);
        } catch (Exception e) {
            Log.e("stressrelief", "Invalid ass characted g3db", e);
            Process.killProcess(Process.myPid());
            System.exit(1);
            return;
        }

        GameScreen gScreen = new GameScreen(assInstance, background);
        Camera cam = gScreen.getScene().getCamera();
        
        setScreen(gScreen);
        assController = new AssController(assInstance, cam);
    }

    @Override
    public void create() {
        setScreen( new LoadingScreen(this) );
    }
}