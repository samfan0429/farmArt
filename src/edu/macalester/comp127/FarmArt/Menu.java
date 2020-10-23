package edu.macalester.comp127.FarmArt;

import java.util.List;
import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.Image;
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
    * A menu constructor with mouse drag and mouse down lanbdas
    * the menu contains the buttons and controls the dragging and brush applications
    * @param canvas
    * @param tileManager
    * @param buttonIndicator To indicate user of their current chosen button
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
    * @param x  x position of the background button
    * @param y  y position of the background button
    */
   private void addBackgroundButton(CanvasWindow canvas, BackgroundType background, double x, double y) {
       Button backgroundButton = new Button(background.getName());
       backgroundButton.setPosition(x, y);
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
    * @param x x position of element button
    * @param y y position of element button
    */
   private void addElementButton(CanvasWindow canvas, ElementType elementType, double x, double y) {
       Button elementButton = new Button(elementType.getName());
       elementButton.setPosition(x, y);
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

    /**
    * Places the background buttons in the correct positions on the canvas.
    * It also includes the blank element in the ordering to be presented as a background.
    */
    private void orderBackgroundButtons(CanvasWindow canvas, List<BackgroundType> backgroundsList) {
        double buttonY = 80;
        double buttonX = 40;
        int count = 0;
        for (BackgroundType background : backgroundsList) {
            count++;
            buttonY += 30;
            addBackgroundButton(canvas, background, buttonX, buttonY);
            if (count == 2) {
                buttonX += 80;
                buttonY = 80;
            }
        }
        addElementButton(canvas, new ElementType("blank", new Image("blank.png"), "all"), 120, 140);
    }

    /**
    * Orders the element buttons on the canvas, and calls addIcons to add the corresponding images.
    */
    private void orderElementButtons(CanvasWindow canvas, List<ElementType> elementsList){
        double buttonY = 160;
        for (ElementType elementType : elementsList) {
            buttonY += 35;
            addElementButton(canvas, elementType, 120, buttonY);
            addIcons(canvas, 50, buttonY, elementType);  
        }   
    }

    /**
    * Places the images of the element next to the the corresponding element on the canvas.
    */
    private void addIcons(CanvasWindow canvas, double x, double y, ElementType elementType){
        Image icon = new Image(elementType.getName() + ".png");
        canvas.add(icon);
        icon.setPosition(x, y);
        icon.setMaxHeight(30);
        icon.setMaxWidth(30);
    }
}