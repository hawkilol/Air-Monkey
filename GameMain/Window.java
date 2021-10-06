package com.GameMain;

import javax.swing.*;
import java.awt.*;
//Cria a janela com o largura e altura
public class Window extends Canvas implements Runnable{
    private int width;
    private int height;
    private String title;
    public Window(int width, int height, String title, Game game){
        JFrame frame = new JFrame(title);
        frame.setPreferredSize(new Dimension(width, height));
        frame.setMaximumSize(new Dimension(width, height));
        frame.setMinimumSize(new Dimension(width, height));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.add(game);
        frame.setVisible(true);
        game.start();

    }

    @Override
    public void run() {

    }
}

