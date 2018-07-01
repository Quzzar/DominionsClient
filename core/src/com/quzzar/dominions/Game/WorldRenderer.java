package com.quzzar.dominions.Game;

import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import com.quzzar.dominions.Cameras.GameCamera;
import com.quzzar.dominions.Game.Terrain.Generating;
import com.quzzar.dominions.Game.Terrain.Generation.Trees.Tree;
import com.quzzar.dominions.Game.WorldManager;
import com.quzzar.dominions.Misc.Utility;

public class WorldRenderer {

    private static GameCamera gameCamera;

    public static int objectCount = 0;

    public static void initialize(){



        gameCamera = new GameCamera(100);

        WorldManager.initialize();

        WorldManager.addWorldObject(new Tree(20, 50));

    }


    public static void render(SpriteBatch batch, ShapeRenderer renderer){

        gameCamera.update();

        batch.begin();

        int count = 0;

        for (Generating worldObject : WorldManager.getWorldObjects()) {

            if(getGameCamera().containsPointInBounds(worldObject.getWorldX(), worldObject.getWorldY(), 80)){
                worldObject.draw(batch);
                count++;
            }

        }

        objectCount = count;

        batch.end();

        Utility.print("GAME-INFO","Objects Rendered: "+objectCount);

    }

    public static GameCamera getGameCamera() {
        return gameCamera;
    }

    public static Camera getCamera(){
        return gameCamera.getCamera();
    }

}
