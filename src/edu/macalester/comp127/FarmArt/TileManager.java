package edu.macalester.comp127.FarmArt;

import java.util.ArrayList;
import java.util.List;
import java.awt.Color;

import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.Point;

public class TileManager { // maybe go back to graphic group
    private static List<Tile> tiles;
    private final double NUM_ROWS = 16;
    private final double NUM_COLUMNS = 24;
    private final static double TILE_SIZE = 50;

    public TileManager() {
        tiles = new ArrayList<>();
    }

    public void generateGrid(CanvasWindow canvas) {
        double x = 240;
        double y = 0;
        for (int r = 0; r < NUM_ROWS; r++) {
            for (int c = 0; c < NUM_COLUMNS; c++) {
                Tile tile = new Tile(x, y, TILE_SIZE);
                canvas.add(tile);
                x += tile.getWidth();
                tiles.add(tile);  // for the list
            }
            x = 240;
            y += TILE_SIZE;
        }
    }

    public Tile findTileAt(Point location) {
        for (Tile tile : tiles) { 
            if (tile.testHit(location.getX(), location.getY())) {
                return tile;
            }
        }
        return null;
    }

    public List<Tile> getTiles() {
        return tiles;
    }
}


