package com.quzzar.dominions.Misc;

import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.math.Vector3;
import com.quzzar.dominions.Game.Location;

public class WorldUtils {

    /// CONSTANTS ///
    private static final int worldWidth = 100;
    private static final int worldHeight = 100;

    private static final float squareSize = 20;
    ///

    public static Vector3 getWorldCoordsFromInput(Camera camera, float inputX, float inputY){
        Vector3 tempLoc = new Vector3();
        tempLoc.set(inputX, inputY, 0);
        camera.unproject(tempLoc);
        return tempLoc;
    }

    public static Location getLocationFromInput(Camera camera, float inputX, float inputY){
        Vector3 tempLoc = getWorldCoordsFromInput(camera, inputX, inputY);
        return getLocation(tempLoc.x, tempLoc.y);
    }

    public static Vector3 getWorldCoords(int squareX, int squareY){
        Vector3 tempLoc = new Vector3();
        tempLoc.set(squareX*squareSize, squareY*squareSize, 0);
        return tempLoc;
    }

    public static Vector3 getWorldCoords(Location location){
        return getWorldCoords(location.getX(), location.getY());
    }

    public static Location getLocation(float worldX, float worldY){
        Location tempLocSq = new Location();
        tempLocSq.set((int)(worldX/squareSize), (int)(worldY/squareSize));
        return tempLocSq;
    }

    public static float getWorldPixelWidth(){
        return worldWidth*squareSize;
    }

    public static float getWorldPixelHeight(){
        return worldHeight*squareSize;
    }

    public static float getWorldWidth(){
        return worldWidth;
    }

    public static float getWorldHeight(){
        return worldHeight;
    }

    public static float getSquareSize() {
        return squareSize;
    }

    /*
    public static Vector3 inputCoordsToScreenCoords(Camera camera, float x, float y){
        return new Vector3(x,camera.viewportHeight - y, 0);
    }

    public static Vector3 screenCoordsToWorldCoords(Camera camera, float x, float y){
        return inputCoordsToWorldCoords(camera, x, camera.viewportHeight - y);
    }
    */


}
