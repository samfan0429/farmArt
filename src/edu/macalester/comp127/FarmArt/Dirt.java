package edu.macalester.comp127.FarmArt;

import edu.macalester.graphics.Point;
import java.util.List;
import java.util.Random;

import edu.macalester.graphics.GraphicsGroup;

import java.awt.Color;

public class Dirt implements BackgroundType{
    private Random r = new Random();

    public void apply(TileManager tileManager, Point location, GraphicsGroup background) {
        int num1 = randomInt(100, 120);
        int num2 = randomInt(50, 70);
        Color brown = new Color(num1, num2, 0);
        List<Tile> tiles = tileManager.getTiles();
        for (Tile tile : tiles) { 
            if (tile.testHit(location.getX(), location.getY())) {
                tile.changeColor(brown);
            }
        }
    }

    public String getName() {
        return "Dirt";
    }

    private int randomInt(int min, int max) {
        return r.nextInt(max - min + 1) + min;
    }
}