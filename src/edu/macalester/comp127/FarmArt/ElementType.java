package edu.macalester.comp127.FarmArt;

import edu.macalester.graphics.Image;

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
