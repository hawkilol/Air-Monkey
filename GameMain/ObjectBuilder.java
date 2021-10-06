package com.GameMain;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;
//Entrega a lista de objetos do Handler os Objetos Inimigos adicionados com posições aleatorias
public class ObjectBuilder {
    private Handler handler;
    private HUD hud;
    private ArrayList<GameObject> enemies= new ArrayList<GameObject>();
    private long cd = 0;
    private long cdDelay = 1000;
    private int enemyTimer;
    ThreadLocalRandom rand = ThreadLocalRandom.current();

    public ObjectBuilder(Handler handler, HUD hud){
        this.handler = handler;
        this.hud = hud;

    }
    public ObjectBuilder(Handler handler, HUD hud, ArrayList<GameObject> enemies){
        this.handler = handler;
        this.hud = hud;
        this.enemies = enemies;
    }

    public void addEnemies(GameObject enemy){
        enemies.add(enemy);
    }
    //Seleciona um inimigo aleatorio da lista de inimigos
    public GameObject select(){
        //int ranValue = rand.nextInt(((handler.object.size() - 1) + 1) + 1);
        rand = ThreadLocalRandom.current();

        GameObject tempObject = enemies.get(rand.nextInt(0, (enemies.size()-1) + 1));
        return tempObject;
    }
    //Adiciona os inimigos(com delay) a lista de objetos do Handler que vão ser executados
    public void tick(){
        addEnemies(new Frog(rand.nextInt(Game.getWIDTH()/2), rand.nextInt(Game.getHEIGHT()/2), ID.Enemy));
        addEnemies(new Frog(rand.nextInt(Game.getWIDTH()/2), rand.nextInt(Game.getHEIGHT()/2), ID.Enemy));
        addEnemies(new StrongFrog(rand.nextInt(Game.getWIDTH()/2), rand.nextInt(Game.getHEIGHT()/2), ID.Enemy));
        long now = System.currentTimeMillis();
        if(now - cd > cdDelay){
            cd = now;
            handler.addObject(select());
        }
    }


}
