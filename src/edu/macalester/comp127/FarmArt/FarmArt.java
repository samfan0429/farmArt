package edu.macalester.comp127.FarmArt;

import java.util.List;
import java.awt.Color;
import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.Image;
import edu.macalester.graphics.ui.Button;


public class FarmArt {
    private static CanvasWindow canvas;
    private BackgroundType currentBackground;
    private ElementType currentImage;
    private List<BackgroundType> backgroundsList;
    private List<ElementType> elementImages;
    private double ButtonY;
    private TileManager tileManager;
    private ElementManager elementManager = new ElementManager();

    public FarmArt() {
        canvas = new CanvasWindow("Farm Art!", 2400, 800);

        backgroundsList = List.of(
            new BackgroundType("eraser", new Color(255, 255, 255), new Color(255, 255, 255)),
            new BackgroundType("dirt", new Color(90, 50, 0), new Color(120, 60, 0)),
            new BackgroundType("water", new Color(40, 150, 245), new Color(100, 200, 245)),
            new BackgroundType("grass", new Color(50, 200, 0), new Color(150, 230, 0)));

        currentBackground = null;
        currentImage = new ElementType("blank", new Image("blank.png"));

        ButtonY = 0;
        for (BackgroundType background : backgroundsList) {
            ButtonY += 30;
            addBackgroundButton(background, ButtonY);
        }

        elementImages = elementManager.addImages();
        ButtonY = 120;
        for (ElementType image : elementImages) {
            currentImage = image;
            ButtonY += 30;
            addElementButton(currentImage, ButtonY);   
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
            currentBackground.apply(tileManager, event.getPosition());
            elementManager.selectImage(event.getPosition(), currentImage, canvas, tileManager);
        });
        addBackgroundButton(currentBackground, ButtonY);
        elementManager.generateBlankGrid(canvas);
    }

    private void addBackgroundButton(BackgroundType background, double y) {
        Button backgroundButton = new Button(background.getName());
        backgroundButton.setPosition(100, y);
        canvas.add(backgroundButton);
        backgroundButton.onClick(() -> currentBackground = background);
    }

    private void addElementButton(ElementType elementImages, double y) {
        Button elementButton = new Button(elementImages.getName());
        elementButton.setPosition(100, y);
        canvas.add(elementButton);
        elementButton.onClick(() -> currentImage = elementImages);
    }
}
