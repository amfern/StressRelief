class Scene implements ApplicationListener {
    private ModelBatch modelBatch;

    public Scene() {
        modelBatch = new ModelBatch();
    }

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

    private void clearScene() {
        Gdx.gl.glViewport(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);
    }

    private void renderInstances(instances) {
        for(int i = 0; i < instances.size; i++) {
            modelBatch.begin(cam);
            modelBatch.render(instances, environment);
            modelBatch.end();
        }
    }

    public void renderInstances(Array<ModelInstance> instances) {

    }


    public void dispose() {
        modelBatch.dispose();
        instances.clear();
        assets.dispose();
    }
}