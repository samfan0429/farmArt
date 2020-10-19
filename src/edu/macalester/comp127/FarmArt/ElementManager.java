package edu.macalester.comp127.FarmArt;

import java.util.ArrayList;
import java.util.List;

import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.Image;
import edu.macalester.graphics.Point;

public class ElementManager {

    private static List<ElementType> elementImages;
    private static List<Image> images;
    private static final double NUM_ROWS = 16;
    private static final double NUM_COLUMNS = 24;
    private static double x;
    private static double y;

    public ElementManager() {
        images = new ArrayList<>();
    }

    public void generateBlankGrid(CanvasWindow canvas) {
        x = 240;
        y = 0;
        for (int r = 0; r < NUM_ROWS; r++) {
            for (int c = 0; c < NUM_COLUMNS; c++) {
                Image blankImage = new Image(x, y, "blank.png");
                blankImage.setMaxHeight(50);
                blankImage.setMaxWidth(50);  
                canvas.add(blankImage);
                x += blankImage.getWidth();
            }
            x = 240;
            y += 50;
        }
    }

    public List<ElementType> addImages() {

        elementImages = new ArrayList<>();

        Image blank = new Image("newBlank.png");
        elementImages.add(new ElementType("blank", blank));
    
        Image cabbage = new Image("cabbage.png");
        elementImages.add(new ElementType("cabbage", cabbage));

        Image potato = new Image("potato.png");
        elementImages.add(new ElementType("potato", potato));

        Image cauliflower = new Image("cauliflower.png");
        elementImages.add(new ElementType("cauliflower", cauliflower));

        Image corn = new Image("corn.png");
        elementImages.add(new ElementType("corn", corn));

        Image carrot = new Image("carrot.png");
        elementImages.add(new ElementType("carrot", carrot));

        Image tomato = new Image("tomato.png");
        elementImages.add(new ElementType("tomato", tomato));

        Image cucumber = new Image("cucumber.png");
        elementImages.add(new ElementType("cucumber", cucumber));

        Image eggplant = new Image("eggplant.png");
        elementImages.add(new ElementType("eggplant", eggplant));

        Image crab = new Image("crab.png");
        elementImages.add(new ElementType("crab", crab));

        Image duck = new Image("duck.png");
        elementImages.add(new ElementType("duck", duck));

        Image fish = new Image("fish.png");
        elementImages.add(new ElementType("fish", fish));

    
        
        return elementImages;
    }

    public void selectImage(Point location, ElementType image, CanvasWindow canvas, TileManager tileManager) {
        for (Tile tile : tileManager.getTiles()) { 
            if (tile.testHit(location.getX(), location.getY())) {
                if (canvas.getElementAt(location.getX(), location.getY()) instanceof Image) {
                    canvas.remove(canvas.getElementAt(location.getX(), location.getY()));
                }
                    Image image1 = new Image(image.getName() + ".png");
                    canvas.add(image1);
                    image1.setPosition(tile.getPosition());
                    image1.setMaxHeight(50);
                    image1.setMaxWidth(50);
            }
        }
    }

    public List<Image> getImages() {
        return images;
    }
}
