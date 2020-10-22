package edu.macalester.comp127.FarmArt;

import edu.macalester.graphics.Image;

public class ElementType {
    
    private String name;
    private Image image;
    private String type;
    
    public ElementType(String name, Image image, String type) {
        this.name = name;
        this.image = image;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public Image getImage() {
        return image;
    }

    public String getType() {
        return type;
    }

    public void selectImage(Tile tile) {
        tile.setElement(this);
    }
}
