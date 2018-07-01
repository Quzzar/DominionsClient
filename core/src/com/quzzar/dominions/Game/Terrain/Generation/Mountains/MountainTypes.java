package com.quzzar.dominions.Game.Terrain.Generation.Mountains;

import com.badlogic.gdx.graphics.Texture;

import java.util.Random;

public enum MountainTypes {

    MOUNTAIN_1("game/terrain/mountains/mount_1.png"),
    MOUNTAIN_2("game/terrain/mountains/mount_2.png"),
    MOUNTAIN_3("game/terrain/mountains/mount_3.png"),
    MOUNTAIN_4("game/terrain/mountains/mount_4.png");

    private Texture texture;

    MountainTypes(String path){
        texture = new Texture(path);
    }

    public Texture getTexture() {
        return texture;
    }

    public static MountainTypes RANDOM(){
        int val = new Random().nextInt(MountainTypes.values().length);
        return MountainTypes.values()[val];
    }

}
