package edu.macalester.comp127.FarmArt;

/**
 * a background brush that implements brush interface
 */
public class BackgroundBrush implements Brush{
    private final BackgroundType background;

    /**
     * constructor for element brush
     * @param background
     */
    public BackgroundBrush(BackgroundType background) {
        this.background = background;
    }

    @Override
    public void apply(Tile tile) {
        background.apply(tile);
    }
}