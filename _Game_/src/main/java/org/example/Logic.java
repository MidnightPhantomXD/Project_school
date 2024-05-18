package org.example;

import org.example.entity.Entity;
import org.example.entity.Player;

public class Logic {
    Player player;
    Panel panel;
    //Entity entity;
    Graphics graphic;
    public Logic(Panel panel) {
        this.panel = panel;
        //this.player = null;
    }
    public void setGraphics(Graphics graphics) {
        this.graphic = graphics;
    }

    public void initialize(){
        player = new Player(100, 100, "/Front1");

    }
    public void update(){
        if (panel.upPressed == true){
            player.direction = "up";
             player.getCoord().y -= 4;

        }
        if (panel.downPressed == true){
            player.direction = "down";
            player.getCoord().y += 4;

        }
        if (panel.leftPressed == true){
            player.direction = "left";
            player.getCoord().x -= 4;

        }
        if (panel.rightPressed == true){
            player.direction = "right";
            player.getCoord().x += 4;

        }
        if (panel.ePressed == true){

        }

    }

}
