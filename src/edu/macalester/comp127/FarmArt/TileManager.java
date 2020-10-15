package edu.macalester.comp127.FarmArt;

import java.util.ArrayList;
import java.util.List;

import edu.macalester.graphics.GraphicsGroup;

public class TileManager {
    private static List<Tile> tiles;
    private final double NUM_ROWS = 16;
    private final double NUM_COLUMNS = 24;
    private final static double TILE_SIZE = 50;

    public TileManager() {
        tiles = new ArrayList<>();
    }

    /**
    Generates rows and columns of tiles on the canvas, and adds each individual tiles to the a list.
     */
    public void generateGrid(GraphicsGroup farmGraphics) {
        double x = 240;
        double y = 0;
        for (int r = 0; r < NUM_ROWS; r++) {
            for (int c = 0; c < NUM_COLUMNS; c++) {
                Tile tile = new Tile(x, y, TILE_SIZE);
                farmGraphics.add(tile);
                x += tile.getWidth();
                tiles.add(tile);
            }
            x = 240;
            y += TILE_SIZE;
        }
    }

    public List<Tile> getTiles() {
        return tiles;
    }
}


