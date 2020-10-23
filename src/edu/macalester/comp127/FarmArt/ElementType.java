package edu.macalester.comp127.FarmArt;

import edu.macalester.graphics.Image;

/**
* Sets up an Element's name, corresponding image, and type.
* Each element represents each image that can be put on the screen
*/
public class ElementType {
    
    private String name;
    private Image image;
    private String type;
    
    /**
    * Constructs and ElementType
    * @param name
    * @param image
    * @param type
    */
    public ElementType(String name, Image image, String type) {
        this.name = name;
        this.image = image;
        this.type = type;
    }

    /**
    * Returns this ElementTypes name.
    */
    public String getName() {
        return name;
    }

    /**
    * Returns this ElementTypes image.
    */
    public Image getImage() {
        return image;
    }

    /**
    * Returns this ElementTypes type.
    */
    public String getType() {
        return type;
    }

    /**
    * Calls setElement with given tile on this ElementType.
    * @param tile 
    */
    public void selectImage(Tile tile) {
        tile.setElement(this);
    }
}
