package com.amfern.stressrelief;

import com.badlogic.gdx.utils.Array;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.graphics.g3d.ModelBatch;
import com.badlogic.gdx.graphics.g3d.Environment;
import com.badlogic.gdx.graphics.g3d.attributes.ColorAttribute;
import com.badlogic.gdx.graphics.g3d.environment.BaseLight;
import com.badlogic.gdx.graphics.g3d.environment.DirectionalLight;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.PerspectiveCamera;
import com.badlogic.gdx.math.Vector3;

public class Scene {
    private Texture background;
    private ModelBatch batch;
    private SpriteBatch spriteBatch;
    private Environment env;
    private Camera cam;
    private BaseLight light;

    // constructor
    public Scene() {
        batch = new ModelBatch();
        spriteBatch = new SpriteBatch();
        env = new Environment();
        cam = createCamera();
        light = createLight();

        setEnviroment(env, light);
    }

    private Camera createCamera() {
        PerspectiveCamera cam = new PerspectiveCamera(62.53f, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        cam.position.set(0.01741587301f, 0.0678f, 4.11821587302f);
        // cam.rotate(new Vector3(0, 0 ,1f), 90f);
        // cam.lookAt(0, 0, 0);
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


    private void renderBackground(SpriteBatch spriteBatch, Texture background) {
        spriteBatch.begin();
        spriteBatch.draw(background, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        spriteBatch.end();
    }

    private void renderInstances(ModelBatch batch, Environment env, Camera cam, Array<ModelInstance> instances) {
        for(int i = 0; i < instances.size; i++) {
            batch.begin(cam);
            batch.render(instances, env);
            batch.end();
        }
    }

    public void clear() {
        Gdx.gl.glViewport(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);
    }

    public void renderBackground(Texture background) {
        renderBackground(spriteBatch, background);
    }

    public void renderInstances(Array<ModelInstance> instances) {
        renderInstances(batch, env, cam, instances);
    }

    public void dispose() {
        batch.dispose();
        spriteBatch.dispose();
    }

    public Camera getCamera() {
        return cam;
    }
}