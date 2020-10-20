package edu.macalester.comp127.FarmArt;

import edu.macalester.graphics.GraphicsGroup;
import edu.macalester.graphics.Image;
import edu.macalester.graphics.Rectangle;
import java.awt.Color;

public class Tile extends GraphicsGroup{
    
    private final Rectangle background;
    private Image element;
    
    public Tile(double x, double y, double size) {
        this.setPosition(x, y);
        background = new Rectangle(0, 0, size, size);
        add(background);
        setBackgroundColor(null);
    }

    public void setBackgroundColor(Color color) {
        if (color == null) {
            background.setFillColor(Color.white);
            background.setStrokeColor(Color.LIGHT_GRAY);
        } else {
            background.setFillColor(color);
            background.setStroked(false);
        }
    }

    public void setElement(Image newElement) {
        if (element != null) {
            remove(element);
        }
        newElement.setCenter(background.getCenter());
        add(newElement);
        element = newElement;
    }
}
