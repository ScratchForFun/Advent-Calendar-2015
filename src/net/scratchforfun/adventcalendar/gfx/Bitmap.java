package net.scratchforfun.adventcalendar.gfx;

import net.scratchforfun.adventcalendar.start.Main;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * Created by Magnus on 10/15/2015.
 */
public class Bitmap {

    public static Bitmap BACKGROUND = getBitmap("/background.png");

    private int[] pixels;
    private int width, height;

    private Bitmap(int width, int height) {
        this.width = width;
        this.height = height;
        this.pixels = new int[width * height];
    }

    public static Bitmap getBitmap(String path) {
        try {
            BufferedImage image = ImageIO.read(Main.class.getResourceAsStream(path));
            Bitmap bitmap = new Bitmap(image.getWidth(), image.getHeight());

            image.getRGB(0, 0, bitmap.width, bitmap.height, bitmap.pixels, 0, bitmap.width);
            return bitmap;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

}
