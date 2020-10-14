package edu.macalester.comp127.FarmArt;

import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.GraphicsGroup;
import edu.macalester.graphics.Point;

public class FarmArt {
    private CanvasWindow canvas;
    private final double CANVAS_WIDTH = 2500;
    private final double CANVAS_HEIGHT = 1000;



    public FarmArt() {
        canvas = new CanvasWindow("Farm Art!", 2400, 800);
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
    }

    public void fill(Point location, TileManager tileManager, GraphicsGroup background) {
        Water.apply(tileManager, location, background);
    }
}







