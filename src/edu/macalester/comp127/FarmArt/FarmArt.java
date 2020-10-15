package edu.macalester.comp127.FarmArt;

import java.util.List;
import java.awt.Color;
import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.GraphicsGroup;
import edu.macalester.graphics.Point;
import edu.macalester.graphics.ui.Button;

public class FarmArt {
    private CanvasWindow canvas;
    private BackgroundType currentBackground;
    private List<BackgroundType> backgroundsList;
    private double y;

    public FarmArt() {
        canvas = new CanvasWindow("Farm Art!", 2400, 800);

        backgroundsList = List.of(new BackgroundType("dirt", new Color(102, 51, 0), new Color(153, 102, 0)),
                                  new BackgroundType("water", new Color(51, 204, 255), new Color(51, 153, 255)),
                                  new BackgroundType("path", new Color(153, 153, 153), new Color(204, 204,204)));

        currentBackground = new BackgroundType("path", new Color(153, 153, 153), new Color(204, 204,204));

        y = 0;
        for (BackgroundType background : backgroundsList) {
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
        TileManager tileManager = new TileManager();
        tileManager.generateGrid(farmGraphics);
        canvas.add(farmGraphics);

        canvas.onMouseDown(event ->         
            fill(event.getPosition(), tileManager, farmGraphics)
        );
        addBackgroundButton(currentBackground, y);
    }

    public void fill(Point location, TileManager tileManager, GraphicsGroup background) {
        currentBackground.apply(tileManager, location);
    }
    
    private void addBackgroundButton(BackgroundType background, double y) {
        Button backgroundButton = new Button(background.getName());
        backgroundButton.setPosition(120, y);
        canvas.add(backgroundButton);
        backgroundButton.onClick(() -> currentBackground = background);
    }
}


// int rBrown = randomInt(100, 120);    20
// int gBrown = randomInt(50, 70); 
// Color brown = new Color(rBrown, gBrown, 0);

// int rgbGrey = randomInt(100, 200); 100
// Color grey = new Color(rgbGrey, rgbGrey, rgbGrey);

// int gBlue = randomInt(153, 204);
// Color blue = new Color(51, gBlue, 255);

