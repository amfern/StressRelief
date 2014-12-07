package com.amfern.stressrelief;

import android.os.Bundle;
import android.util.Log;

import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.PerspectiveCamera;
import com.badlogic.gdx.graphics.VertexAttributes.Usage;
import com.badlogic.gdx.graphics.g3d.Environment;
import com.badlogic.gdx.graphics.g3d.Model;
import com.badlogic.gdx.graphics.g3d.ModelBatch;
import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.graphics.g3d.attributes.ColorAttribute;
import com.badlogic.gdx.graphics.g3d.environment.DirectionalLight;
import com.badlogic.gdx.graphics.g3d.model.Node;
import com.badlogic.gdx.graphics.g3d.Material;
import com.badlogic.gdx.graphics.g3d.utils.CameraInputController;
import com.badlogic.gdx.graphics.g3d.utils.ModelBuilder;
import com.badlogic.gdx.utils.Array;


class Game implements ApplicationListener {
    private Environment environment;
    private PerspectiveCamera cam;
    private ModelBatch modelBatch;
    private AssetManager assets;
    private Array<ModelInstance> instances = new Array<ModelInstance>();
    private CameraInputController camController;
    private boolean loading;

    private void createCamera() {
        cam = new PerspectiveCamera(67, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        cam.position.set(0, 10f, 10f);
        cam.lookAt(0,5f,0);
        cam.near = 1f;
        cam.far = 300f;
        cam.update();

        // camController = new CameraInputController(cam);
        // Gdx.input.setInputProcessor(camController);
    }

    private void createLight() {
        environment.set(new ColorAttribute(ColorAttribute.AmbientLight, 0.4f, 0.4f, 0.4f, 1f));
        environment.add(new DirectionalLight().set(0.8f, 0.8f, 0.8f, -1f, -0.8f, -0.2f));
    }

    private void loadAsset() {
        assets.load("butt.g3dj", Model.class);
        loading = true;
    }

    private void doneLoaing() {
        Model katModel = assets.get("butt.g3dj", Model.class);
        ModelInstance katInstance = new ModelInstance(katModel); 
        instances.add(katInstance);
        loading = false;
        
        // Node node = katInstance.getNode("rdmobj04");

        // katInstance.transform.set(node.globalTransform);
        // node.translation.set(5f,0,0);
        // // node.scale.set(1,1,1);
        // // node.rotation.idt();
        // katInstance.calculateTransforms();
    }

    @Override
    public void create() {
        environment = new Environment();
        modelBatch = new ModelBatch();
        assets = new AssetManager();

        createLight();
        createCamera();
        loadAsset();
    }

    @Override
    public void render() {
        if(loading && assets.update())
            doneLoaing();

        // camController.update();
        
        Gdx.gl.glViewport(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);

        modelBatch.begin(cam);
        modelBatch.render(instances, environment);
        modelBatch.end();
    }

    public void dispose() {
        modelBatch.dispose();
        instances.clear();
        assets.dispose();
    }
    
    @Override
    public void resize(int width, int height) {
    }

    @Override
    public void pause() {
    }

    @Override
    public void resume() {
    }
}

public class Main extends AndroidApplication {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        AndroidApplicationConfiguration cfg = new AndroidApplicationConfiguration();
        cfg.useAccelerometer = false;
        cfg.useCompass = false;

        initialize(new Game(), cfg);
    }
}