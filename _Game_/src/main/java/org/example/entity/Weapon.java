package org.example.entity;

import org.example.Logic;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Weapon {
    private final int damage;
    public BufferedImage imageW;
    public boolean collision = false;
    public int x, y;
    Logic logic;

    public Weapon(int x, int y) {
        this.damage = 5;

        getWeaponImage();
    }

    public void getWeaponImage(){
        try{
            imageW = ImageIO.read(getClass().getResourceAsStream("/weapon/Paper.png"));

        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public BufferedImage getImageW() {
        return imageW;
    }

    public void setImageW(BufferedImage imageW) {
        this.imageW = imageW;
    }
}
