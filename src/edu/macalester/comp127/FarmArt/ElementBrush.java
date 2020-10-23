package edu.macalester.comp127.FarmArt;

/**
 * A elementBrush that implements brush interface
 */
public class ElementBrush implements Brush{
    
    private final ElementType elementType;

    /**
     * A constructor of elementBrush
     * @param elementType
     */
    public ElementBrush(ElementType elementType) {
        this.elementType = elementType;
    }

    @Override
    public void apply(Tile tile) {
        elementType.selectImage(tile);
    }
}