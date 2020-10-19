package edu.macalester.comp127.FarmArt;

import java.util.List;
import java.awt.Color;
import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.Image;
import edu.macalester.graphics.Rectangle;
import edu.macalester.graphics.ui.Button;


public class FarmArt {
    private static CanvasWindow canvas;
    private Brush currentBrush;
    private List<BackgroundType> backgroundsList;
    private List<ElementType> elementImages;
    private TileManager tileManager;
    private ElementManager elementManager = new ElementManager();
    private Rectangle selectedButtonIndicator;

    public FarmArt() {
        canvas = new CanvasWindow("Farm Art!", 2400, 800);

        // create selectedButtonIndicator rectangle
        // put it in an instance variable
        // give it a thick stroke width
        // make it a happy color or whatever
        // add it to the canvas *before* the buttons
        // position it far off the screen
        selectedButtonIndicator = new Rectangle(-50, -50, 50, 20);
        selectedButtonIndicator.setStroked(false);
        selectedButtonIndicator.setFillColor(Color.blue);
        canvas.add(selectedButtonIndicator);

        backgroundsList = List.of(
            new BackgroundType("eraser", null, null),
            new BackgroundType("dirt", new Color(90, 50, 0), new Color(120, 60, 0)),
            new BackgroundType("water", new Color(40, 150, 245), new Color(100, 200, 245)),
            new BackgroundType("grass", new Color(50, 200, 0), new Color(150, 230, 0)));

        double buttonY = 0;
        for (BackgroundType background : backgroundsList) {
            buttonY += 30;
            addBackgroundButton(background, buttonY);
        }

        elementImages = elementManager.addImages();
        buttonY = 120;
        for (ElementType image : elementImages) {
            buttonY += 30;
            addElementButton(image, buttonY);   
        }
    }

    public static void main(String[] args) {
        FarmArt farmArt = new FarmArt();
        farmArt.run();
    }

    public void run() {    
        tileManager = new TileManager();
        tileManager.generateGrid(canvas);
        
        canvas.onMouseDown(event -> {
            Tile tile = tileManager.findTileAt(event.getPosition());
            if (tile != null) {
                currentBrush.apply(tile);
            }
        });
        elementManager.generateBlankGrid(canvas);
    }

    private void addBackgroundButton(BackgroundType background, double y) {
        Button backgroundButton = new Button(background.getName());
        backgroundButton.setPosition(100, y);
        canvas.add(backgroundButton);
        backgroundButton.onClick(() -> {
            currentBrush = new BackgroundBrush(background);
            showSelectedButton(backgroundButton);
        });
    }

    private void showSelectedButton(Button button) {
        selectedButtonIndicator.setPosition(button.getPosition());
        selectedButtonIndicator.setSize(button.getSize());
    }

    private void addElementButton(ElementType elementType, double y) {
        Button elementButton = new Button(elementType.getName());
        elementButton.setPosition(100, y);
        canvas.add(elementButton);
        elementButton.onClick(() -> {
            currentBrush = new ElementBrush(elementType);
            showSelectedButton(elementButton);
        });
    }
}
