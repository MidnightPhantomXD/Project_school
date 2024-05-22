package org.example;

import org.example.entity.Player;
import org.example.entity.Weapon;
import org.example.tile.Tile;
import org.example.tile.TileCheck;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;

public class GameGraphics extends JFrame{
    public final int defTileSize = 48; //default tile
    public final int tileFin = defTileSize * 2;
    public final int maxScreenCol = 12; //how many tiles is a screen
    public final int maxScreenRow = 16; //how many tiles is a screen
    public final int screenWidth = (tileFin * maxScreenRow) / 2 + 312;
    public final int screenHeight = (tileFin * maxScreenCol) / 2 + 144;

    public final int maxWorldCol = 50;
    public final int maxWorldRow = 50;
    //private JFrame frame;

    Draw draw;
    Logic logic;
    TileCheck tileCheck;
    Tile[] tile;
    public GameGraphics(Logic logic) throws HeadlessException {

        this.logic = logic;
        this.tileCheck = new TileCheck(this);
        this.tile = tileCheck.tile;

        this.draw = new Draw();
        add(draw);




        setSize(screenWidth, screenHeight);
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
            Player player = logic.getPlayer();

            int worldRow = 0;
            int worldCol = 0;

            while(worldCol < maxWorldCol && worldRow  < maxWorldRow){

                int tileNum = tileCheck.mapTileNum[worldRow][worldCol];

                int worldX = worldRow * tileFin;
                int worldY = worldCol * tileFin;
                int screenX = worldX - player.getCoord().x + player.screenX;
                int screenY = worldY - player.getCoord().y + player.screenY;

                if (worldX + tileFin > player.getCoord().x - player.screenX &&
                        worldX - tileFin < player.getCoord().x + player.screenX &&
                        worldY + tileFin > player.getCoord().y - player.screenY &&
                        worldY - tileFin < player.getCoord().y + player.screenY){

                    g2.drawImage(tile[tileNum].image, screenX, screenY, tileFin, tileFin, null);
                }
                worldRow++;

                if (worldRow == maxWorldRow){
                    worldRow = 0;
                    worldCol ++;

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
            g2.drawImage(image, player.screenX, player.screenY, tileFin, tileFin, null);




            g2.dispose();





        }
    }
}
