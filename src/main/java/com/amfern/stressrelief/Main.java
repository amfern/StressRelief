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
import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.math.Interpolation.Elastic;


class Game implements ApplicationListener {
    private AssCharacter assChar;
    private Scene scene;
    // private Environment environment;
    // private PerspectiveCamera cam;
    
    // private AssetManager assets;
    // private CameraInputController camController;
    
    // private Node leftButtNode;
    // private Node rightButtNode;

    // private Vector3 nodeLeftInitialPosition;
    // private Vector3 nodeRightInitialPosition;



    @Override
    public void create() {
        // environment = new Environment();
        
        // assets = new AssetManager();

        // createLight();
        // createCamera();
        // loadAsset();
    }

    @Override
    public void render() {

        assChar.updateAnimations();


        Array<ModelIntances> instances = new Array<ModelIntances>({
            assChar.getModelInstance()
        })

        scene.renderInstances(instances);

        // if(Gdx.input.isTouched(0)) {
        //     int deltaX = Gdx.input.getDeltaX();
        //     int deltaY = Gdx.input.getDeltaY();
        //     int screenX = Gdx.input.getX();
        //     int screenY = Gdx.input.getY();

        //     moveClosestNode(deltaX, deltaY, screenX, screenY);
        // } else {
        //     interpolateElasticAssNode(leftButtNode, nodeLeftInitialPosition);
        //     interpolateElasticAssNode(rightButtNode, nodeRightInitialPosition);
        // }
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

        // Loader loads all the AssChareacters and populates modelInstances array
        initialize(new Loader(), cfg);
        initialize(new (), cfg);
        initialize(new Game(), cfg);
    }
}