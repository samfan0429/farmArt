package edu.macalester.comp127.FarmArt;

import edu.macalester.graphics.GraphicsGroup;
import edu.macalester.graphics.Image;
import edu.macalester.graphics.Rectangle;
import java.awt.Color;

public class Tile extends GraphicsGroup{
    
    private final Rectangle background;
    private ElementType currentElement;
    private Image elementImage;
    private String type;
    
    public Tile(double x, double y, double size) {
        this.setPosition(x, y);
        background = new Rectangle(0, 0, size, size);
        add(background);
        setBackgroundColor(null, null);
    }

    public void setBackgroundColor(Color color, BackgroundType type) {
        if (color == null) {
            background.setFillColor(Color.white);
            background.setStrokeColor(Color.LIGHT_GRAY);
        } else {
            if (currentElement == null || currentElement.getName().contains(type.getName())) {
                background.setFillColor(color);
                background.setStroked(false);
                this.type = type.getName();
            }
        }
    }

    public void setElement(ElementType currentElement) {
        Image newElement = new Image(currentElement.getName()+ ".png");
        newElement.setMaxHeight(50);
        newElement.setMaxWidth(50);

        if (currentElement.getType().contains(type) || currentElement.getType() == "all") {
            if (elementImage != null) {
                remove(elementImage);
            }
            newElement.setCenter(background.getCenter());
            add(newElement);
            this.elementImage = newElement;
            if (currentElement.getName() == "blank") {
                this.currentElement = null;
            } else {
                this.currentElement = currentElement;
            }
        }
    }
}
