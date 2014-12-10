package com.amfern.stressrelief;

import com.badlogic.gdx.utils.Array;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.graphics.g3d.ModelBatch;
import com.badlogic.gdx.graphics.g3d.Environment;
import com.badlogic.gdx.graphics.g3d.attributes.ColorAttribute;
import com.badlogic.gdx.graphics.g3d.environment.BaseLight;
import com.badlogic.gdx.graphics.g3d.environment.DirectionalLight;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.PerspectiveCamera;

public class GameScreen extends ScreenAdapter {
    private Array<ModelInstance> instances;
    private ModelBatch batch;
    private Environment env;
    private Camera cam;
    private BaseLight light;

    // constructor
    public GameScreen(ModelInstance[] instances) {
        super();

        this.instances = new Array<ModelInstance>(instances);

        batch = new ModelBatch();
        env = new Environment();
        cam = createCamera();
        light = createLight();

        setEnviroment(env, light);
    }

    private Camera createCamera() {
        PerspectiveCamera cam = new PerspectiveCamera(67, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        cam.position.set(0, 10f, 10f);
        cam.lookAt(0,5f,0);
        cam.near = 1f;
        cam.far = 300f;
        cam.update();

        return cam;
    }

    private BaseLight createLight() {
        return new DirectionalLight()
                    .set(0.8f, 0.8f, 0.8f, -1f, -0.8f, -0.2f);
    }
    
    private void setEnviroment(Environment env, BaseLight light) {
        env.set(new ColorAttribute(ColorAttribute.AmbientLight, 0.4f, 0.4f, 0.4f, 1f));
        env.add(light);
    }

    private void clearScene() {
        Gdx.gl.glViewport(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);
    }

    private void renderInstances(ModelBatch batch, Environment env, Camera cam, Array<ModelInstance> instances) {
        for(int i = 0; i < instances.size; i++) {
            batch.begin(cam);
            batch.render(instances, env);
            batch.end();
        }
    }

    @Override
    public void render(float delta) {
        clearScene();
        renderInstances(batch, env, cam, instances);
    }

    @Override
    public void dispose() {
        batch.dispose();;
    }
}