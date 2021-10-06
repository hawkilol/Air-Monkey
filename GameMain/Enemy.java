package com.GameMain;

import java.awt.*;
import java.util.Random;
//Inimigo que herda de GameObject
public class Enemy extends GameObject {
    Random r = new Random();
    private int width = 16;
    private int height = 16;

    public Enemy(int x, int y, ID id){
        super(x, y, id);
        velX = r.nextInt(7);
        velY = r.nextInt(7);
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
        Graphics2D g2d = (Graphics2D) g;
        g.setColor(Color.red);
        g2d.draw(getBounds());
        //g.setColor(Color.red);
        //g.fill3DRect(x, y, width, height, true);
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getHeight() {
        return height;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getWidth() {
        return width;
    }
}