package com.quzzar.dominions.Game.Terrain.Generation.Lakes;

import com.badlogic.gdx.graphics.Texture;

import java.util.Random;

public enum LakeTypes {

    LAKE("game/terrain/lakes/lake.png");

    private Texture texture;

    LakeTypes(String path){
        texture = new Texture(path);
    }

    public Texture getTexture() {
        return texture;
    }

    public static LakeTypes RANDOM(){
        int val = new Random().nextInt(LakeTypes.values().length);
        return LakeTypes.values()[val];
    }

}