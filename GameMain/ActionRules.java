package com.GameMain;

import java.util.HashMap;
import java.util.Map;

public interface ActionRules {
    boolean[] keyPressed = new boolean[5];


    //void execute(int input);
    void execute(int input);

    void setActions(int keyN, ActionRules actionRules);
    //Verifica a colisão entre os GameObjects
    default void collision(Handler handler, HUD hud) {
        for(int i = 0; i < handler.object.size(); i++){
            GameObject tempObject1 = handler.object.get(i);
            //Verifica a Colisão do Jogador com os inimigos
            if(tempObject1.getId() == ID.Player){
                for(int k = 0; k < handler.object.size(); k++){
                    GameObject tempObject = handler.object.get(k);
                    if(tempObject.getId() == ID.Enemy){
                        if(tempObject1.getBounds().intersects(tempObject.getBounds())){
                            hud.setHealth(hud.getHealth() - 5);
                        }
                    }
                }
            }
            //Verifica a Colisão do Ataque com os inimigos
            if(tempObject1.getId() == ID.Attack){
                for(int k = 0; k < handler.object.size(); k++){
                    GameObject tempObject = handler.object.get(k);
                    if(tempObject.getId() == ID.Enemy){
                        if(tempObject1.getBounds().intersects(tempObject.getBounds())){
                            handler.addObject(new Banana(tempObject.getX(),tempObject.getY(), ID.Banana));
                            handler.removeObject(tempObject);
                            handler.removeObject(tempObject1);
                        }
                    }
                }
            }
            //Verifica a Colisão do Jogador com as bananas
            if(tempObject1.getId() == ID.Player){
                for(int k = 0; k < handler.object.size(); k++){
                    GameObject tempObject = handler.object.get(k);
                    if(tempObject.getId() == ID.Banana){
                        if(tempObject1.getBounds().intersects(tempObject.getBounds())){
                            hud.setHealth(hud.getHealth() + 3);
                            hud.setBananas(hud.getBananas() + 10);
                            handler.removeObject(tempObject);
                        }
                    }
                }
            }
        }
    }
}
