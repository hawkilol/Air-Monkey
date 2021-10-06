package com.GameMain;

import java.awt.*;
import java.awt.image.BufferedImage;
//
public class Player extends GameObject implements ActionRules {
    private int width = 32;
    private int height = 32;
    private BufferedImage img;

    public Player(int x, int y, ID id){
        super(x, y, id);
        Sprite spriteSheet = new Sprite(Game.spriteSheet);
        this.img = spriteSheet.grabImage();
        this.img = img.getSubimage(187, 4, width+3, height+3);

    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle(x, y, width, height);
    }

    //Soma a velocidade a cada Tick ao X e Y para movimentar o Player
    @Override
    public void tick() {
        x += velX;
        y += velY;
        //Limita o X e Y dentro das fronteiras Game
        x = Game.limit(x, 0, Game.getWIDTH()- 48);
        y = Game.limit(y, 0, Game.getHEIGHT()- 69);
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(img, x, y, null);
    }
    public void moveUp(){
        setY(-5);
    }

    public void moveDown(){
        setVelY(+5);
    }

    public void moveLeft(){
        setVelX(-5);
    }

    public void moveRight(){
        setVelX(+5);
    }

    public void attack(){
        new Attack(getX(), getY(), ID.Attack);
        //handler.addObject(new Attack(tempObject.getX(), tempObject.getY(), ID.Attack)
    }


    @Override
    public void execute(int input) {

    }

    @Override
    public void setActions(int keyN, ActionRules actionRules) {

    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getWidth() {
        return width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getHeight() {
        return height;
    }
}
