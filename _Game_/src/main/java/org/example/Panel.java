package org.example;

import javax.swing.*;
import java.awt.event.*;

public class Panel extends Thread implements Runnable{
    Graphics graphic;
    Logic logic;
    Thread thread;
    int FPS = 60;
    public boolean upPressed, downPressed, leftPressed, rightPressed, ePressed, mouseClick;

    public Panel() {
        logic = new Logic(this);
        graphic = new Graphics(logic);
        logic.setGraphics(graphic);
        graphic.setFocusable(true);
        logic.initialize();

        graphic.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                int code = e.getKeyCode();
                if (code == KeyEvent.VK_W){
                    upPressed = true;
                }
                if (code == KeyEvent.VK_S){
                    downPressed = true;
                }
                if (code == KeyEvent.VK_A){
                    leftPressed = true;
                }
                if (code == KeyEvent.VK_D){
                    rightPressed = true;
                }
                if (code == KeyEvent.VK_E){
                    ePressed = true;
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                int code = e.getKeyCode();
                if (code == KeyEvent.VK_W){
                    upPressed = false;
                }
                else if (code == KeyEvent.VK_S){
                    downPressed = false;
                }
                else if (code == KeyEvent.VK_A){
                    leftPressed = false;
                }
                else if (code == KeyEvent.VK_D){
                    rightPressed = false;
                }
                if (code == KeyEvent.VK_E){
                    ePressed = false;
                }
            }
        });

        graphic.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

    }
    public void startGameThread() {
        thread = new Thread(this);
        thread.start();
    }
    public void run() {
        double drawInterval = 1000000000/FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;
        long timer = 0;
        int drawCount = 0;

        while (thread != null){

            currentTime = System.nanoTime();
            delta += (currentTime - lastTime) / drawInterval;
            timer += (currentTime - lastTime);
            lastTime = currentTime;

            if (delta >= 1){
                logic.update();
                graphic.render(logic);
                delta--;
                drawCount++;
            }
            if (timer>= 1000000000){
                System.out.println("FPS:" + drawCount);
                drawCount = 0;
                timer = 0;
            }
        }
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Panel panel = new Panel();
            panel.startGameThread();

        });
    }

}
