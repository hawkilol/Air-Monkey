package com.GameMain;

import java.awt.image.BufferedImage;

public class Sprite {
    private BufferedImage sprite;

    public Sprite(BufferedImage sprite){
        this.sprite = sprite;
    }
    public BufferedImage grabImage(){
        BufferedImage img = sprite;
        return img;

    }
}
