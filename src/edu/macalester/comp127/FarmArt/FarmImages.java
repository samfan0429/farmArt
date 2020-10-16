package edu.macalester.comp127.FarmArt;

import java.util.ArrayList;
import java.util.List;

import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.GraphicsGroup;
import edu.macalester.graphics.Image;
import edu.macalester.graphics.Point;

public class FarmImages {
    

    // private GraphicsGroup graphicsGroup = new GraphicsGroup();
    //private List<Image> listImage = new ArrayList<>();

    // private String name;
    // private Image image;
    
    
    // public FarmImages(String name, Image image) {
    //     this.name = name;
    //     this.image = image;
    //     fillImagesList();
    //     // this.image = getImage(image);
        
    // }

    public void fillImagesList(CanvasWindow canvasWindow) {
        Image cabbage = new Image(100, 200, "farmElements/farmVegetable/cabbage.png");
        canvasWindow.add(cabbage);
        //listImage.add(cabbage);
        Image carrot = new Image(100, 250, "farmElements/farmVegetable/carrot.png");
        canvasWindow.add(carrot);
        //listImage.add(carrot);
        Image cauliflower = new Image(100, 300, "farmElements/farmVegetable/cauliflower.png");
        canvasWindow.add(cauliflower);
        //listImage.add(cauliflower);
        Image corn = new Image(100, 350, "farmElements/farmVegetable/corn.png");
        canvasWindow.add(corn);
        //listImage.add(corn);
        Image pumpkin = new Image(100, 400, "farmElements/farmVegetable/pumpkin.png");
        canvasWindow.add(pumpkin);
        //listImage.add(pumpkin);
    }

    // public Image getImage(Image name) {
    //     for (Image i : listImage) {
    //         if (i == name) {
    //             return i;
    //         }
    //     }
    //     return null;
    // }


    // public void addImage (Point location, Image image, GraphicsGroup farmGraphics, TileManager tileManager) {
    //     for (Tile tile: tileManager.getTiles())
    //         if (tile.testHit(location.getX(), location.getY())) {
    //             farmGraphics.add(image);
    //         }
    // }

    // public List<Image> getList() {
    //     fillImagesList();
    //     return listImage;
    // }
    
}
