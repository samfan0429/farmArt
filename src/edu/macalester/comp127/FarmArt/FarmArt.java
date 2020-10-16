package edu.macalester.comp127.FarmArt;

import java.util.List;
import java.awt.Color;
import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.GraphicsGroup;
import edu.macalester.graphics.Image;
import edu.macalester.graphics.Point;
import edu.macalester.graphics.ui.Button;

public class FarmArt {
    private CanvasWindow canvas;
    private BackgroundType currentBackground;
    private Image currentImage;
    private List<BackgroundType> backgroundsList;
    private List<Image> imageList;
    private FarmImages farmImages;
    private double y;

    public FarmArt() {
        canvas = new CanvasWindow("Farm Art!", 2400, 800);

        backgroundsList = List.of(
        new BackgroundType("dirt", new Color(90, 50, 0), new Color(120, 60, 0)),      
        new BackgroundType("water", new Color(40, 150, 245), new Color(100, 200, 245)),
        new BackgroundType("grass", new Color(50, 200, 0), new Color(150, 230, 0)),
        new BackgroundType("eraser", new Color(255, 255, 255), new Color(255, 255, 255)));

        
        currentBackground = new BackgroundType("eraser", new Color(255, 255, 255), new Color(255, 255, 255));

        y = 0;
        for (BackgroundType background : backgroundsList) {
            y += 30; 
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

        ElementTileManager elementTileManager = new ElementTileManager();
        elementTileManager.generateGrid(farmGraphics);
        canvas.add(farmGraphics);

        canvas.onMouseDown(event ->  {
            fill(event.getPosition(), tileManager, farmGraphics);
            // farmImages.addImage(event.getPosition(), new Image("carrot.png"), farmGraphics,
            //     tileManager);
        });
        addBackgroundButton(currentBackground, y);
        
        farmImages.fillImagesList(canvas);
    }

    public void fill(Point location, TileManager tileManager, GraphicsGroup background) {
        currentBackground.apply(tileManager, location);
    }
    
    private void addBackgroundButton(BackgroundType background, double y) {
        Button backgroundButton = new Button(background.getName());
        backgroundButton.setPosition(100, y);
        canvas.add(backgroundButton);
        backgroundButton.onClick(() -> currentBackground = background);
    }
}