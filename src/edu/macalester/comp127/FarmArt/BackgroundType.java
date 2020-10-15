package edu.macalester.comp127.FarmArt;

import edu.macalester.graphics.GraphicsGroup;
import edu.macalester.graphics.Point;

public interface BackgroundType {
    public String getName();
    public void apply(TileManager tileManager, Point location, GraphicsGroup background);
}
