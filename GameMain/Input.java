package com.GameMain;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.Map;
//Recebe os inputs para controlar a player atraves do KeyListener na classe game
public class Input extends KeyAdapter implements ActionRules {
    //Cooldown para controlar o intervalo entre disparos
    private long cd = 0; //cooldown
    private long cdDelay = 180;
    boolean[] keyPressed = new boolean[5];
    Map<Integer, ActionRules> actions = new HashMap<Integer, ActionRules>();

    private Handler handler;
    //Define o estado das teclas de movimentação para deixa ele mais fluido
    public Input(Handler handler){
        this.handler = handler;
        keyPressed[0] = false;
        keyPressed[1] = false;
        keyPressed[2] = false;
        keyPressed[3] = false;
        keyPressed[4] = false;

    }

    //É chamado quando uma tecla é apertada
    public void keyPressed(KeyEvent k){
        int key = k.getKeyCode();
        long now = System.currentTimeMillis();

        //Ativa os efeitos referentes a determinada tecla para o jogador
        for(int i = 0; i < handler.object.size(); i++){
            GameObject tempObject = handler.object.get(i);
            if(tempObject.getId() == ID.Player){
                if(key == KeyEvent.VK_W){tempObject.setVelY(-5); keyPressed[0] = true;}
                if(key == KeyEvent.VK_S){tempObject.setVelY(+5); keyPressed[1] = true;}
                if(key == KeyEvent.VK_A){tempObject.setVelX(-5); keyPressed[2] = true;}
                if(key == KeyEvent.VK_D){tempObject.setVelX(+5); keyPressed[3] = true;}
                //Ataque com delay entre ataques
                if(key == KeyEvent.VK_SPACE && now - cd > cdDelay){
                    cd = now;
                    handler.addObject(new Attack(tempObject.getX()+12, tempObject.getY()-32, ID.Attack));
                }
            }
            //Sai do jogo
            if(key == KeyEvent.VK_ESCAPE ) {
                System.exit(1);
            }
        }
    }
    //Ativa os efeitos quando as teclas acima são liberadas
    public void keyReleased(KeyEvent k){
        int key = k.getKeyCode();
        for(int i = 0; i < handler.object.size(); i++){
            GameObject tempObject = handler.object.get(i);
            if(tempObject.getId() == ID.Player){
                if(key == KeyEvent.VK_W){keyPressed[0] = false;}
                if(key == KeyEvent.VK_S){keyPressed[1] = false;}
                if(key == KeyEvent.VK_A){keyPressed[2] = false;}
                if(key == KeyEvent.VK_D){keyPressed[3] = false;}

                //Movimento vertical
                if(!keyPressed[0] && !keyPressed[1]){
                    tempObject.setVelY(0);
                }
                //Movimento Horizontal
                if(!keyPressed[2] && !keyPressed[3]){
                    tempObject.setVelX(0);
                }
            }
        }
    }

    @Override
    public void execute(int input) {
    }

    @Override
    public void setActions(int keyN, ActionRules actionRules) {

    }
}
