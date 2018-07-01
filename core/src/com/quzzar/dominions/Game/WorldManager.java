package com.quzzar.dominions.Game;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.quzzar.dominions.Game.Location;
import com.quzzar.dominions.Game.Terrain.Generating;
import com.quzzar.dominions.Game.Terrain.Generation.Lakes.LakeTypes;
import com.quzzar.dominions.Game.Terrain.Generation.Mountains.Mountain;
import com.quzzar.dominions.Game.Terrain.Generation.Mountains.MountainTypes;
import com.quzzar.dominions.Game.Terrain.Generation.Trees.TreeTypes;
import com.quzzar.dominions.Misc.WorldUtils;

import java.util.ArrayList;
import java.util.Random;

public class WorldManager {

    private static ArrayList<Generating> worldObjects;

    public static void initialize(){
        worldObjects = new ArrayList<Generating>();


        Random rand = new Random();

        // Create Mountain Points
        for (int x = 0; x < WorldUtils.getWorldWidth(); x++) {
            for (int y = 0; y < WorldUtils.getWorldHeight(); y++) {
                int r = rand.nextInt(100);
                if(r == 1){
                    addWorldObject(new Mountain(x, y));
                }
            }
        }

    }

    public static void addWorldObject(Generating worldObject){
        worldObjects.add(worldObject);
    }

    public static void removeWorldObject(Generating worldObject){
        worldObjects.remove(worldObject);
    }

    public static boolean containsObject(Location location){
        for (Generating worldObject : worldObjects) {
            if(worldObject.getLocation().equals(location)){
                return true;
            }
        }
        return false;
    }

    public static ArrayList<Generating> getWorldObjects() {
        return worldObjects;
    }

    public static void dispose(){
        for (Generating worldObject : worldObjects) {
            worldObject.dispose();
        }

        for (LakeTypes type : LakeTypes.values()) {
            type.getTexture().dispose();
        }
        for (MountainTypes type : MountainTypes.values()) {
            type.getTexture().dispose();
        }
        for (TreeTypes type : TreeTypes.values()) {
            type.getTexture().dispose();
        }
    }

}
