package com.quzzar.dominions.Game.Terrain;

import com.badlogic.gdx.graphics.Texture;
import com.quzzar.dominions.Game.Enums.ObstacleType;
import com.quzzar.dominions.Game.Location;
import com.quzzar.dominions.Game.Obstacle;
import com.quzzar.dominions.Game.WorldManager;

import java.util.ArrayList;
import java.util.Random;

public class Generating extends Obstacle {

    private double spawnRate;
    private Random rand;

    public Generating(Texture texture, int squareX, int squareY, ObstacleType obstacleType, double spawnRate) {
        super(texture, squareX, squareY, obstacleType);
        this.rand = new Random();
        this.spawnRate = spawnRate;
    }

    public Generating(Texture texture, int squareX, int squareY, ObstacleType obstacleType) {
        super(texture, squareX, squareY, obstacleType);
        this.rand = new Random();
        this.spawnRate = rand.nextDouble();
    }


    public Generating(Texture texture, float x, float y, ObstacleType obstacleType, double spawnRate) {
        super(texture, x, y, obstacleType);
        this.rand = new Random();
        this.spawnRate = spawnRate;
    }

    public Generating(Texture texture, float x, float y, ObstacleType obstacleType) {
        super(texture, x, y, obstacleType);
        this.rand = new Random();
        this.spawnRate = rand.nextDouble();
    }

    public double getSpawnRate() {
        return spawnRate;
    }

    public void iterate(){

        /*
        double testDouble = rand.nextDouble();
        if (testDouble < spawnRate){

            int sideNum = rand.nextInt(4)-1;
            if (getOpenSides().get(sideNum)){

                WorldManager.addWorldObject(new Generating(this.getSprite().getTexture(),
                        getLocation().getX(), getLocation().getY(), getObstacleType(), spawnRate));

            }

        }
        */

    }

    private ArrayList<Integer> getOpenSides(){
        ArrayList<Integer> openSides = new ArrayList<Integer>();

        /*
        Location location = this.getLocation();
        location.set(location.getX(), location.getY()+1);
        if (WorldManager.containsObject(location)){
            openSides.add(0, -1);
        }

        location = this.getLocation();
        location.set(location.getX(), location.getY()-1);
        openSides.add(1, !WorldManager.containsObject(location));

        location = this.getLocation();
        location.set(location.getX()+1, location.getY());
        openSides.add(2, !WorldManager.containsObject(location));

        location = this.getLocation();
        location.set(location.getX()-1, location.getY());
        openSides.add(3, !WorldManager.containsObject(location));

        */
        return openSides;
    }


}
