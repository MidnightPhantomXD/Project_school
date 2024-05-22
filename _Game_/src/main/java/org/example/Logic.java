package org.example;

import org.example.entity.Entity;
import org.example.entity.Player;
import org.example.entity.Weapon;
import org.example.tile.CollisionCheck;
import org.example.tile.TileCheck;

import java.util.ArrayList;

public class Logic {
    Player player;
    Panel panel;
    GameGraphics graphic;
    CollisionCheck cCheck;
    Entity entity;
    TileCheck tileCheck;


    public Logic(Panel panel) {
        this.panel = panel;
        this.graphic = new GameGraphics(this);
        this.tileCheck = new TileCheck(graphic);
        this.cCheck = new CollisionCheck(graphic, tileCheck);
        this.player = new Player(8 * graphic.tileFin, 6 * graphic.tileFin, graphic);
        this.entity = player;
    }

    public Player getPlayer(){
        return player;
    }
    public void setGraphics(GameGraphics graphics) {
        this.graphic = graphics;
    }

    public void initialize(){



    }
    public void update(){

        if (panel.upPressed == true || panel.downPressed == true || panel.leftPressed == true || panel.rightPressed == true){
            if (panel.upPressed == true){
                player.direction = "up";

            }
            if (panel.downPressed == true){
                player.direction = "down";

            }
            if (panel.leftPressed == true){
                player.direction = "left";

            }
            if (panel.rightPressed == true){
                player.direction = "right";

            }
            if (panel.ePressed == true){

            }

            entity.collisionOn = false;
            cCheck.checkTile(player);

            if (entity.collisionOn == false){

                switch (entity.direction){
                    case "up": entity.getCoord().y -= entity.speed; break;
                    case "down": entity.getCoord().y += entity.speed; break;
                    case "left": entity.getCoord().x -= entity.speed; break;
                    case "right": entity.getCoord().x += entity.speed; break;
                }
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
        graphic.render(this);
    }
}
