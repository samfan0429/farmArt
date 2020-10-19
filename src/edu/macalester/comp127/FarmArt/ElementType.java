package edu.macalester.comp127.FarmArt;

import java.util.ArrayList;
import java.util.List;
import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.Image;
import edu.macalester.graphics.Point;

public class ElementType {
    
    private String type;
    private Image image;

    public ElementType(String type, Image image) {
        this.type = type;
        this.image = image;
    }

    public String getName() {
        return type;
    }

    public Image getImage() {
        return image;
    }
}
