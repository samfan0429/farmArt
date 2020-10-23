package edu.macalester.comp127.FarmArt;

import java.util.ArrayList;
import java.util.List;
import edu.macalester.graphics.GraphicsGroup;
import edu.macalester.graphics.Point;

/**
* Manages a graphics group of tiles.
* finds position of tiles on the graphics group
* allows user to drag and scale the graphics group
*/
public class TileManager extends GraphicsGroup { 
    
    public static final double NUM_ROWS = 80;
    public static final double NUM_COLUMNS = 120;
    public static final int START_X = 240;
    private static List<Tile> tiles;
    private double tileSize = 50;
    private double offsetX;
    private double offsetY;

    /**
     * A constructor of Tile Manager 
     */
    public TileManager() {
        super(START_X, 0);
        tiles = new ArrayList<>();
        this.setAnchor(0,0);
    }

    /**
    * Creates grid of blank tiles on this graphics groups starting from (0,0), extending for the set number of rows and columns.
    * They are also added to an array of tiles.
    */
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

    /**
    * Iterates through tiles in array.
    * If parameter location adjusted for location on graphics group hits the given tile, it is returned, else null.
    * @param location
    */
    public Tile findTileAt(Point location) {
        for (Tile tile : tiles) { 
            if (tile.testHit(((location.getX() - START_X) - offsetX)/this.getScaleX(), (location.getY() - offsetY)/this.getScaleY())){
                return tile;
            }
        }
        return null;
    }

    /**
    * Creates canvas to show the rules, and then a text field with the rules are applied to it. 
    * Canvas will close on click.
    */
    public void scaleDown() {
        double scaleX = this.getScaleX();
        double scaleY = this.getScaleY();
        if (scaleX > .20001 || scaleY > .20001) {
            this.setScale(scaleX * .9, scaleY * .9);
        }
    }

    /**
    * Updates this graphics group's scale visually and updates the instance variables keeping track of the current scale.
    */
    public void scaleUp() {
        double scaleX = this.getScaleX();
        double scaleY = this.getScaleY();
        this.setScale(scaleX * 1.1, scaleY * 1.1);
    }

    /**
    * Returns scale of this graphics group to 1.
    */
    public void scaleNormal() {
        this.setScale(1, 1);
    }

    /**
    * Moves this entire graphics group by the x and y distances provided.
    * @param actionX
    * @param actionY
    */
    public void dragGraphics(double actionX, double actionY) {
        this.moveBy(actionX, actionY);
        this.offsetX += actionX;
        this.offsetY += actionY;
    }
}