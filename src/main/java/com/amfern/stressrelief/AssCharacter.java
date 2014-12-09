package com.amfern.stressrelief;

import com.badlogic.gdx.graphics.g3d.Model;
import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.input;

public class AssCharacter extends ModelInstance implements GestureListener, ApplicationListener {

    // constructor
    public AssCharacter(Model model) {
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

    // instances.get(i).calculateTransforms();

    // private Vector3 interpolatePositions(Vector3 initialPos, Vector3 curretPos) {
    //     return curretPos.interpolate(initialPos, 0.5f, Interpolation.elastic);
    // }

    // private void interpolateElasticAssNode(Node node, Vector3 initialPos) {
    //     node.translation.set(node.translation.lerp(initialPos, 0.3f));
    // }

    // private void moveNode(Node node, int deltaX, int deltaY) {
    //     node.translation.x += deltaX * 0.001f;
    //     node.translation.y += -deltaY * 0.001f;
    // }

    // private void moveClosestNode(int deltaX, int deltaY, int screenX, int screenY) {
    //     Vector3 globaLeftButtlPosition = new Vector3();
    //     Vector3 globaRightButtlPosition = new Vector3();

    //     // unproject world coordinates to screen
    //     leftButtNode.globalTransform.getTranslation(globaLeftButtlPosition);
    //     rightButtNode.globalTransform.getTranslation(globaRightButtlPosition);

    //     Vector3 leftButtScreenCoords = cam.project(globaLeftButtlPosition);
    //     Vector3 rightButtScreenCoords = cam.project(globaRightButtlPosition);
        
    //     // find closes screen coordinate
    //     Vector3 screenCoord = new Vector3(screenX, screenY, 0);
    //     float leftButtNodeDst = leftButtScreenCoords.dst2(screenCoord);
    //     float rightButtNodeDst = rightButtScreenCoords.dst2(screenCoord);

    //     // move the related node
    //     if(leftButtNodeDst > rightButtNodeDst) {
    //         moveNode(rightButtNode, deltaX, deltaY);
    //     } else {
    //         moveNode(leftButtNode, deltaX, deltaY);
    //     }
    // }
}