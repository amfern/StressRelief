package com.amfern.stressrelief;

import android.util.Log;

import com.badlogic.gdx.graphics.g3d.Model;
import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.graphics.g3d.model.Node;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.collision.Ray;

public class AssInstance extends ModelInstance {
    private static final Vector3 BOUNDING_SPHERE_CENTER = new Vector3(0, 0, 0);
    private static final float BOUNDING_SPHERE_RADIUS = 6f;
    private Node leftChickNode;
    private Node rightChickNode;

    // private Vector3 nodeLeftInitialPosition;
    // private Vector3 nodeRightInitialPosition;

    // constructor
    public AssInstance(Model model) {
        super(model);

        leftChickNode = getNode("leftButt");
        rightChickNode = getNode("rightButt");

        // nodeLeftInitialPosition = leftButtNode.translation.cpy();
        // nodeRightInitialPosition = rightButtNode.translation.cpy();
    }

    // animations
    // ------------------------------------------------
    public void playIdle() {

    }

    public void playBounce() {
        Log.w("stressrelief", "playing animation: playBounce");
    }

    public void playLeftFlick() {
        Log.w("stressrelief", "playing animation: playLeftFlick");
    }

    public void playRightFlick() {
        Log.w("stressrelief", "playing animation: playRightFlick");
    }

    // updates the animations
    public void updateAnimations() {

    }
    
    public boolean intersectRayAss(Ray ray, Vector3 intersection) {
        Vector3 offsetCenter = BOUNDING_SPHERE_CENTER.cpy().mul(transform);
        return Intersector.intersectRaySphere(ray, offsetCenter, BOUNDING_SPHERE_RADIUS, intersection);
    }

    public Node getLeftChick() {
        return leftChickNode;
    }

    public Node getRightChick() {
        return rightChickNode;
    }
}