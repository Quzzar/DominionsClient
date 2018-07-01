package com.quzzar.dominions.Fonts;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;

public enum FontType {

    AK_SANS("fonts/AK_SANS.fnt");


    private String fontPath;

    FontType(String fontPath){
        this.fontPath = fontPath;
    }

    public BitmapFont getFont() {
        return new BitmapFont(Gdx.files.internal(fontPath));
    }

}
