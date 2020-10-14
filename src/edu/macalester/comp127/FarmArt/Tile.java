package edu.macalester.comp127.FarmArt;

import edu.macalester.graphics.Rectangle;
import java.awt.Color;

public class Tile extends Rectangle{
    private final static double tileDim = 50;
    private double x;
    private double y;

    public Tile(double x, double y) {
        super(x, y, tileDim, tileDim);
        this.x = x;
        this.y = y;
        this.setFillColor(Color.white);
        this.setStrokeColor(Color.black);
    }

    public void changeColor(Color color) {
        this.setFillColor(color);
    }
}
