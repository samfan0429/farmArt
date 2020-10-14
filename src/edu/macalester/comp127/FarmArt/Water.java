package edu.macalester.comp127.FarmArt;

import edu.macalester.graphics.Point;
import java.util.List;
import java.util.Random;

import edu.macalester.graphics.GraphicsGroup;

import java.awt.Color;

public class Water implements Backgrounds {
    List<Tile> tiles;
    Random r = new Random();


    public void apply(TileManager tileManager, Point location, GraphicsGroup background) {
        int num1 = randomInt(153, 204);
        Color blue = new Color(51, num1, 255);
        List<Tile> tiles = tileManager.getTiles();
        for (Tile tile : tiles) { 
            if (tile.testHit(location.getX(), location.getY())) {
                tile.changeColor(blue);
            }
        }
    }

    public String getName() {
        return "Water";
    }

    private int randomInt(int min, int max) {
        return r.nextInt(max - min + 1) + min;
    }
}