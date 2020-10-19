package edu.macalester.comp127.FarmArt;

public class BackgroundBrush implements Brush{
    private final BackgroundType background;

    public BackgroundBrush(BackgroundType background) {
        this.background = background;
    }

    @Override
    public void apply(Tile tile) {
        background.apply(tile);
    }
}
