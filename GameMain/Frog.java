package com.GameMain;

import java.awt.*;
import java.util.concurrent.ThreadLocalRandom;

public class Frog extends GameObject {
    private int width = 16;
    private int height = 16;
    ThreadLocalRandom rand = ThreadLocalRandom.current();

    public Frog(int x, int y, ID id){
        super(x, y, id);
        velX = rand.nextInt(2 , 7);
        velY = rand.nextInt(2 , 7);
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
       // if(id == ID.Frog){
         //   g.setColor(Color.green);
        //}
        //Graphics2D g2d = (Graphics2D) g;
        g.setColor(Color.green);
        //g2d.draw(getBounds());
        g.fill3DRect(x, y, width, height, true);



    }
}
