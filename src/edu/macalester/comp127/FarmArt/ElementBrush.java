package edu.macalester.comp127.FarmArt;

public class ElementBrush implements Brush{
    private final ElementType elementType;

    public ElementBrush(ElementType elementType) {
        this.elementType = elementType;
    }

    @Override
    public void apply(Tile tile) {
        elementType.selectImage(tile);
    }
}
