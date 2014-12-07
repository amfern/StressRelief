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
import com.badlogic.gdx.math.Vector3;


class Game implements ApplicationListener {
    private Environment environment;
    private PerspectiveCamera cam;
    private ModelBatch modelBatch;
    private AssetManager assets;
    private Array<ModelInstance> instances = new Array<ModelInstance>();
    private CameraInputController camController;
    private boolean loading;
    private Node leftButtNode;
    private Node rightButtNode;

    private void createCamera() {
        cam = new PerspectiveCamera(67, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        cam.position.set(0, 10f, 10f);
        cam.lookAt(0,5f,0);
        cam.near = 1f;
        cam.far = 300f;
        cam.update();
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
        Model buttModel = assets.get("butt.g3dj", Model.class);
        ModelInstance buttInstance = new ModelInstance(buttModel); 
        instances.add(buttInstance);
        loading = false;
        
        leftButtNode = buttInstance.getNode("leftButt");
        rightButtNode = buttInstance.getNode("rightButt");
    }

    private void moveNode(Node node, int deltaX, int deltaY) {
        node.translation.x += deltaX * 0.001f;
        node.translation.y += -deltaY * 0.001f;
    }

    private void moveClosestNode(int deltaX, int deltaY, int screenX, int screenY) {
        Vector3 globaLeftButtlPosition = new Vector3();
        Vector3 globaRightButtlPosition = new Vector3();

        // unproject world coordinates to screen
        leftButtNode.globalTransform.getTranslation(globaLeftButtlPosition);
        rightButtNode.globalTransform.getTranslation(globaRightButtlPosition);

        Vector3 leftButtScreenCoords = cam.project(globaLeftButtlPosition);
        Vector3 rightButtScreenCoords = cam.project(globaRightButtlPosition);
        
        // find closes screen coordinate
        Vector3 screenCoord = new Vector3(screenX, screenY, 0);
        float leftButtNodeDst = leftButtScreenCoords.dst2(screenCoord);
        float rightButtNodeDst = rightButtScreenCoords.dst2(screenCoord);

        // move the related node
        if(leftButtNodeDst > rightButtNodeDst) {
            moveNode(rightButtNode, deltaX, deltaY);
        } else {
            moveNode(leftButtNode, deltaX, deltaY);
        }
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

        if(Gdx.input.isTouched(0)) {
            int deltaX = Gdx.input.getDeltaX();
            int deltaY = Gdx.input.getDeltaY();
            int screenX = Gdx.input.getX();
            int screenY = Gdx.input.getY();

            moveClosestNode(deltaX, deltaY, screenX, screenY);
        }


        for(int i = 0; i < instances.size; i++) {
            instances.get(i).calculateTransforms();
        }

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