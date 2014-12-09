private boolean loading;

if(loading && assets.update()) {
    doneLoaing();
}

if(loading) {
    return;
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

    nodeLeftInitialPosition = leftButtNode.translation.cpy();
    nodeRightInitialPosition = rightButtNode.translation.cpy();
}