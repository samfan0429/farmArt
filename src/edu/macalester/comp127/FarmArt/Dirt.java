package edu.macalester.comp127.FarmArt;

import edu.macalester.graphics.Point;
import java.util.List;

import edu.macalester.graphics.GraphicsGroup;

import java.awt.Color;

public class Dirt implements Backgrounds{
    private List<Tile> tiles;
    private Color color = new Color(153, 102, 0);

    public void apply(TileManager tileManager, Point location, GraphicsGroup background) {
        List<Tile> tiles = tileManager.getTiles();
        for (Tile tile : tiles) { 
            if (tile.testHit(location.getX(), location.getY())) {
                tile.changeColor(color);
            }
        }
    }

    public String getName() {
        return "Dirt";
    }
}