package com.amfern.stressrelief;

import com.badlogic.gdx.graphics.g3d.Model;
import com.badlogic.gdx.graphics.g3d.ModelInstance;

public class AssInstance extends ModelInstance {

    // constructor
    public AssInstance(Model model) {
        super(model);
    }

    // animations
    // ------------------------------------------------
    public void playIdle() {

    }

    public void playBounce() {
        
    }

    public void playLeftFlick() {
        
    }

    public void playRightFlick() {
        
    }

    // updates the animations
    public void updateAnimations() {

    }
}























// import com.badlogic.gdx.graphics.Color;
// import com.badlogic.gdx.graphics.GL20;
// import com.badlogic.gdx.graphics.PerspectiveCamera;
// import com.badlogic.gdx.graphics.VertexAttributes.Usage;
// import com.badlogic.gdx.graphics.g3d.Environment;
// import com.badlogic.gdx.graphics.g3d.Model;
// import com.badlogic.gdx.graphics.g3d.ModelBatch;

// import com.badlogic.gdx.graphics.g3d.attributes.ColorAttribute;
// import com.badlogic.gdx.graphics.g3d.environment.DirectionalLight;
// import com.badlogic.gdx.graphics.g3d.model.Node;
// import com.badlogic.gdx.graphics.g3d.Material;
// import com.badlogic.gdx.graphics.g3d.utils.CameraInputController;
// import com.badlogic.gdx.graphics.g3d.utils.ModelBuilder;
// import com.badlogic.gdx.utils.Array;
// import com.badlogic.gdx.math.Vector3;
// import com.badlogic.gdx.math.Interpolation;
// import com.badlogic.gdx.math.Interpolation.Elastic;
// import com.badlogic.gdx.input;

// public class AssCharacter extends ModelInstance implements GestureListener {

//     // private Node leftButtNode;
//     // private Node rightButtNode;

//     // private Vector3 nodeLeftInitialPosition;
//     // private Vector3 nodeRightInitialPosition;




//     if(loading && assets.update()) {
//         doneLoaing();
//     }

//     if(loading) {
//         return;
//     }


//     private void loadAsset() {
//         assets.load("butt.g3dj", Model.class);
//         loading = true;
//     }

//     private void doneLoaing() {
//         Model buttModel = assets.get("butt.g3dj", Model.class);
//         ModelInstance buttInstance = new ModelInstance(buttModel); 
//         instances.add(buttInstance);
//         loading = false;
        
//         leftButtNode = buttInstance.getNode("leftButt");
//         rightButtNode = buttInstance.getNode("rightButt");

//         nodeLeftInitialPosition = leftButtNode.translation.cpy();
//         nodeRightInitialPosition = rightButtNode.translation.cpy();
//     }

//     public AssCharacter create() {

//     }











    
//     public void update() {
//         // if(Gdx.input.isTouched(0)) {
//         //     int deltaX = Gdx.input.getDeltaX();
//         //     int deltaY = Gdx.input.getDeltaY();
//         //     int screenX = Gdx.input.getX();
//         //     int screenY = Gdx.input.getY();

//         //     moveClosestNode(deltaX, deltaY, screenX, screenY);
//         // } else {
//         //     interpolateElasticAssNode(leftButtNode, nodeLeftInitialPosition);
//         //     interpolateElasticAssNode(rightButtNode, nodeRightInitialPosition);
//         // }
//     }

//     // instances.get(i).calculateTransforms();

//     // private Vector3 interpolatePositions(Vector3 initialPos, Vector3 curretPos) {
//     //     return curretPos.interpolate(initialPos, 0.5f, Interpolation.elastic);
//     // }

//     // private void interpolateElasticAssNode(Node node, Vector3 initialPos) {
//     //     node.translation.set(node.translation.lerp(initialPos, 0.3f));
//     // }

//     // private void moveNode(Node node, int deltaX, int deltaY) {
//     //     node.translation.x += deltaX * 0.001f;
//     //     node.translation.y += -deltaY * 0.001f;
//     // }

//     // private void moveClosestNode(int deltaX, int deltaY, int screenX, int screenY) {
//     //     Vector3 globaLeftButtlPosition = new Vector3();
//     //     Vector3 globaRightButtlPosition = new Vector3();

//     //     // unproject world coordinates to screen
//     //     leftButtNode.globalTransform.getTranslation(globaLeftButtlPosition);
//     //     rightButtNode.globalTransform.getTranslation(globaRightButtlPosition);

//     //     Vector3 leftButtScreenCoords = cam.project(globaLeftButtlPosition);
//     //     Vector3 rightButtScreenCoords = cam.project(globaRightButtlPosition);
        
//     //     // find closes screen coordinate
//     //     Vector3 screenCoord = new Vector3(screenX, screenY, 0);
//     //     float leftButtNodeDst = leftButtScreenCoords.dst2(screenCoord);
//     //     float rightButtNodeDst = rightButtScreenCoords.dst2(screenCoord);

//     //     // move the related node
//     //     if(leftButtNodeDst > rightButtNodeDst) {
//     //         moveNode(rightButtNode, deltaX, deltaY);
//     //     } else {
//     //         moveNode(leftButtNode, deltaX, deltaY);
//     //     }
//     // }
// }