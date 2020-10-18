package edu.macalester.comp127.FarmArt;

import java.util.ArrayList;
import java.util.List;
import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.Image;
import edu.macalester.graphics.Point;

public class ElementType {

    private static List<Image> elementImages;
    private static List<Tile> elementTile;
    private static final double NUM_ROWS = 16;
    private static final double NUM_COLUMNS = 24;
    private static double x;
    private static double y;
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

    public void generateGrid(CanvasWindow canvas) {
        double x = 240;
        double y = 0;
        for (int r = 0; r < NUM_ROWS; r++) {
            for (int c = 0; c < NUM_COLUMNS; c++) {
                Tile tile = new Tile(x, y, 50);
                canvas.add(tile);
                x += tile.getWidth();
                elementTile.add(tile);
            }
            x = 240;
            y += 50;
        }
    }

    public static void generateBlankGrid(CanvasWindow canvas) {
        x = 240;
        y = 0;
        for (int r = 0; r < NUM_ROWS; r++) {
            for (int c = 0; c < NUM_COLUMNS; c++) {
                Image blankImage = new Image(x, y);
                blankImage.setImagePath("cabbage.png"); // just for trail, should go back to "balnk.png"
                blankImage.setMaxHeight(50);
                blankImage.setMaxWidth(50);  
                canvas.add(blankImage);
                x += blankImage.getWidth();
            }
            x = 240;
            y += 50;
        }
    }

    public static List addImage(CanvasWindow canvas) {

        elementImages = new ArrayList<>();
    
        Image cabbage = new Image(x, y, "cabbage.png");
        elementImages.add(cabbage);

        Image potato = new Image(x, y, "potato.png");
        elementImages.add(potato);

        Image cauliflower = new Image(x, y, "cauliflower.png");
        elementImages.add(cauliflower);

        Image corn = new Image(x, y, "corn.png");
        elementImages.add(corn);

        Image pumpkin = new Image(x, y, "pumpkin.png");
        elementImages.add(pumpkin);
        
        return elementImages;
    }

    public static void selectImage(Point location, Image image, CanvasWindow canvas) {
        for (Tile tile : elementTile) { 
            if (tile.testHit(location.getX(), location.getY())) {
                canvas.add(image);
            }
        }
    }

    public void selectImage(ElementType elementType, Point location) {
    }
    
}
