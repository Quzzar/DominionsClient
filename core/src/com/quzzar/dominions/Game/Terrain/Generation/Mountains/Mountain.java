package com.quzzar.dominions.Game.Terrain.Generation.Mountains;

import com.quzzar.dominions.Game.Enums.ObstacleType;
import com.quzzar.dominions.Game.Obstacle;
import com.quzzar.dominions.Game.Terrain.Generating;

public class Mountain extends Generating{


    public Mountain(int squareX, int squareY) {
        super(MountainTypes.RANDOM().getTexture(), squareX, squareY, ObstacleType.MOUNTAIN);
    }

    public Mountain(MountainTypes mountainType, int squareX, int squareY) {
        super(mountainType.getTexture(), squareX, squareY, ObstacleType.MOUNTAIN);
    }

}
