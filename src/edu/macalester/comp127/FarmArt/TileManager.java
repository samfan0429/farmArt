package edu.macalester.comp127.FarmArt;

import java.util.ArrayList;
import java.util.List;
import edu.macalester.graphics.GraphicsGroup;
import edu.macalester.graphics.Point;

public class TileManager extends GraphicsGroup { 
    private static List<Tile> tiles;
    public static final double NUM_ROWS = 80;
    public static final double NUM_COLUMNS = 120;
    private double tileSize = 50;
    public static final int START_X = 240;

    public TileManager() {
        super(START_X, 0);
        tiles = new ArrayList<>();
        this.setAnchor(0,0);
    }

    public void generateGrid() {
        double x = 0;
        double y = 0;
        for (int r = 0; r < NUM_ROWS; r++) {
            for (int c = 0; c < NUM_COLUMNS; c++) {
                Tile tile = new Tile(x, y, tileSize);
                this.add(tile);
                x += tile.getWidth();
                tiles.add(tile); 
            }
            x = 0;
            y += tileSize;
        }
    }

    public Tile findTileAt(Point location) {
        for (Tile tile : tiles) { 
            if (tile.testHit((location.getX() - START_X)/this.getScaleX(), location.getY()/this.getScaleY())) {
                return tile;
            }
        }
        return null;
    }

    public List<Tile> getTiles() {
        return tiles;
    }

    public void scaleDown() {
        double scaleX = this.getScaleX();
        double scaleY = this.getScaleY();
        if (scaleX > .20001 || scaleY > .20001) {
            this.setScale(scaleX * .9, scaleY * .9);
        }
    }

    public void scaleUp() {
        double scaleX = this.getScaleX();
        double scaleY = this.getScaleY();
        this.setScale(scaleX * 1.1, scaleY * 1.1);
    }

    public void scaleNormal() {
        this.setScale(1, 1);
    }
}


