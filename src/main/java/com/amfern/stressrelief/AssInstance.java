package com.amfern.stressrelief;

import android.util.Log;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g3d.Model;
import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.graphics.g3d.model.Node;
import com.badlogic.gdx.graphics.g3d.model.Animation;
import com.badlogic.gdx.graphics.g3d.utils.AnimationController;
import com.badlogic.gdx.graphics.g3d.utils.AnimationController.AnimationDesc;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.collision.Ray;
import com.badlogic.gdx.utils.Array;

public class AssInstance extends ModelInstance implements AnimationController.AnimationListener {
    private static final Vector3 BOUNDING_SPHERE_CENTER = new Vector3(0, 3f, 0);
    private static final float BOUNDING_SPHERE_RADIUS = 6f;
    private static final String IDLE_ANIMATION = "idle";
    private static final String BOUNCE_ANIMATION = "bounce";
    private static final String LEFT_FLICK_ANIMATION = "left_flick";
    private static final String RIGHT_FLICK_ANIMATION = "right_flick";
    private static final String LEFT_NODE_ID = "leftButt";
    private static final String RIGHT_NODE_ID = "rightButt";
    private static final float TRANSITION_TIME = 1f;
    
    private Node leftChickNode;
    private Node rightChickNode;
    private AnimationController animController;

    // private Vector3 nodeLeftInitialPosition;
    // private Vector3 nodeRightInitialPosition;

    // constructor
    public AssInstance(Model model) throws Exception {
        super(model);

        validateModel(model);

        leftChickNode = getNode(LEFT_NODE_ID);
        rightChickNode = getNode(RIGHT_NODE_ID);

        animController = new AnimationController(this);
        animController.setAnimation(IDLE_ANIMATION, -1);

        // nodeLeftInitialPosition = leftButtNode.translation.cpy();
        // nodeRightInitialPosition = rightButtNode.translation.cpy();
    }

    private Array<String> collectNodeIds(Array<Node> nodes) {
        Array<String> ids = new Array<String>();
        for(Node node:nodes) {
            ids.add(node.id);
        }
        return ids;
    }

    private Array<String> collectAnimationIds(Array<Animation> animations) {
        Array<String> ids = new Array<String>();
        for(Animation animation:animations) {
            ids.add(animation.id);
        }
        Log.w("stressrelief", "Animations: " +ids);
        return ids;
    }


    private void validateNodes(Array<Node> nodes) throws Exception {
        String[] expectedIds = new String[] {
            LEFT_NODE_ID,
            RIGHT_NODE_ID
        };

        Array<String> nodeIds = collectNodeIds(nodes);
        for(String expectedID:expectedIds) {
            if(!nodeIds.contains(expectedID, false)) {
                throw new Exception("missing node: " + expectedID);
            }
        }
    }

    private void validateAnimations(Array<Animation> animations) throws Exception {
        String[] expectedIds = new String[] {
            IDLE_ANIMATION,
            BOUNCE_ANIMATION,
            LEFT_FLICK_ANIMATION,
            RIGHT_FLICK_ANIMATION
        };

        Array<String> animationIds = collectAnimationIds(animations);
        for(String expectedID:expectedIds) {
            if(!animationIds.contains(expectedID, false)) {
                throw new Exception("missing animation: " + expectedID);
            }
        }
    }

    private void validateModel(Model model) throws Exception {
        validateNodes(model.nodes);
        validateAnimations(model.animations);
    }

    @Override
    public void onEnd(AnimationDesc animation) {

    }

    @Override
    public void onLoop(AnimationDesc animation) {

    }

    // animations
    // ------------------------------------------------
    public void playBounce() {
        animController.action(BOUNCE_ANIMATION, 1, 1f, this, TRANSITION_TIME);
        Log.w("stressrelief", "playing animation: playBounce");
    }

    public void playLeftFlick() {
        animController.action(LEFT_FLICK_ANIMATION, 1, 1f, this, TRANSITION_TIME);
        Log.w("stressrelief", "playing animation: playLeftFlick");
    }

    public void playRightFlick() {
        animController.action(RIGHT_FLICK_ANIMATION, 1, 1f, this, TRANSITION_TIME);
        Log.w("stressrelief", "playing animation: playRightFlick");
    }

    // updates the animations
    public void updateAnimations() {
        animController.update(Gdx.graphics.getDeltaTime());
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