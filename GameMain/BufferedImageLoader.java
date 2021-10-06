package com.GameMain;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
//Recebe o caminho de um SpriteSheet
public class BufferedImageLoader {
    BufferedImage img = null;

    public BufferedImage loadImage(String path){
        //URL url = this.getClass().getResource("res/img.png");
        try {
            img = ImageIO.read(new File(path));
            return img;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return img;


    }
}
