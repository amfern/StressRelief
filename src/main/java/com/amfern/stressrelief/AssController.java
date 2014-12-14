package com.amfern.stressrelief;

import android.util.Log;

import com.badlogic.gdx.input.GestureDetector;
import com.badlogic.gdx.input.GestureDetector.GestureAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.g3d.model.Node;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.math.collision.Ray;


enum AssChick {
    LEFT,
    RIGHT
}

public class AssController extends GestureAdapter {
    boolean isTouched = false;
    boolean isBouncing = false;
    AssInstance assInstance;
    Camera cam;

    public AssController(AssInstance assInstance, Camera cam) {
        this.assInstance = assInstance;
        this.cam = cam;
        Gdx.input.setInputProcessor( new GestureDetector(this) );
    }

    private float dstPointNode(Vector3 point, Node node) {
        Vector3 nodePos = new Vector3();
        node.globalTransform.getTranslation(nodePos);

        return point.dst2(nodePos);
    }

    private AssChick getClosestdChick(Vector3 touchWorldCoord, AssInstance assInstance) {
        Node leftChick = assInstance.getLeftChick();
        Node rightChick = assInstance.getRightChick();
        float dstLeft = dstPointNode(touchWorldCoord, leftChick);
        float dstRight = dstPointNode(touchWorldCoord, rightChick);

        return dstLeft < dstRight ? AssChick.LEFT : AssChick.RIGHT;
    }
    
    // checks if the touch occured on mesh
    private boolean isTouchedAss(float x, float y, AssInstance assInstance) {
        Ray ray = cam.getPickRay(x, y);
        Vector3 intersection = new Vector3();

        return assInstance.intersectRayAss(ray, intersection);
    }

    @Override
    public boolean touchDown(float x, float y, int pointer, int button) {
        isTouched = isTouchedAss(x, y, assInstance);
        return false;
    }

    @Override
    public boolean tap(float x, float y, int count, int button) {
        if(!isTouched)
            return false;

        Vector3 touchWorldCoord = cam.unproject(new Vector3(x, y, 1f));

        switch( getClosestdChick(touchWorldCoord, assInstance) ) {
            case LEFT:
                assInstance.playLeftFlick();
                break;
            case RIGHT:
                assInstance.playRightFlick();
                break;
        }
        
        isTouched = false;
        return true;
    }

    @Override
    public boolean pan(float x, float y, float deltaX, float deltaY) {
        // play bouse animation only on up fling and on mesh touch
        if(!isTouched || deltaY > 0)
            return false;

        assInstance.playBounceStart();
        
        isTouched = false;
        isBouncing = true;
        return true;
    }

    @Override
    public boolean panStop(float x, float y, int pointer, int button) {
        // play bouse animation only on up fling and on mesh touch
        if(!isBouncing && !isTouched)
            return false;

        assInstance.playBounceEnd();
        
        isTouched = false;
        return true;
    }

    @Override
    public boolean fling(float velocityX, float velocityY, int button) {
        // play bouse animation only on up fling and on mesh touch
        if(!isBouncing && (!isTouched || velocityY > 0))
            return false;

        assInstance.playBounceEnd();
        
        isTouched = false;
        isBouncing = false;
        return true;
    }
}







// import com.badlogic.gdx.math.Interpolation;
// import com.badlogic.gdx.math.Interpolation.Elastic;
// import com.badlogic.gdx.input;

    

//         //     interpolateElasticAssNode(leftButtNode, nodeLeftInitialPosition);
//         //     interpolateElasticAssNode(rightButtNode, nodeRightInitialPosition);

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
