package com.quzzar.dominions.UI.TouchListeners;

import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.input.GestureDetector;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.quzzar.dominions.Misc.WorldUtils;
import com.quzzar.dominions.Game.WorldRenderer;

public class GameAndroidListener implements GestureDetector.GestureListener {

    private static Vector3 convertCoords = new Vector3();

    private static Camera gameCamera = WorldRenderer.getGameCamera().getCamera();

    private float currentZoom = WorldRenderer.getGameCamera().getZoom();

    @Override
    public boolean touchDown(float screenX, float screenY, int pointer, int button) {

        return false;
    }

    @Override
    public boolean tap(float screenX, float screenY, int count, int button) {
        return false;
    }

    @Override
    public boolean longPress(float screenX, float screenY) {

        return false;
    }

    @Override
    public boolean fling(float velocityX, float velocityY, int button) {
        return false;
    }

    @Override
    public boolean pan(float screenX, float screenY, float deltaX, float deltaY) {

        convertCoords = WorldUtils.getWorldCoordsFromInput(gameCamera, screenX, screenY);

        WorldRenderer.getGameCamera().translate(-deltaX*currentZoom*0.1f, deltaY*currentZoom*0.1f);

        return false;
    }

    @Override
    public boolean panStop(float screenX, float screenY, int pointer, int button) {

        currentZoom = WorldRenderer.getGameCamera().getZoom();

        return false;
    }

    @Override
    public boolean zoom(float initialDistance, float distance) {

        WorldRenderer.getGameCamera().setZoom((initialDistance / distance) * currentZoom);

        return true;
    }

    @Override
    public boolean pinch(Vector2 initialPointer1, Vector2 initialPointer2, Vector2 pointer1, Vector2 pointer2) {
        return false;
    }

    @Override
    public void pinchStop() {

    }
}
