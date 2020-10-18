package edu.macalester.comp127.FarmArt;

import edu.macalester.graphics.Point;
import java.awt.Color;
import java.util.Random;

public class BackgroundType {
    private String type;
    private Random r = new Random();
    private Color color1;
    private Color color2;

    public BackgroundType(String type, Color color1, Color color2) {
        this.type = type;
        this.color1 = color1;
        this.color2 = color2;
    }
    
    public void apply(TileManager tileManager, Point location) {
        double redRange = randomFloat() * (color1.getRed() - color2.getRed());
        double greenRange = randomFloat() * (color1.getGreen() - color2.getGreen());
        double blueRange = randomFloat() * (color1.getBlue() - color2.getBlue());

        Color newColor = new Color(
            (int) (color1.getRed() + redRange), 
            (int) (color1.getGreen() + greenRange), 
            (int) (color1.getBlue() + blueRange));

        tileManager.colorChange(location, newColor);
    }

    public String getName() {
        return type;
    }

    private double randomFloat() {
        return r.nextDouble();
    }

}
