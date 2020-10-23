package edu.macalester.comp127.FarmArt;

import java.util.List;

import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.Rectangle;
import edu.macalester.graphics.ui.Button;
 
/**
 * Represent a menu on the canvas with zoom in/out button, drag button, element button, and background button
 * To allow users modifier their farm
 */
public class Menu {

   private Brush currentBrush;
   private Rectangle buttonIndicator;
   private Boolean dragging = false;
 
   /**
    * Create a menu with its mouse drag and mouse drag 
    * @param canvas
    * @param tileManager
    * @param buttonIndicator
    */
    public Menu(CanvasWindow canvas, 
                TileManager tileManager, 
                Rectangle buttonIndicator, 
                List<BackgroundType> backgroundsList, 
                List<ElementType> elementsList) {
        this.buttonIndicator = buttonIndicator;
        addZoomButtons(canvas, tileManager);
        addDragButton(canvas);
        orderBackgroundButtons(canvas, backgroundsList);
        orderElementButtons(canvas, elementsList);


        canvas.onMouseDown(event -> {
            if (!dragging) {
                Tile tile = tileManager.findTileAt(event.getPosition());
                if (tile != null && currentBrush != null) {
                    currentBrush.apply(tile);
                }
            }
        });

        canvas.onDrag(event -> {
            if (dragging) {
                double actionX = event.getDelta().getX();
                double actionY = event.getDelta().getY();
                tileManager.dragGraphics(actionX, actionY);
            }
        });
   }
 
   /**
    * Add background button to the canvas with onClick animation
    * @param canvas
    * @param background
    * @param y
    */
   private void addBackgroundButton(CanvasWindow canvas, BackgroundType background, double y) {
       Button backgroundButton = new Button(background.getName());
       backgroundButton.setPosition(120, y);
       canvas.add(backgroundButton);
       backgroundButton.onClick(() -> {
           dragging = false;
           currentBrush = new BackgroundBrush(background);
           showSelectedButton(backgroundButton);
       });
   }
 
   /**
    * Add element button to the canvas with onClick animation
    * @param canvas
    * @param elementType
    * @param y
    */
   private void addElementButton(CanvasWindow canvas, ElementType elementType, double y) {
       Button elementButton = new Button(elementType.getName());
       elementButton.setPosition(120, y);
       canvas.add(elementButton);
       elementButton.onClick(() -> {
           dragging = false;
           currentBrush = new ElementBrush(elementType);
           showSelectedButton(elementButton);
       });
   }
 
   /**
    * Add drag button to the canvas with onClick animation
    * @param canvas
    */
   private void addDragButton(CanvasWindow canvas) {
       Button drag = new Button("drag");
       drag.setPosition(70, 60);
       canvas.add(drag);
       drag.onClick(() -> {
           dragging = true;
           showSelectedButton(drag);}
        );
    }
 
    /**
     * Add zoom in, zoom out, and standard button to the canvas with onClick animation
     * @param canvas
     * @param tileManager
     */
   private void addZoomButtons(CanvasWindow canvas, TileManager tileManager) {
       Button zoomIn = new Button("+");
       Button zoomOut = new Button("-");
       Button standard = new Button("standard");
       zoomIn.setPosition(0, 30);
       zoomOut.setPosition(70, 30);
       standard.setPosition(140, 30);
       canvas.add(zoomIn);
       canvas.add(zoomOut);
       canvas.add(standard);
       zoomIn.onClick(() -> tileManager.scaleUp());
       zoomOut.onClick(() -> tileManager.scaleDown());
       standard.onClick(() -> tileManager.scaleNormal());
   }

    /**
    * Set the buttonIndicator to the current selected button
    * @param button 
    */
    private void showSelectedButton(Button button) {
        buttonIndicator.setPosition(button.getPosition());
        buttonIndicator.setSize(button.getSize());
    }

    public void orderBackgroundButtons(CanvasWindow canvas, List<BackgroundType> backgroundsList) {
        double buttonY = 60;
        for (BackgroundType background : backgroundsList) {
            buttonY += 30;
            addBackgroundButton(canvas, background, buttonY);
        }


    }

    public void orderElementButtons(CanvasWindow canvas, List<ElementType> elementsList){
        double buttonY = 180;
        for (ElementType image : elementsList) {
            buttonY += 30;
            addElementButton(canvas, image, buttonY);   
        }   
    }
}
