package com.quzzar.dominions.Game.Terrain.Generation.Trees;

import com.quzzar.dominions.Game.Enums.ObstacleType;
import com.quzzar.dominions.Game.Obstacle;
import com.quzzar.dominions.Game.Terrain.Generating;

public class Tree extends Generating {

    public Tree(int squareX, int squareY) {
        super(TreeTypes.RANDOM().getTexture(), squareX, squareY, ObstacleType.TREE);
    }

    public Tree(TreeTypes treeType, int squareX, int squareY) {
        super(treeType.getTexture(), squareX, squareY, ObstacleType.TREE);
    }

    public Tree(float x, float y) {
        super(TreeTypes.RANDOM().getTexture(), x, y, ObstacleType.TREE);
    }

    public Tree(TreeTypes treeType, float x, float y) {
        super(treeType.getTexture(), x, y, ObstacleType.TREE);
    }


}
