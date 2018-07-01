package com.quzzar.dominions.Game.Terrain.Generation.Lakes;

import com.quzzar.dominions.Game.Enums.ObstacleType;
import com.quzzar.dominions.Game.Obstacle;

public class Lake extends Obstacle {


    public Lake(int squareX, int squareY) {
        super(LakeTypes.RANDOM().getTexture(), squareX, squareY, ObstacleType.LAKE);
    }

    public Lake(LakeTypes lakeType, int squareX, int squareY) {
        super(lakeType.getTexture(), squareX, squareY, ObstacleType.LAKE);
    }

}
