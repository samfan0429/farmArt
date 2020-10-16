package edu.macalester.comp127.FarmArt;

import edu.macalester.graphics.GraphicsObject;
import edu.macalester.graphics.Rectangle;
import java.awt.Color;

public class ElementTile extends Rectangle{
    
    public ElementTile(double x, double y, double size) {
        super(x, y, size, size);
        this.setFillColor(Color.WHITE);
        this.setStroked(false);

    }

    public GraphicsObject selectImage() {
        return null;
    }
}
