package com.GameMain;

import java.awt.*;
import java.util.concurrent.ThreadLocalRandom;

public class StrongFrog extends Enemy {
    private int width = 32;
    private int height = 32;
    ThreadLocalRandom rand = ThreadLocalRandom.current();

    public StrongFrog(int x, int y, ID id){
        super(x, y, id);
        velX = rand.nextInt(1 , 5);
        velY = rand.nextInt(1 , 5);
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle(x, y, width, height);
    }



    @Override
    public void tick() {
        x += velX;
        y += velY;
        //Limita o x e y as fronteiras do Game invertendo a velocidade, fazendo o objeto rebater na parede
        if(y <= 0 || y>= Game.getHEIGHT() - 69){
            velY *= -1;
        }
        if(x <= 0 || x>= Game.getWIDTH() - 48){
            velX *= -1;
        }
    }

    @Override
    public void render(Graphics g) {

        g.setColor(Color.RED);
        g.fill3DRect(x, y, width, height, true);



    }
}
