package edu.macalester.comp127.FarmArt;

import edu.macalester.graphics.Rectangle;
import java.awt.Color;

public class Tile extends Rectangle{
    
    public Tile(double x, double y, double size) {
        super(x, y, size, size);
        this.setFillColor(Color.white);
        this.setStrokeColor(Color.LIGHT_GRAY);
    }
}
