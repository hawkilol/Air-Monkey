package com.GameMain;

import java.awt.*;

//Classe que forma os objetos herdeiros
//Possui coordenadas x, y, id, e velocidade velX e velY
public abstract class GameObject {
    protected int x;
    protected int y;
    protected ID id;
    protected int velX;
    protected int velY;

    public GameObject(int x, int y, ID id){
        this.x = x;
        this.y = y;
        this.id = id;

    }

    public GameObject(){
    }
    //Representa as fronteiras do objeto que vai ter colisão com outras fronteiras
    public abstract Rectangle getBounds();

    //Tick o qual contem as ações do objeto a cada tick que é rodado na classe game
    public abstract void tick();

    //Render que é chamado na classe game para renderizar o objeto
    public abstract void render(Graphics g);

    public void setX(int x) {
        this.x = x;
    }

    public int getX() {
        return x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getY() {
        return y;
    }

    public void setId(ID id) {
        this.id = id;
    }

    public ID getId() {
        return id;
    }

    public void setVelX(int velX) {
        this.velX = velX;
    }

    public int getVelX() {
        return velX;
    }

    public void setVelY(int velY) {
        this.velY = velY;
    }

    public int getVelY() {
        return velY;
    }
}
