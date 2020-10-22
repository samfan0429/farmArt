package edu.macalester.comp127.FarmArt;

import java.util.ArrayList;
import java.util.List;
import edu.macalester.graphics.Image;

public class ElementManager {

    private static List<ElementType> elementImages;
    private static List<Image> images;
    public static final double NUM_ROWS = 16;
    public static final double NUM_COLUMNS = 24;

    public ElementManager() {
        images = new ArrayList<>();
    }

    public void generateBlankGrid(TileManager tileManager) {
        int x = 0;
        int y = 0;
        for (int r = 0; r < NUM_ROWS; r++) {
            for (int c = 0; c < NUM_COLUMNS; c++) {
                Image blankImage = new Image(x, y, "blank.png");
                blankImage.setMaxHeight(50);
                blankImage.setMaxWidth(50);  
                tileManager.add(blankImage);
                x += blankImage.getWidth();
            }
            x = 0;
            y += 50;
        }
    }

    public List<ElementType> addImages() {

        elementImages = new ArrayList<>();
    
        // ---------------- plants -------------------

        Image corn = new Image("corn.png");
        elementImages.add(new ElementType("corn", corn, "dirt"));

        Image carrot = new Image("carrot.png");
        elementImages.add(new ElementType("carrot", carrot, "dirt"));

        Image bush = new Image("bush.png");
        elementImages.add(new ElementType("bush", bush, "dirtgrass"));

        Image sunflower = new Image("sunflower.png");
        elementImages.add(new ElementType("sunflower", sunflower, "dirtgrass")); // change to dirt grass later -- just testing

        Image tomato = new Image("tomato.png");
        elementImages.add(new ElementType("tomato", tomato, "dirt"));

        Image pumpkin = new Image("pumpkin.png");
        elementImages.add(new ElementType("pumpkin", pumpkin, "dirt"));

        Image lillypad = new Image("lillypad.png");
        elementImages.add(new ElementType("lillypad", lillypad, "water"));

        // ---------------- animal -------------------

        Image pig = new Image("pig.png");
        elementImages.add(new ElementType("pig", pig, "dirtgrass"));

        Image snake = new Image("snake.png");
        elementImages.add(new ElementType("snake", snake, "dirtgrass"));

        Image fish = new Image("fish.png");
        elementImages.add(new ElementType("fish", fish, "water"));

        Image landDuck = new Image("landDuck.png");
        elementImages.add(new ElementType("landDuck", landDuck, "dirtgrass"));

        Image waterDuck = new Image("waterDuck.png");
        elementImages.add(new ElementType("waterDuck", waterDuck, "water"));

        // ---------------- others + blank -------------------
        
        Image fence = new Image("fence.png");
        elementImages.add(new ElementType("fence", fence, "dirtgrass"));

        Image tractor = new Image("tractor.png");
        elementImages.add(new ElementType("tractor", tractor, "dirtgrass"));

        Image blank = new Image("blank.png");
        elementImages.add(new ElementType("blank", blank, "all"));
        
        return elementImages;
    }

    public List<Image> getImages() {
        return images;
    }
}
