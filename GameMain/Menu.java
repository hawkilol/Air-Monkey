package com.GameMain;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
//Menu
public class Menu extends MouseAdapter {
    private HUD hud;
    private boolean settings = false;

    public Menu(HUD hud){
        this.hud = hud;
    }

    //Verifica se o mouse está dentro do perimetro
    private boolean mouseOver(int xM, int yM, int x, int y, int width, int height){
        if(xM > x && xM < x + width && yM > y && yM < y + height){ //Verifica se o mouse esta dentro da caixa de seleção
            return true;
        }
        else{
            return false;
        }
    }

    //Ativa quando o botão esquerdo e apertado
    public void mousePressed(MouseEvent e) {
        //Pega a posição no quando o mouse for apertado
        int xM = e.getX();
        int yM = e.getY();
        //Seleciona um dos campos do menu pela posição do mouse
        if(Game.gameState == Game.STATE.Menu){
            //Inicia o jogo
            if(mouseOver(xM, yM, Game.getWIDTH()/2 - 85, Game.getHEIGHT()/2 - 37, 200, 64)){
                Game.gameState = Game.STATE.Game;
                //Reinicia depois da primeira partida
                if(Game.running = true){
                    try {
                        Game.running = false;
                        new Game();
                        Game.gameState = Game.STATE.Game;
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
            }
            //Info dos controles
            if(mouseOver(xM, yM, Game.getWIDTH()/2 - 85, Game.getHEIGHT()/2+ 100 - 37, 200, 64)){
                if(settings){
                    settings = false;
                }else{
                    settings = true;
                }
            }
            //Sair
            if(mouseOver(xM, yM, Game.getWIDTH()/2 - 85, Game.getHEIGHT()/2+ 200 - 37, 200, 64)){
                System.exit(1);
            }
        }
        //Seleciona um dos campos do FailScreen pela posição do mouse
        if(Game.gameState == Game.STATE.FailScreen){
            //Reinicia o jogo
            if(mouseOver(xM, yM, Game.getWIDTH()/2 - 85, Game.getHEIGHT()/2 - 37, 200, 64)){
                Game.gameState = Game.STATE.Game;
                try {
                    Game.running = false;
                    new Game();
                    Game.gameState = Game.STATE.Game;
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
            //Voltar para o menu
            if(mouseOver(xM, yM, Game.getWIDTH()/2 - 85, Game.getHEIGHT()/2+ 100 - 37, 200, 64)){
                Game.gameState = Game.STATE.Menu;
            }
            //Sai do jogo
            if(mouseOver(xM, yM, Game.getWIDTH()/2 - 85, Game.getHEIGHT()/2+ 200 - 37, 200, 64)){
                System.exit(1);
            }
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        super.mouseReleased(e);
    }

    public void tick(){

    }
    //Renderiza o menu de acordo com o estado do jogo
    public void render(Graphics g){
        if(Game.gameState == Game.STATE.Menu){
            g.setColor(Color.yellow);
            g.drawRoundRect(Game.getWIDTH()/2 - 85, Game.getHEIGHT()/2 - 37, 200, 64, 15, 15);

            g.drawString("Start", Game.getWIDTH()/2, Game.getHEIGHT()/2);

            if(settings){
                g.setColor(Color.lightGray);
                g.drawString("W A S D to Move and SPACE to Shoot Enemies,", Game.getWIDTH()/2 - 85 , Game.getHEIGHT()/2 + 100);
                g.drawString("Enemies drop Bananas, Collect Bananas to score more points!", Game.getWIDTH()/2 - 85 , Game.getHEIGHT()/2 + 120);


            }else{
                g.setColor(Color.lightGray);
                g.drawRoundRect(Game.getWIDTH()/2 - 85, Game.getHEIGHT()/2+ 100 - 37, 200, 64, 15, 15);
                g.drawString("Guide", Game.getWIDTH()/2 , Game.getHEIGHT()/2 + 100);

            }
            g.setColor(Color.red);
            g.drawRoundRect(Game.getWIDTH()/2 - 85, Game.getHEIGHT()/2+ 200 - 37, 200, 64, 15, 15);
            g.drawString("Give Up", Game.getWIDTH()/2 , Game.getHEIGHT()/2 + 200);
        }

        else if(Game.gameState == Game.STATE.FailScreen){
            g.setColor(Color.yellow);
            g.drawString("Bananas Collected: " + hud.getBananas(), Game.getWIDTH()/2 - 50, Game.getHEIGHT()/2 - 200);

            g.setColor(Color.green);
            g.drawRoundRect(Game.getWIDTH()/2 - 85, Game.getHEIGHT()/2 - 37, 200, 64, 15, 15);
            g.drawString("Try Again", Game.getWIDTH()/2 - 5, Game.getHEIGHT()/2);

            g.setColor(Color.lightGray);
            g.drawRoundRect(Game.getWIDTH()/2 - 85, Game.getHEIGHT()/2+ 100 - 37, 200, 64, 15, 15);
            g.drawString("Menu", Game.getWIDTH()/2 , Game.getHEIGHT()/2 + 100);

            g.setColor(Color.red);
            g.drawRoundRect(Game.getWIDTH()/2 - 85, Game.getHEIGHT()/2+ 200 - 37, 200, 64, 15, 15);
            g.drawString("Give Up", Game.getWIDTH()/2 , Game.getHEIGHT()/2 + 200);

        }
    }
}
