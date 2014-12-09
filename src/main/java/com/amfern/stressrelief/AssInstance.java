package com.amfern.stressrelief;

import android.util.Log;

import com.badlogic.gdx.graphics.g3d.Model;
import com.badlogic.gdx.graphics.g3d.ModelInstance;

public class AssInstance extends ModelInstance {
    // private Node leftButtNode;
    // private Node rightButtNode;

    // private Vector3 nodeLeftInitialPosition;
    // private Vector3 nodeRightInitialPosition;

    // constructor
    public AssInstance(Model model) {
        super(model);

        // leftButtNode = buttInstance.getNode("leftButt");
        // rightButtNode = buttInstance.getNode("rightButt");

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
}