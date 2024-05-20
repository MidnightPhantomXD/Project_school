package org.example;

import org.example.entity.Entity;
import org.example.entity.Player;
import org.example.tile.Tile;
import org.example.tile.TileCheck;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;

public class Graphics extends JFrame{
    public final int tileSize = 48; //default tile
    public final int tileFin = tileSize * 2;
    public final int maxScreenCol = 16; //how many tiles is a screen
    public final int maxScreenRow = 12; //how many tiles is a screen
    public final int screenWidth = tileSize * maxScreenCol;
    public final int screenHeight = tileSize * maxScreenRow;

    public final int maxWorldCol = 50;
    public final int maxWorldRow = 50;

    Draw draw;
    Logic logic;
    Player player;
    TileCheck tileCheck;
    Tile[] tile;
    public Graphics(Logic logic) throws HeadlessException {

        this.draw = new Draw();
        add(draw);
        this.logic = logic;
        this.tileCheck = new TileCheck(this);
        this.tile = tileCheck.tile;
        this.player = logic.getPlayer();


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

            int col = 0;
            int row = 0;
            int x = 0;
            int y = 0;


            while (col < maxScreenCol && row < maxScreenRow){

                int tileNum = tileCheck.mapTileNum[col][row];

                g2.drawImage(tile[tileNum].image, x, y, tileFin, tileFin, null);
                col++;
                x += tileFin;

                if (col == maxScreenCol){
                    col = 0;
                    x = 0;
                    row++;
                    y += tileFin;
                }
            }


            BufferedImage image = null;

            switch(player.direction){
                case "up":
                    if (player.spriteNum == 1){
                        image = player.up2;
                    }
                    if (player.spriteNum == 2){
                        image = player.up1;
                    }
                    if (player.spriteNum == 3){
                        image = player.up3;
                    }
                    if (player.spriteNum == 4){
                        image = player.up1;
                    }
                    break;
                case "down":
                    if (player.spriteNum == 1){
                        image = player.down2;
                    }
                    if (player.spriteNum == 2){
                        image = player.down1;
                    }
                    if (player.spriteNum == 3){
                        image = player.down3;
                    }
                    if (player.spriteNum == 4){
                        image = player.down1;
                    }
                    break;
                case "left":
                    if (player.spriteNum == 1){
                        image = player.left2;
                    }
                    if (player.spriteNum == 2){
                        image = player.left1;
                    }
                    if (player.spriteNum == 3){
                        image = player.left3;
                    }
                    if (player.spriteNum == 4){
                        image = player.left1;
                    }
                    break;
                case "right":
                    if (player.spriteNum == 1){
                        image = player.right2;
                    }
                    if (player.spriteNum == 2){
                        image = player.right1;
                    }
                    if (player.spriteNum == 3){
                        image = player.right3;
                    }
                    if (player.spriteNum == 4){
                        image = player.right1;
                    }
                    break;
            }
            g2.drawImage(image, player.getCoord().x, player.getCoord().y, tileFin, tileFin, null);


            g2.dispose();





        }
    }
}
