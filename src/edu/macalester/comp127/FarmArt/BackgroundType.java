package edu.macalester.comp127.FarmArt;

import java.awt.Color;
import java.util.Random;

/**
 * Creates a background type that organizes each background based on its string name,
 * and color range (color1, color2)
 */
public class BackgroundType {
    
    private String type;
    private Color color1;
    private Color color2;
    private Random random = new Random();

    /**
     * Constructor for BackgroundType
     * @param type
     * @param color1 lower color bound
     * @param color2 upper color bound
     */
    public BackgroundType(String type, Color color1, Color color2) {
        this.type = type;
        this.color1 = color1; 
        this.color2 = color2;
    }
    
    /**
     * creates a random color within a color range 
     * applies the new color to tile by calling setBackgroundColor
     * @param tile
     */
    public void apply(Tile tile) {
        if (color1 == null || color2 == null) {
            tile.setBackgroundColor(null, null);
            return;
        }

        double redRange = randomDouble() * (color2.getRed() - color1.getRed());
        double greenRange = randomDouble() * (color2.getGreen() - color1.getGreen());
        double blueRange = randomDouble() * (color2.getBlue() - color1.getBlue());

        Color newColor = new Color(
            (int) (color1.getRed() + redRange), 
            (int) (color1.getGreen() + greenRange), 
            (int) (color1.getBlue() + blueRange));
    
        tile.setBackgroundColor(newColor, this);
        
    }

    /**
     * Gets string name of BackgroundType
     */
    public String getName() {
        return type;
    }

    /**
     * Convenience method that returns a random double between 0.0 and 1.0
     */
    private double randomDouble() {
        return random.nextDouble();
    }

}