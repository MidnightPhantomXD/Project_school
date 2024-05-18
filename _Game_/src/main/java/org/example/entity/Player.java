package org.example.entity;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Player extends Entity{
        private int damage;
        public BufferedImage down1, down2, down3, up1, up2, up3, left1, left2, left3, right1, right2, right3;
        public String direction;

        public Player(int x, int y, String url) {
                super(x, y, url);
                this.damage = 5;
                direction = "down";
                getPlayerImage();
        }

        public void getPlayerImage(){
                try{
                        down1 = ImageIO.read(getClass().getResourceAsStream("/player/Back1.png"));
                        down2 = ImageIO.read(getClass().getResourceAsStream("/player/Back2.png"));
                        down3 = ImageIO.read(getClass().getResourceAsStream("/player/Back3.png"));
                        up1 = ImageIO.read(getClass().getResourceAsStream("/player/Front1.png"));
                        up2 = ImageIO.read(getClass().getResourceAsStream("/player/Front2.png"));
                        up3 = ImageIO.read(getClass().getResourceAsStream("/player/Front3.png"));
                        left1 = ImageIO.read(getClass().getResourceAsStream("/player/Left.png"));
                        left2 = ImageIO.read(getClass().getResourceAsStream("/player/Left2.png"));
                        left3 = ImageIO.read(getClass().getResourceAsStream("/player/Left3.png"));
                        right1 = ImageIO.read(getClass().getResourceAsStream("/player/Right1.png"));
                        right2 = ImageIO.read(getClass().getResourceAsStream("/player/Right2.png"));
                        right3 = ImageIO.read(getClass().getResourceAsStream("/player/Right3.png"));

                }catch(IOException e){
                        e.printStackTrace();
                }
        }

        public int getWidth() {
                return width;
        }

        public void setWidth(int width) {
                this.width = width;
        }

        public int getHeight() {
                return height;
        }

        public void setHeight(int height) {
                this.height = height;
        }

        public Image getImage() {
                return image;
        }

        public int getDamage() {
                return damage;
        }
        public String getDirection() {
                return direction;
        }
}
