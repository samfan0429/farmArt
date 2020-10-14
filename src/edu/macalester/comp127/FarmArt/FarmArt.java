package edu.macalester.comp127.FarmArt;

import java.util.ArrayList;
import java.util.List;

import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.GraphicsGroup;
import edu.macalester.graphics.Point;
import edu.macalester.graphics.ui.Button;

public class FarmArt {
    private CanvasWindow canvas;
    private Backgrounds currentBackground;
    private List<Backgrounds> backgroundsList;
    private double y;



    public FarmArt() {
        canvas = new CanvasWindow("Farm Art!", 2400, 800);
        backgroundsList = List.of(new Water(), new Dirt(), new Path());
        currentBackground = new Path();

        y = 0;
        for (Backgrounds background : backgroundsList) {
            y += 20; 
            addBackgroundButton(background, y);
        }
    }

    public static void main(String[] args) {
        FarmArt farmArt = new FarmArt();
        farmArt.run();
    }


    public void run() {
        GraphicsGroup farmGraphics = new GraphicsGroup();
        TileManager tileManager = new TileManager(farmGraphics);
        tileManager.generateGrid(farmGraphics);
        canvas.add(farmGraphics);

        canvas.onMouseDown(event ->         
            fill(event.getPosition(), tileManager, farmGraphics)
        );
        addBackgroundButton(currentBackground, y);
    }

    public void fill(Point location, TileManager tileManager, GraphicsGroup background) {
        currentBackground.apply(tileManager, location, background);
    }

    
    
    private void addBackgroundButton(Backgrounds background, double y) {
        Button backgroundButton = new Button(background.getName());
        backgroundButton.setPosition(120, y);
        canvas.add(backgroundButton);
        backgroundButton.onClick(() -> currentBackground = background);
    }
    
}





