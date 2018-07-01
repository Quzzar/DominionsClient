package com.quzzar.dominions.Cameras;

import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.quzzar.dominions.Game.Terrain.Generation.Trees.Tree;
import com.quzzar.dominions.Game.WorldManager;
import com.quzzar.dominions.Misc.WorldUtils;

public class GameCamera {

    private OrthographicCamera camera;

    private Viewport viewport;

    private float viewportSize;

    public GameCamera(float viewportSize){

        camera = new OrthographicCamera();
        viewport = new StretchViewport(viewportSize,viewportSize,camera);
        viewport.apply();

        camera.position.set(camera.viewportWidth/2,camera.viewportHeight/2,0);

        this.viewportSize = viewportSize;

    }


    public void update(){

        float maxZoom = Math.min(WorldUtils.getWorldPixelWidth(), WorldUtils.getWorldPixelHeight())/viewportSize;

        if (camera.zoom > maxZoom){
            camera.zoom = maxZoom;
        } else if (camera.zoom < 0.1f){
            camera.zoom = 0.1f;
        }

        Vector2 camMin = new Vector2(camera.viewportWidth, camera.viewportHeight);
        camMin.scl(camera.zoom/2); //bring to center and scale by the zoom level
        Vector2 camMax = new Vector2(WorldUtils.getWorldPixelWidth(), WorldUtils.getWorldPixelHeight());
        camMax.sub(camMin); //bring to center

        //keep camera within borders
        camera.position.x = Math.min(camMax.x, Math.max(camera.position.x, camMin.x));
        camera.position.y = Math.min(camMax.y, Math.max(camera.position.y, camMin.y));


        camera.update();

    }

    public void setPosition(Vector2 location){
        camera.position.set(location, 0);
    }

    public void setPosition(float x, float y){
        camera.position.set(x, y, 0);
    }

    public void translate(Vector2 location){
        camera.translate(location);
    }

    public void translate(float x, float y){
        camera.translate(x, y);
    }

    public void setZoom(float zoom){
        camera.zoom = zoom;
    }

    public float getZoom(){
        return camera.zoom;
    }

    public void resize(int width, int height){
        viewport.update(width,height);
        camera.position.set(camera.viewportWidth/2,camera.viewportHeight/2,0);
    }

    public Camera getCamera() {
        return camera;
    }

    public Viewport getViewport() {
        return viewport;
    }

    public Vector3 centerPosition(){
        return camera.position;
    }

    public boolean containsPointInBounds(float x, float y, float overlap){

        Vector2 cam = new Vector2(camera.viewportWidth, camera.viewportHeight);
        cam.scl(getZoom()/2);

        float pointBx = centerPosition().x+cam.x + overlap;
        float pointBy = centerPosition().y+cam.y + overlap;

        float pointAx = centerPosition().x-cam.x - overlap;
        float pointAy = centerPosition().y-cam.y - overlap;

        return pointAx <= x && x <= pointBx &&
                pointAy <= y && y <= pointBy;
    }


}
