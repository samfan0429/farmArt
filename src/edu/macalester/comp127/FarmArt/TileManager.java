package edu.macalester.comp127.FarmArt;

import java.util.ArrayList;
import java.util.List;
import edu.macalester.graphics.GraphicsGroup;
import edu.macalester.graphics.Point;

public class TileManager extends GraphicsGroup { 
    private static List<Tile> tiles;
    public static final double NUM_ROWS = 16;
    public static final double NUM_COLUMNS = 24;
    private final static double TILE_SIZE = 50;
    public static final int START_X = 240;

    public TileManager() {
        super(START_X, 0);
        tiles = new ArrayList<>();
    }

    public void generateGrid() {
        double x = 0;
        double y = 0;
        for (int r = 0; r < NUM_ROWS; r++) {
            for (int c = 0; c < NUM_COLUMNS; c++) {
                Tile tile = new Tile(x, y, TILE_SIZE);
                this.add(tile);
                x += tile.getWidth();
                tiles.add(tile); 
            }
            x = 0;
            y += TILE_SIZE;
        }
    }

    public Tile findTileAt(Point location) {
        for (Tile tile : tiles) { 
            if (tile.testHit(location.getX() - START_X, location.getY())) {
                return tile;
            }
        }
        return null;
    }

    public List<Tile> getTiles() {
        return tiles;
    }


    /**
     * The second parameter passed to all ParametricFunctions this calculator is showing.
     */
    public double getAnimationParameter() {
        return animationParameter;
    }

    /**
     * Changes the second parameter passed to all ParametricFunctions in this calculator.
     * Immediately recomputes and redraws all the functions.
     */
    public void setAnimationParameter(double animationParameter) {
        this.animationParameter = animationParameter;
        recalculateAll();
    }

}


