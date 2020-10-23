package edu.macalester.comp127.FarmArt;

import java.util.List;
import java.awt.Color;
import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.GraphicsGroup;
import edu.macalester.graphics.Rectangle;


public class FarmArt {
    private static CanvasWindow canvas;
    private List<BackgroundType> backgroundsList;
    private List<ElementType> elementImages;
    private TileManager tileManager;
    private ElementManager elementManager = new ElementManager();
    private Menu menu;
    private GraphicsGroup backdrop;
    private Rectangle rectangle;
    private Rectangle selectedButtonIndicator;

    public FarmArt() {
        canvas = new CanvasWindow("Farm Art!", 2400, 800);
        canvas.setBackground(Color.black);
        tileManager = new TileManager();
        selectedButtonIndicator = new Rectangle(-50, -50, 40, 20);
        menu = new Menu(canvas, tileManager, selectedButtonIndicator);
    }

    public static void main(String[] args) {
        FarmArt farmArt = new FarmArt();
        farmArt.run();
    }

    public void run() { 
        backgroundsList = List.of(
            new BackgroundType("eraser", null, null),
            new BackgroundType("dirt", new Color(90, 50, 0), new Color(120, 60, 0)),
            new BackgroundType("water", new Color(40, 150, 245), new Color(100, 180, 245)),
            new BackgroundType("grass", new Color(50, 200, 0), new Color(150, 230, 0)));

        double buttonY = 60;
        for (BackgroundType background : backgroundsList) {
            buttonY += 30;
            menu.addBackgroundButton(canvas, background, buttonY);
        }

        elementImages = elementManager.addImages();
        buttonY = 180;
        for (ElementType image : elementImages) {
            buttonY += 30;
            menu.addElementButton(canvas, image, buttonY);   
        }   

        tileManager.generateGrid();
        canvas.add(tileManager);
        elementManager.generateBlankGrid(tileManager);

        rectangle = new Rectangle(0, 0, 240, 800);
        rectangle.setFillColor(Color.black);
        backdrop = new GraphicsGroup();
        backdrop.add(rectangle);
        canvas.add(backdrop); 


        selectedButtonIndicator.setStroked(false);
        selectedButtonIndicator.setFillColor(Color.blue);
        canvas.add(selectedButtonIndicator);
    }
}
