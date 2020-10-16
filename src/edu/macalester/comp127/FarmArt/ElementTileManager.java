package edu.macalester.comp127.FarmArt;

import java.util.ArrayList;
import java.util.List;

import javax.lang.model.element.Element;

import java.awt.Color;

import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.GraphicsGroup;
import edu.macalester.graphics.Image;
import edu.macalester.graphics.Point;

public class ElementTileManager {
    private static List<ElementTile> elementTiles;
    private final double NUM_ROWS = 16;
    private final double NUM_COLUMNS = 24;
    private final static double TILE_SIZE = 50;

    public ElementTileManager() {
        elementTiles = new ArrayList<>();
    }

    /**
    Generates rows and columns of tiles on the canvas, and adds each individual tiles to the a list.
     */
    public void generateGrid(GraphicsGroup farmGraphics) {
        double x = 240;
        double y = 0;
        for (int r = 0; r < NUM_ROWS; r++) {
            for (int c = 0; c < NUM_COLUMNS; c++) {
                ElementTile tile = new ElementTile(x, y, TILE_SIZE);
                farmGraphics.add(tile);
                x += tile.getWidth();
                elementTiles.add(tile);
            }
            x = 240;
            y += TILE_SIZE;
        }
    }

    public void addImage(Point location, Image name, CanvasWindow canvas) {
        for (ElementTile tile : elementTiles) { 
            if(tile.testHit(location.getX(), location.getY())) {
                canvas.add(tile.selectImage());
            }      
        }
    }
    
    public Image selectImage() {
        Image cabbage = new Image(100, 200, "farmElements/farmVegetable/cabbage.png");
        return cabbage;
    }


    // public static List<Tile> getTiles() {
    //     return tiles;
    // }



}