package com.GameMain;

import java.awt.*;
import java.util.LinkedList;
//Classe que possui a lista de objetos no jogo
public class Handler {
    LinkedList<GameObject> object = new LinkedList<GameObject>();

    //Caça da um dos objetos a cada tick
    public void tick(){
        for(int i = 0; i<object.size(); i++){
            GameObject tempObject = object.get(i);
            tempObject.tick();
        }
    }
    //Renderiza os objetos
    public void render(Graphics g){
        for(int i = 0; i<object.size(); i++){
            GameObject tempObject = object.get(i);
            tempObject.render(g);

        }

    }
    public void addObject(GameObject object){
        this.object.add(object);

    }
    public void removeObject(GameObject object){
        this.object.remove(object);

    }
}
