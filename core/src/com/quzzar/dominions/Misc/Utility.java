package com.quzzar.dominions.Misc;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Utility {

    public static void print(String tag, String message){
        Gdx.app.log(tag, message);
    }

    public static boolean isDesktopApp(){
        return Gdx.app.getType() == Application.ApplicationType.Desktop;
    }

    public static boolean isAndroidApp(){
        return Gdx.app.getType() == Application.ApplicationType.Android;
    }


}
