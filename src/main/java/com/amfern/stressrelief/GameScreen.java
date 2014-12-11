package com.amfern.stressrelief;

import com.badlogic.gdx.ScreenAdapter;

public class GameScreen extends ScreenAdapter {
    Scene scene;
    AssInstance assInstance;

    // constructor
    public GameScreen(AssInstance assInstance) {
        super();
        this.assInstance = assInstance;

        AssInstance[] assInstances = new AssInstance[]{ assInstance };

        scene = new Scene(assInstances);
    }

    public Scene getScene() {
        return scene;
    }

    @Override
    public void render(float delta) {
        assInstance.updateAnimations();
        scene.render(delta);
    }

    @Override
    public void dispose() {
        scene.dispose();
    }
}