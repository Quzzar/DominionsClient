package com.quzzar.dominions.UI.TouchListeners;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.math.Vector3;
import com.quzzar.dominions.Game.WorldRenderer;

public class GameDesktopListener implements InputProcessor {

    private static Vector3 convertCoords = new Vector3();

    private static Camera gameCamera = WorldRenderer.getGameCamera().getCamera();

    public static void checkKeyPressed(){

        float zoomSpeed = 100 * WorldRenderer.getGameCamera().getZoom();

        if(Gdx.input.isKeyPressed(Input.Keys.DPAD_LEFT) || Gdx.input.isKeyPressed(Input.Keys.A)){
            gameCamera.position.x -= Gdx.graphics.getDeltaTime() * zoomSpeed;
        }
        if(Gdx.input.isKeyPressed(Input.Keys.DPAD_LEFT) || Gdx.input.isKeyPressed(Input.Keys.A)){
            gameCamera.position.x -= Gdx.graphics.getDeltaTime() * zoomSpeed;
        }
        if(Gdx.input.isKeyPressed(Input.Keys.DPAD_RIGHT) || Gdx.input.isKeyPressed(Input.Keys.D)){
            gameCamera.position.x += Gdx.graphics.getDeltaTime() * zoomSpeed;
        }
        if(Gdx.input.isKeyPressed(Input.Keys.DPAD_UP) || Gdx.input.isKeyPressed(Input.Keys.W)){
            gameCamera.position.y += Gdx.graphics.getDeltaTime() * zoomSpeed;
        }
        if(Gdx.input.isKeyPressed(Input.Keys.DPAD_DOWN) || Gdx.input.isKeyPressed(Input.Keys.S)){
            gameCamera.position.y -= Gdx.graphics.getDeltaTime() * zoomSpeed;
        }

    }

    @Override
    public boolean keyDown(int keycode) {
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {

        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {

        WorldRenderer.getGameCamera().setZoom(WorldRenderer.getGameCamera().getZoom()+0.1f*amount/Math.abs(amount));

        return true;
    }
}
