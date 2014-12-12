package com.amfern.stressrelief;

import com.badlogic.gdx.utils.Array;

import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g3d.ModelInstance;

public class GameScreen extends ScreenAdapter {
    Scene scene;
    AssInstance assInstance;
    Texture background;

    // constructor
    public GameScreen(AssInstance assInstance, Texture background) {
        super();
        this.assInstance = assInstance;
        this.background = background;

        scene = new Scene();
    }

    private void renderScene(Scene scene, AssInstance instance, Texture background) {
        scene.clear();
        scene.renderBackground(background);
        scene.renderInstances(new Array<ModelInstance>( new ModelInstance[] { instance } ));
    }

    public Scene getScene() {
        return scene;
    }

    @Override
    public void render(float delta) {
        assInstance.updateAnimations();
        renderScene(scene, assInstance, background);
    }

    @Override
    public void dispose() {
        scene.dispose();
    }
}