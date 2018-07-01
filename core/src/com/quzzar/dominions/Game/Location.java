package com.quzzar.dominions.Game;

public class Location {

    private int squareX;
    private int squareY;

    public Location(int squareX, int squareY){
        this.squareX = squareX;
        this.squareY = squareY;
    }

    public Location(){
        this.squareX = 0;
        this.squareY = 0;
    }

    public int getX() {
        return squareX;
    }

    public int getY() {
        return squareY;
    }

    public void set(int squareX, int squareY) {
        this.squareX = squareX;
        this.squareY = squareY;
    }

}
