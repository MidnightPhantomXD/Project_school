package org.example.entity;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Entity {
    protected Coordinates coord;
    protected int width;
    protected int height;
    public BufferedImage down1, down2, down3, up1, up2, up3, left1, left2, left3, right1, right2, right3;
    public String direction;
    public int spriteCounter = 0;
    public int spriteNum = 1;

    public Entity(int x, int y) {
        this.coord = new Coordinates(x,y);
        this.direction = "down";
    }
    public Coordinates getCoord() {
        return coord;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }


    public int getX() {
        return coord.x;
    }

    public void setX(int x) {
        this.coord.x = x;
    }

    public int getY() {
        return coord.y;
    }

    public void setY(int y) {
        this.coord.y = y;
    }
}
