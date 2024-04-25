package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.image.ImageObserver;

public class Graphics extends JFrame{
    Draw draw;
    Logic logic;
    public Graphics(Logic logic) throws HeadlessException {

        this.draw = new Draw();
        this.logic = logic;

        setSize(1080, 720);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setTitle("Box job");

        add(draw);
    }
    public void render(Logic logic) {
        this.logic = logic;
        repaint();
    }

    public class Draw extends JPanel {
        @Override
        protected void paintComponent(java.awt.Graphics g) {

        }
    }
}
