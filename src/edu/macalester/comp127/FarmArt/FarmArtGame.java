package edu.macalester.comp127.FarmArt;

import java.util.List;
import java.util.ArrayList;
import java.awt.Color;
import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.GraphicsGroup;
import edu.macalester.graphics.Image;
import edu.macalester.graphics.Rectangle;

/**
 * A farm art game that allows user to change background to water, dirt or grass
 * also allows user to add elements, including vegetables, aniamls and flowers on top of each background
 * also allows user to zoom in/out or drag the farm to create as big/small as they wish
 * the farm art game uses element images made by Ned Mayo, Stefan Gullickson, Jiaying Wu
 */
public class FarmArtGame {

    private static CanvasWindow canvas;
    private TileManager tileManager;
    private GraphicsGroup backdrop;
    private Rectangle rectangle;
    private Rectangle selectedButtonIndicator;

    /**
     * Creates canvas, tileManager, button indicator, menu
     */
    public FarmArtGame() {
        canvas = new CanvasWindow("Farm Art!", 2400, 800);
        canvas.setBackground(Color.black);
        
        tileManager = new TileManager();
        selectedButtonIndicator = new Rectangle(-50, -50, 40, 20);
    }

    /**
     * Created by Ned Mayo, Stefan Gullickson, Jiaying Wu
     * Created on Oct 23, 2020
     */
    public static void main(String[] args) {
        FarmArtGame farmArt = new FarmArtGame();
        farmArt.run();
    }

    /** 
     * Run the farmArt game 
     * creates buttons and the button indicator
     * creates black rectangle to create a layer above the grid and below the menu
     */
    public void run() { 
        tileManager.generateGrid();
        canvas.add(tileManager);

        rectangle = new Rectangle(0, 0, 240, 800);
        rectangle.setFillColor(Color.black);
        backdrop = new GraphicsGroup();
        backdrop.add(rectangle);
        canvas.add(backdrop); 

        List<BackgroundType> backgroundsList = createBackgroundsList();
        List<ElementType> elementsList = createElementsList();
        new Menu(canvas, tileManager, selectedButtonIndicator, backgroundsList, elementsList);

        selectedButtonIndicator.setStroked(false);
        selectedButtonIndicator.setFillColor(Color.blue);
        canvas.add(selectedButtonIndicator);
        showRules();
    }

    /**
    * Creates canvas to show the rules, and then a text field with the rules are applied to it. 
    * Canvas will close on click.
    */
    private void showRules() {
        CanvasWindow rulesWindow = new CanvasWindow("Rules of Farm Art", 300,600);
        Image rules = new Image("rules.png");
        rulesWindow.add(rules);
    }

    /**
    * Fills and returns a list of background types.
    */
    private List<BackgroundType> createBackgroundsList(){
        List<BackgroundType> backgroundsList = List.of(
            new BackgroundType("dirt", new Color(90, 50, 0), new Color(120, 60, 0)),
            new BackgroundType("water", new Color(40, 150, 245), new Color(100, 180, 245)),
            new BackgroundType("grass", new Color(50, 200, 0), new Color(150, 230, 0)));
        return backgroundsList;
    }

    /**
    * Fills and returns a list of element images in resources. 
    */
    private List<ElementType> createElementsList() {
        List<ElementType> elementImages = new ArrayList<>();

        // ---------------- plants -------------------

        Image corn = new Image("corn.png");
        elementImages.add(new ElementType("corn", corn, "dirt"));

        Image carrot = new Image("carrot.png");
        elementImages.add(new ElementType("carrot", carrot, "dirt"));

        Image tomato = new Image("tomato.png");
        elementImages.add(new ElementType("tomato", tomato, "dirt"));

        Image pumpkin = new Image("pumpkin.png");
        elementImages.add(new ElementType("pumpkin", pumpkin, "dirt"));

        Image sunflower = new Image("sunflower.png");
        elementImages.add(new ElementType("sunflower", sunflower, "dirtgrass"));

        Image lillypad = new Image("lillypad.png");
        elementImages.add(new ElementType("lillypad", lillypad, "water"));

        Image flower = new Image("flower.png");
        elementImages.add(new ElementType("flower", flower, "dirtgrass"));

        Image bush = new Image("bush.png");
        elementImages.add(new ElementType("bush", bush, "dirtgrass"));

        // ---------------- animals -------------------

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

        Image chicken = new Image("chicken.png");
        elementImages.add(new ElementType("chicken", chicken, "dirtgrass"));

        // ---------------- others -------------------

        Image tractor = new Image("tractor.png");
        elementImages.add(new ElementType("tractor", tractor, "dirtgrass"));
        
        return elementImages;
    }
}