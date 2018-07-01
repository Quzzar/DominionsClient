package com.quzzar.dominions.Cameras;

import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class MenuCamera {

    private OrthographicCamera camera;

    private Viewport viewport;

    public MenuCamera(float width, float height){

        camera = new OrthographicCamera();
        viewport = new StretchViewport(width,height,camera);
        viewport.apply();


        camera.position.set(camera.viewportWidth/2,camera.viewportHeight/2,0);

    }


    public void update(){

        camera.update();

    }

    public void setPosition(Vector2 location){
        camera.translate(location);
    }

    public void setPosition(float x, float y){
        camera.translate(x, y);
    }

    public void setZoom(float zoom){
        camera.zoom = zoom;
    }

    public void resize(int width, int height){
        viewport.update(width,height);
        camera.position.set(camera.viewportWidth/2,camera.viewportHeight/2,0);
    }

    public float getWidth(){
        return camera.viewportWidth;
    }

    public float getHeight(){
        return camera.viewportHeight;
    }

    public Camera getCamera() {
        return camera;
    }

    public Viewport getViewport() {
        return viewport;
    }
}
