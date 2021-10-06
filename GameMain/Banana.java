package com.GameMain;

import java.awt.*;
//Banana
public class Banana extends GameObject {
    private int width = 10;
    private int height = 10;

    public Banana(int x, int y, ID id){
        super(x, y, id);

        //velY -= 10;
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle(x, y, width, height);
    }


    @Override
    public void tick() {
        x += velX;
        y += velY;

    }

    @Override
    public void render(Graphics g) {

        g.setColor(Color.YELLOW);

        //g.fill3DRect(x, y, 32, 32, true);
        g.fill3DRect(x, y, width, height, true);

    }

}
