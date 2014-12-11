package com.amfern.stressrelief;

import com.badlogic.gdx.input.GestureDetector;
import com.badlogic.gdx.input.GestureDetector.GestureAdapter;
import com.badlogic.gdx.Gdx;

// import com.badlogic.gdx.math.Vector3;
// import com.badlogic.gdx.math.Interpolation;
// import com.badlogic.gdx.math.Interpolation.Elastic;
// import com.badlogic.gdx.input;


enum AssChick {
    LEFT,
    RIGHT
}

public class AssController extends GestureAdapter {
    AssInstance assInstance;

    public AssController(AssInstance assInstance) {
        this.assInstance = assInstance;
        Gdx.input.setInputProcessor( new GestureDetector(this) );
    }

    private AssChick getClosestdChick(float x, float y, AssInstance assInstance) {
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
        // 
        return AssChick.LEFT;
    }

    // checks if the touch occured on mesh
    private boolean isTouchedMesh(float x, float y, AssInstance assInstance) {
        return true;
    }

    @Override
    public boolean tap(float x, float y, int count, int button) {
        if(!isTouchedMesh(x, y, assInstance))
            return false;

        switch( getClosestdChick(x, y, assInstance) ) {
            case LEFT:
                assInstance.playLeftFlick();
                break;
            case RIGHT:
                assInstance.playRightFlick();
                break;
        }
        
        return true;
    }

    @Override
    public boolean fling(float velocityX, float velocityY, int button) {
        // play bouse animation only on up fling and on mesh touch
        if(!isTouchedMesh(velocityX, velocityY, assInstance) || velocityY > 0)
            return false;

        assInstance.playBounce();
        return true;
    }
}










    
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
