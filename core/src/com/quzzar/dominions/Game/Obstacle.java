package com.quzzar.dominions.Game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.quzzar.dominions.Game.Enums.ObstacleType;
import com.quzzar.dominions.Misc.GraphicsTools;
import com.quzzar.dominions.Misc.WorldUtils;

public class Obstacle{

    private Sprite sprite;
    private ObstacleType obstacleType;

    public Obstacle(Texture texture, int squareX, int squareY, ObstacleType obstacleType){
        this.sprite = new Sprite(texture);
        this.setLocation(squareX, squareY);
        getSprite().setSize(30, 30);

        this.obstacleType = obstacleType;
    }

    public Obstacle(Texture texture, float x, float y, ObstacleType obstacleType){
        this.sprite = new Sprite(texture);
        this.getSprite().setPosition(x, y);
        getSprite().setSize(30, 30);

        this.obstacleType = obstacleType;
    }

    public Sprite getSprite() {
        return sprite;
    }

    public ObstacleType getObstacleType() {
        return obstacleType;
    }

    public Location getLocation(){
        return WorldUtils.getLocation(this.getSprite().getX(), this.getSprite().getY());
    }

    public float getWorldX(){
        return sprite.getX()+sprite.getWidth()/2f;
    }

    public float getWorldY(){
        return sprite.getY()+sprite.getHeight()/2f;
    }

    public void setLocation(int squareX, int squareY){
        Vector3 coords = WorldUtils.getWorldCoords(squareX, squareY);
        this.getSprite().setPosition(coords.x, coords.y);
    }

    public void update(){

    }

    public void draw(SpriteBatch batch){

        //float oldX = getSprite().getX();
        //float oldY = getSprite().getY();

        //getSprite().setPosition(oldX-getSprite().getWidth()/2f, oldY-getSprite().getHeight()/2f);

        getSprite().draw(batch);

        //getSprite().setPosition(oldX, oldY);

    }

    public void dispose(){
        sprite.getTexture().dispose();
    }

}
