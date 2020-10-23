package edu.macalester.comp127.FarmArt;

import edu.macalester.graphics.GraphicsGroup;
import edu.macalester.graphics.Image;
import edu.macalester.graphics.Rectangle;
import java.awt.Color;

/** 
 * Represent a tile as graphicsGroup 
 * A tile has a background color
 * A tile has a element
 */
public class Tile extends GraphicsGroup{
    
    private final Rectangle background;
    private Image elementImage;
    private String type;
    
    /**
     * A constructor of Tile
     * @param x
     * @param y
     * @param size 
     */
    public Tile(double x, double y, double size) {
        this.setPosition(x, y);
        background = new Rectangle(0, 0, size, size);
        add(background);
        setBackgroundColor(null, null);
    }

    /**
     * Set the background color of a tile
     * Controls tile's stroke and filled color
     * @param color
     * @param type
     */
    public void setBackgroundColor(Color color, BackgroundType type) {
        if (color == null) {
            background.setFillColor(Color.white);
            background.setStrokeColor(Color.LIGHT_GRAY);
        } 
        else {
            background.setFillColor(color);
            background.setStroked(false);
            this.type = type.getName();
        }
    }

    /**
     * If there is an existing element on the tile, it is removed.
     * Then, it sets the element in a tile and updates the current element. 
     * Checks if background is not null before setting element.
     * @param currentElementType
     */
    public void setElement(ElementType currentElementType) {
        Image newElement = new Image(currentElementType.getName()+ ".png");
        newElement.setMaxHeight(50);
        newElement.setMaxWidth(50);
        
        if (currentElementType.getType().contains(type) || currentElementType.getType() == "all") {
            if (currentElementType.getName() == "blank") {
                setBackgroundColor(null, null);
            }
            if (elementImage != null) {
                remove(elementImage);
            }
            newElement.setCenter(background.getCenter());
            add(newElement);
            this.elementImage = newElement; 
        }
    }
}