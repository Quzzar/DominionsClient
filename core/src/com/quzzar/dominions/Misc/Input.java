package com.quzzar.dominions.Misc;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector3;

public class Input {

    public static Vector3 getWorldLocation(Camera camera){
        return WorldUtils.getWorldCoordsFromInput(camera, Gdx.input.getX(), Gdx.input.getY());
    }

    public static boolean isSpritePressed(Camera camera, Sprite sprite){
        if (Gdx.input.isTouched()) {

            Vector3 location = getWorldLocation(camera);

            if (sprite.getBoundingRectangle().contains(location.x,location.y)) {
                return true;
            }

        }
        return false;
    }

}
