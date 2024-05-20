package org.example.entity;

import org.example.Graphics;
import org.example.Logic;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Player extends Entity{
        private final int damage;

        public Player(int x, int y) {
                super(x, y);
                this.damage = 5;


                getPlayerImage();
        }

        public void getPlayerImage(){
                try{
                        up1 = ImageIO.read(getClass().getResourceAsStream("/player/Back1.png"));
                        up2 = ImageIO.read(getClass().getResourceAsStream("/player/Back2.png"));
                        up3 = ImageIO.read(getClass().getResourceAsStream("/player/Back3.png"));
                        down1 = ImageIO.read(getClass().getResourceAsStream("/player/Front1.png"));
                        down2 = ImageIO.read(getClass().getResourceAsStream("/player/Front2.png"));
                        down3 = ImageIO.read(getClass().getResourceAsStream("/player/Front3.png"));
                        left1 = ImageIO.read(getClass().getResourceAsStream("/player/Left1.png"));
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

        public int getDamage() {
                return damage;
        }
        public String getDirection() {
                return direction;
        }
}
