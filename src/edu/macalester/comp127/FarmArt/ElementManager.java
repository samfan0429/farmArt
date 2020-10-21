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

        Image corn1 = new Image("corn1.png");
        elementImages.add(new ElementType("corn1", corn1, "dirt"));

        Image carrot1 = new Image("carrot1.png");
        elementImages.add(new ElementType("carrot", carrot1, "dirt"));

        Image bush = new Image("bush1.png");
        elementImages.add(new ElementType("bush", bush, "dirtGrass"));

        Image sunflower = new Image("sunflower1.png");
        elementImages.add(new ElementType("sunflower", sunflower, "dirt")); // change to dirt grass later -- just testing

        Image tomato = new Image("pixelTomato.png");
        elementImages.add(new ElementType("tomato", tomato, "dirt"));

        Image pumpkin = new Image("pixil-frame-0.png");
        elementImages.add(new ElementType("pumpkin", pumpkin, "dirt"));

        // ---------------- animal -------------------


        // ---------------- others + blank -------------------


        Image tractor = new Image("tractor1.png");
        elementImages.add(new ElementType("tractor", tractor, "dirtgrass"));

        Image newBlank = new Image("newBlank.png");
        elementImages.add(new ElementType("blank", newBlank, "all"));
        
        return elementImages;
    }

   

    public List<Image> getImages() {
        return images;
    }
}
