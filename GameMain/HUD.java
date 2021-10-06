package com.GameMain;

import java.awt.*;
import java.awt.image.BufferedImage;

//Display e controle de informações para o jogador
public class HUD {
    private int health = 172;
    private int bar = 255;
    private int bananas = 0;
    private BufferedImage img;

    public HUD (){

    }
    //Cada tick mantem a vida dentro dos limites
    public void tick(){
        health = Game.limit(health, 0, 172);
        //= Game.limit(bar, 0, 255);
        //bar = health*2;

    }
    //Renderiza a HUD
    public void render(Graphics g){
        //Faz um recorte de um dos Sprites do SpriteSheet por coordenada
        Sprite spriteSheet = new Sprite(Game.spriteSheet);
        img = spriteSheet.grabImage();
        if(img != null){
            img = img.getSubimage(1, 1, 170, 160);

        }
        //Construi a barra de vida
        g.setColor(Color.lightGray);
        //g.fillRoundRect(14, 14, 182, 22, 10, 10);
        g.fillRoundRect(14, Game.getHEIGHT() - 100, 182, 22, 10, 10);
        //Leva o jogador a tela de fim com a pontuação quando a vida chega a zero(perde o jogo)
        if(health <= 0){
            Game.gameState = Game.STATE.FailScreen;
            g.setColor(new Color(75, 10, 50));

        }
        else{
            g.setColor(new Color(75, health, 10));
        }

        g.fillRoundRect(17, Game.getHEIGHT() - 99, health , 20, 7, 7);
        //Mostra informações como a quantidade de bananas
        g.setColor(Color.yellow);
        g.drawString("Bananas: " + bananas, 20, Game.getHEIGHT() - 300);

        g.drawImage(img, 15, Game.getHEIGHT() - 280, null);
    }
    public void setHealth(int health) {
        this.health = health;
    }

    public int getHealth() {
        return health;
    }

    public void setBananas(int bananas) {
        this.bananas = bananas;
    }

    public int getBananas() {
        return bananas;
    }

    public void setBar(int bar) {
        this.bar = bar;
    }

    public int getBar() {
        return bar;
    }

}
