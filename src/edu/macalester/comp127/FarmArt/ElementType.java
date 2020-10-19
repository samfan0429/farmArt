package edu.macalester.comp127.FarmArt;

import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.Image;
import edu.macalester.graphics.Point;

public class ElementType {
    
    private String name;
    private Image image;
    private String type;

    public ElementType(String name, Image image) {
        this.name = name;
        this.image = image;
    }
    
    // public ElementType(String name, Image image, String type) {
    //     this.name = name;
    //     this.image = image;
    //     this.type = type;
    // }

    public String getName() {
        return name;
    }

    public Image getImage() {
        return image;
    }

    // public String getType() {
    //     return type;
    // }

    public void selectImage(Tile tile) {
        Image image1 = new Image(name + ".png");
        image1.setMaxHeight(50);
        image1.setMaxWidth(50);
        tile.setElement(image1);
    }
}
