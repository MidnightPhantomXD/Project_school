package org.example.entity;

import javax.swing.*;
import java.awt.*;

public class Entity {
    protected Coordinates coord;
    protected int width;
    protected int height;
    protected Image image;
    public int spriteCounter = 0;
    public int spriteNum = 1;

    public Entity(int x, int y, String url) {
        this.coord = new Coordinates(x,y);

        ImageIcon ii = new ImageIcon(getClass().getResource("/" + url));
        this.image = ii.getImage();

        this.width = ii.getIconWidth();
        this.height = ii.getIconHeight();
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

    public Image getImage() {
        return image;
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
