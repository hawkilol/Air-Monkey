package com.GameMain;

import java.awt.*;

//Ataque atirado pelo Player
public class Attack extends GameObject {
    private int width = 10;
    private int height = 40;
    public Attack(int x, int y, ID id){
        super(x, y, id);
        velY -= 10;
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
        g.setColor(Color.red);
        g.fill3DRect(x, y, width, height, true);
    }
}
