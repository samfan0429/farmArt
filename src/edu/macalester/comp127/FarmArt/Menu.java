package edu.macalester.comp127.FarmArt;
 
import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.Rectangle;
import edu.macalester.graphics.ui.Button;
import java.awt.Color;
 
public class Menu {

   private Boolean dragging = false;
   private Brush currentBrush;
   private Rectangle buttonIndicator;
 
   public Menu(CanvasWindow canvas, TileManager tileManager, Rectangle buttonIndicator) {
        this.buttonIndicator = buttonIndicator;
        addZoomButtons(canvas, tileManager);
        addDragButton(canvas);
    

        canvas.onMouseDown(event -> {
            if (!dragging) {
                Tile tile = tileManager.findTileAt(event.getPosition());
                if (tile != null) {
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
 
   public void addBackgroundButton(CanvasWindow canvas, BackgroundType background, double y) {
       Button backgroundButton = new Button(background.getName());
       backgroundButton.setPosition(120, y);
       canvas.add(backgroundButton);
       backgroundButton.onClick(() -> {
           dragging = false;
           currentBrush = new BackgroundBrush(background);
           showSelectedButton(backgroundButton);
       });
   }
 
   private void showSelectedButton(Button button) {
       buttonIndicator.setPosition(button.getPosition());
       buttonIndicator.setSize(button.getSize());
   }
 
   public void addElementButton(CanvasWindow canvas, ElementType elementType, double y) {
       Button elementButton = new Button(elementType.getName());
       elementButton.setPosition(120, y);
       canvas.add(elementButton);
       elementButton.onClick(() -> {
           dragging = false;
           currentBrush = new ElementBrush(elementType);
           showSelectedButton(elementButton);
       });
   }
 
   private void addDragButton(CanvasWindow canvas) {
       Button drag = new Button("drag");
       drag.setPosition(70, 60);
       canvas.add(drag);
       drag.onClick(() -> {
           dragging = true;
           showSelectedButton(drag);}
        );
    }
 
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
}
