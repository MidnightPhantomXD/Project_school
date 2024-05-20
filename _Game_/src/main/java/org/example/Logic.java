package org.example;

import org.example.entity.Entity;
import org.example.entity.Player;
import org.example.tile.Tile;

public class Logic {
    Player player;
    Panel panel;
    Graphics graphic;
    Tile[] tile;
    public Logic(Panel panel) {
        this.panel = panel;
        this.player = new Player(100, 100);
    }

    public Player getPlayer(){
        return player;
    }
    public void setGraphics(Graphics graphics) {
        this.graphic = graphics;
    }

    public void initialize(){


    }
    public void update(){

        if (panel.upPressed == true || panel.downPressed == true || panel.leftPressed == true || panel.rightPressed == true){
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

            player.spriteCounter++;
            if (player.spriteCounter > 14){
                if (player.spriteNum == 1){
                    player.spriteNum = 2;
                }
                else if (player.spriteNum == 2){
                    player.spriteNum = 3;
                }
                else if (player.spriteNum == 3){
                    player.spriteNum = 4;
                }
                else if (player.spriteNum == 4){
                    player.spriteNum = 1;
                }
                player.spriteCounter = 0;
            }
        }

    }
}
