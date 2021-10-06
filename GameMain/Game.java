package com.GameMain;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Game extends Canvas implements Runnable , ActionRules {
    private static int WIDTH = 1280;
    private static int HEIGHT = WIDTH / 12 * 9;

    private Thread thread;
    public static  boolean running = false;
    private Handler handler;
    private HUD hud;
    private ObjectBuilder objectBuilder;
    public static BufferedImage spriteSheet;
    private Menu menu;
    //Estados do jogo
    public enum STATE {
        Menu,
        Game,
        FailScreen;
    }
    //Define que o jogo começa no menu
    public static STATE gameState = STATE.Menu;

    public Game() throws IOException {
        handler = new Handler();
        hud = new HUD();
        menu = new Menu(hud);

        this.addKeyListener(new Input(handler));
        this.addMouseListener(menu);
        new Window(WIDTH, HEIGHT, "Air Monkey", this);

        BufferedImageLoader loader = new BufferedImageLoader();
        objectBuilder = new ObjectBuilder(handler, hud);
        spriteSheet = loader.loadImage("res/SpriteSheet02.png");

        handler.addObject(new Player(WIDTH/2-32, HEIGHT/2-32, ID.Player));
    }

    public synchronized void start(){
        thread = new Thread(this);
        thread.start();
        running = true;
    }
    public synchronized void stop(){
        try{
            thread.join();
            running = false;
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
    private void render() {
        BufferStrategy bs = this.getBufferStrategy();
        if(bs == null){
            this.createBufferStrategy(3); // Buffer 1?
            return;
        }
        Graphics g = bs.getDrawGraphics();
        g.setColor(Color.black);
        g.fillRect(0,0, WIDTH, HEIGHT);

        if(gameState == STATE.Game){
            handler.render(g);
            hud.render(g);

        }else if(gameState == STATE.Menu || gameState == STATE.FailScreen){
            menu.render(g);
        }
        g.dispose();
        bs.show();
    }

    private void tick() {

        if(gameState == STATE.Game){
            handler.tick();
            hud.tick();
            objectBuilder.tick();
            collision(handler, hud);
        }else if(gameState == STATE.Menu || gameState == STATE.FailScreen){
            menu.tick();
        }
    }

    @Override
    public void run() {
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int frames = 0;
        while(running){
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            while(delta >= 1){
                tick();
                delta--;
            }
            if(running)
                render();
            frames++;

            if(System.currentTimeMillis() - timer > 1000){
                timer += 1000;
                //System.out.println("FPS: "+ frames);
                frames = 0;
            }
        }
        stop();
    }

    @Override
    public void execute(int input) {

    }

    @Override
    public void setActions(int keyN, ActionRules actionRules) {

    }

    @Override
    public void collision(Handler handler, HUD hud) {
        ActionRules.super.collision(handler, hud);
    }

    public static int limit(int var, int min, int max){
        if(var >= max)
            return var = max;
        else if(var <= min)
            return var = min;
        else return var;


    }

    public static int getWIDTH() {
        return WIDTH;
    }

    public static int getHEIGHT() {
        return HEIGHT;
    }



    public static void main(String[] args) throws IOException {
        new Game();
    }


}
