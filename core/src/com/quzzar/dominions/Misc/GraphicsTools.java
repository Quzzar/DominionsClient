package com.quzzar.dominions.Misc;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;

public class GraphicsTools {

    public static int getScreenWidth(){
        return Gdx.graphics.getWidth();
    }

    public static int getScreenHeight(){
        return Gdx.graphics.getHeight();
    }


    public static void scaleSprite(Sprite sprite, float amount){
        sprite.setSize(sprite.getWidth()*amount, sprite.getHeight()*amount);
    }


    public static void drawRectangle(ShapeRenderer shapeRenderer, Rectangle rectangle){
        shapeRenderer.rect(rectangle.x, rectangle.y, rectangle.width, rectangle.height);
    }

    public static void drawCircle(ShapeRenderer shapeRenderer, float x, float y, int radius){
        shapeRenderer.circle(x, y, radius);
    }


    public static boolean pointInsideRectangle(Rectangle rectangle, float Px, float Py){

        float minX = Math.min(rectangle.x, rectangle.x + rectangle.width);
        float maxX = Math.max(rectangle.x, rectangle.x + rectangle.width);
        float minY = Math.min(rectangle.y, rectangle.y + rectangle.height);
        float maxY = Math.max(rectangle.y, rectangle.y + rectangle.height);

        return minX <= Px && Px <= maxX &&
                minY <= Py && Py <= maxY;
    }








}
