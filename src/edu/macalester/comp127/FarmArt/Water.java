package edu.macalester.comp127.FarmArt;

import edu.macalester.graphics.Point;
import java.util.List;

import edu.macalester.graphics.GraphicsGroup;

import java.awt.Color;

public class Water {
    List<Tile> tiles;

    public static void apply(TileManager tileManager, Point location, GraphicsGroup background) {
        List<Tile> tiles = tileManager.getTiles();
        for (Tile tile : tiles) { 
            if (tile.testHit(location.getX(), location.getY())) {
                tile.changeColor(Color.blue);
            }
        }
    }

    public String getName() {
        return "Water";
    }
}