package com.quzzar.dominions.Fonts;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.quzzar.dominions.Fonts.FontType;

public class Font {

    private BitmapFont font;

    private float scale;

    public Font(FontType fontType, float scale){

        this.scale = scale;

        font = fontType.getFont();
        font.getData().setScale(scale);

    }

    public void writeText(SpriteBatch batch, String text, Vector2 location){
        font.draw(batch,text, location.x, location.y);
    }

    public int writeDetails(SpriteBatch batch, String title, double value, Vector2 location){
        if(value!=0){
            writeText(batch,title+": "+value,location);
            return 1;
        }
        return 0;
    }

    public int writeDetails(SpriteBatch batch, String title, String value, Vector2 location){
        if(value!=""){
            writeText(batch,title+": "+value,location);
            return 1;
        }
        return 0;
    }

    public void setColor(float red, float green, float blue, float alpha){
        font.setColor(red, green, blue, alpha);
    }

    public void dispose(){
        font.dispose();
    }

    public static BitmapFont getFont(FontType fontType, float size){
        BitmapFont font = fontType.getFont();
        font.getData().scale(size);
        return font;
    }

}
