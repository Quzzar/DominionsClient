package com.quzzar.dominions.Game.Terrain.Generation.Trees;

import com.badlogic.gdx.graphics.Texture;

import java.util.Random;

public enum TreeTypes {

    ALBA("game/terrain/trees/abies_alba.png"),
    PINE("game/terrain/trees/hemlock_pine.png"),
    CEDAR("game/terrain/trees/lebanon_cedar.png"),
    PUZZLE("game/terrain/trees/monkey-puzzle.png"),
    FIG("game/terrain/trees/mulberry_fig.png"),
    RED_CEDAR("game/terrain/trees/red_cedar.png"),
    FIR("game/terrain/trees/silver_fir.png"),
    STONE_PINE("game/terrain/trees/stone_pine.png"),
    SWISS_PINE("game/terrain/trees/swiss_stone_pine.png"),
    WILLOW("game/terrain/trees/weeping_willow.png");

    private Texture texture;

    TreeTypes(String path){
        texture = new Texture(path);
    }

    public Texture getTexture() {
        return texture;
    }

    public static TreeTypes RANDOM(){
        int val = new Random().nextInt(TreeTypes.values().length);
        return TreeTypes.values()[val];
    }

}
