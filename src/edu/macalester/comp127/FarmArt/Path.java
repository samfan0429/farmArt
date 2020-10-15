package edu.macalester.comp127.FarmArt;

import edu.macalester.graphics.Point;
import java.util.List;
import java.util.Random;

import edu.macalester.graphics.GraphicsGroup;

import java.awt.Color;

public class Path implements BackgroundType {
    List<Tile> tiles;
    Random r = new Random();

    public void apply(TileManager tileManager, Point location, GraphicsGroup background) {
        int num1 = randomInt(100, 200);
        Color grey = new Color(num1, num1, num1);
        List<Tile> tiles = tileManager.getTiles();
        for (Tile tile : tiles) {
            if (tile.testHit(location.getX(), location.getY())) {
                tile.changeColor(grey);
            }
        }
    }

    public String getName() {
        return "Path";
    }

    private int randomInt(int min, int max) {
        return r.nextInt(max - min + 1) + min;
    }
}