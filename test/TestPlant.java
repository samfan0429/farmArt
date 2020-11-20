import edu.macalester.comp127.FarmArt.ElementType;
import edu.macalester.graphics.Image;
import org.junit.Assert;
import org.junit.jupiter.api.Test;


public class TestPlant {

    @Test
    public void testCorn() {
        // ---------------- plants -------------------
        ElementType test;
        Image corn = new Image("corn.png");
        test= new ElementType("corn", corn, "dirt");
        Assert.assertEquals(test.getName(),"corn");
        Assert.assertEquals(test.getType(),"dirt");
    }

    @Test
    public void testCarrot() {
        ElementType test;
        Image carrot = new Image("carrot.png");
        test = new ElementType("carrot", carrot, "dirt");
        Assert.assertEquals(test.getName(), "carrot");
        Assert.assertEquals(test.getType(), "dirt");
    }

    @Test
    public void testTomato() {
        ElementType test;
        Image tomato = new Image("tomato.png");
        test = new ElementType("tomato", tomato, "dirt");
        Assert.assertEquals(test.getName(), "tomato");
        Assert.assertEquals(test.getType(), "dirt");
    }

    @Test
    public void testPumpkin() {
        ElementType test;
        Image pumpkin = new Image("pumpkin.png");
        test = new ElementType("pumpkin", pumpkin, "dirt");
        Assert.assertEquals(test.getName(), "pumpkin");
        Assert.assertEquals(test.getType(), "dirt");
    }

    @Test
    public void testSunflower() {
        ElementType test;
        Image sunflower = new Image("sunflower.png");
        test = new ElementType("sunflower", sunflower, "dirtgrass");
        Assert.assertEquals(test.getName(), "sunflower");
        Assert.assertEquals(test.getType(), "dirtgrass");
    }

    @Test
    public void testLillypad() {
        ElementType test;
        Image lillypad = new Image("lillypad.png");
        test = new ElementType("lillypad", lillypad, "water");
        Assert.assertEquals(test.getName(), "lillypad");
        Assert.assertEquals(test.getType(), "water");
    }

    @Test
    public void testFlower() {
        ElementType test;
        Image flower = new Image("flower.png");
        test = new ElementType("flower", flower, "dirtgrass");
        Assert.assertEquals(test.getName(), "flower");
        Assert.assertEquals(test.getType(), "dirtgrass");
    }

    @Test
    public void testBush() {
        ElementType test;
        Image bush = new Image("bush.png");
        test = new ElementType("bush", bush, "dirtgrass");
        Assert.assertEquals(test.getName(), "bush");
        Assert.assertEquals(test.getType(), "dirtgrass");
    }
}
