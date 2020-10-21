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
    
        // ---------------- vegetable -------------------
        Image cabbage = new Image("cabbage.png");
        elementImages.add(new ElementType("cabbage", cabbage, "dirt"));

        Image potato = new Image("potato.png");
        elementImages.add(new ElementType("potato", potato, "dirt"));

        Image cauliflower = new Image("cauliflower.png");
        elementImages.add(new ElementType("cauliflower", cauliflower, "dirt"));

        Image corn = new Image("corn1.png");
        elementImages.add(new ElementType("corn", corn, "dirt"));

        Image carrot = new Image("carrot1.png");
        elementImages.add(new ElementType("carrot", carrot, "dirt"));

        // Image tomato = new Image("tomato.png");
        // elementImages.add(new ElementType("tomato", tomato, "dirt"));

        // Image cucumber = new Image("cucumber.png");
        // elementImages.add(new ElementType("cucumber", cucumber, "dirt"));

        // Image eggplant = new Image("eggplant.png");
        // elementImages.add(new ElementType("eggplant", eggplant, "dirt"));

        // Image onion = new Image("onion.png");
        // elementImages.add(new ElementType("onion", onion, "dirt"));

        Image bush = new Image("bush1.png");
        elementImages.add(new ElementType("bush", bush, "dirt"));

        Image sunflower = new Image("sunflower1.png");
        elementImages.add(new ElementType("sunflower", sunflower, "dirt"));

        Image tractor = new Image("tractor1.png");
        elementImages.add(new ElementType("tractor", tractor, "dirt"));

        // ---------------- animal -------------------

        Image rooster = new Image("rooster.png");
        elementImages.add(new ElementType("rooster", rooster, "grass"));

        Image goat = new Image("goat.png");
        elementImages.add(new ElementType("goat", goat, "grass"));

        Image pig = new Image("pig.png");
        elementImages.add(new ElementType("pig", pig, "grass"));

        Image cow = new Image("cow.png");
        elementImages.add(new ElementType("cow", cow, "grass"));

        Image duck = new Image("duck.png");
        elementImages.add(new ElementType("duck", duck, "water"));

        Image crab = new Image("crab.png");
        elementImages.add(new ElementType("crab", crab, "water"));

        Image fish = new Image("fish.png");
        elementImages.add(new ElementType("fish", fish, "water"));

        // ---------------- blank -------------------

        Image blank = new Image("newBlank.png");
        elementImages.add(new ElementType("blank", blank, "all"));
        
        return elementImages;
    }

   

    public List<Image> getImages() {
        return images;
    }
}
