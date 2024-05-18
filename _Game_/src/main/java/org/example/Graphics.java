package org.example;

import org.example.entity.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;

public class Graphics extends JFrame{
    public final int tileSize = 48; //default tile
    public final int maxScreenCol = 16; //how many tiles is a screen
    public final int maxScreenRow = 12; //how many tiles is a screen
    public final int screenWidth = tileSize * maxScreenCol;
    public final int screenHeight = tileSize * maxScreenRow;

    public final int maxWorldCol = 50;
    public final int maxWorldRow = 50;

    Draw draw;
    Logic logic;
    public Graphics(Logic logic) throws HeadlessException {

        this.draw = new Draw();
        add(draw);
        this.logic = logic;

        setSize(1080, 720);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setTitle("Box job");

    }
    public void render(Logic logic) {
        this.logic = logic;
        repaint();
    }

    public class Draw extends JPanel {
        @Override
        protected void paintComponent(java.awt.Graphics g) {
            super.paintComponent(g);
            setBackground(Color.black);

            Graphics2D g2 = (Graphics2D)g;
            Player player = logic.player;

            BufferedImage image = null;

            switch (player.direction){
                case "up":
                    image = player.up1;
                    break;
                case "down":
                    image = player.down1;
                    break;
                case "left":
                    image = player.left1;
                    break;
                case "right":
                    image = player.right1;
                    break;
            }
            g2.drawImage(image, player.getCoord().x, player.getCoord().y, tileSize, tileSize, null);

            g2.dispose();





        }
    }
}
