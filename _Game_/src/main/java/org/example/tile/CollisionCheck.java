package org.example.tile;

import org.example.GameGraphics;
import org.example.entity.Entity;

public class CollisionCheck {
    GameGraphics graphic;
    TileCheck tileCheck;

    public CollisionCheck(GameGraphics graphic, TileCheck tileCheck) {
        this.graphic = graphic;
        this.tileCheck = tileCheck;
    }

    public void checkTile(Entity entity){
        int entityLeftWorldX = entity.getCoord().x + entity.solidArea.x;
        int entityRightWorldX = entity.getCoord().x + entity.solidArea.x + entity.solidArea.width;
        int entityTopWorldY = entity.getCoord().y + entity.solidArea.y;
        int entityBottomWorldY = entity.getCoord().y + entity.solidArea.y + entity.solidArea.height;

        int entityLeftCol = entityLeftWorldX/graphic.tileFin;
        int entityRightCol = entityRightWorldX/graphic.tileFin;
        int entityTopRow = entityTopWorldY/graphic.tileFin;
        int entityBottomRow = entityBottomWorldY/graphic.tileFin;

        int tileNum1, tileNum2;

        switch (entity.direction){
            case "up":
                entityTopRow = (entityTopWorldY - entity.speed)/graphic.tileFin;
                tileNum1 = tileCheck.mapTileNum[entityLeftCol][entityTopRow];
                tileNum2 = tileCheck.mapTileNum[entityRightCol][entityTopRow];
                if (tileCheck.tile[tileNum1].collision == true || tileCheck.tile[tileNum2].collision == true){
                    entity.collisionOn = true;
                }
                break;
            case "down":
                entityBottomRow = (entityBottomWorldY + entity.speed)/graphic.tileFin;
                tileNum1 = tileCheck.mapTileNum[entityLeftCol][entityBottomRow];
                tileNum2 = tileCheck.mapTileNum[entityRightCol][entityBottomRow];
                if (tileCheck.tile[tileNum1].collision == true || tileCheck.tile[tileNum2].collision == true){
                    entity.collisionOn = true;
                }
                break;
            case "left":
                entityLeftCol = (entityLeftWorldX - entity.speed)/graphic.tileFin;
                tileNum1 = tileCheck.mapTileNum[entityLeftCol][entityTopRow];
                tileNum2 = tileCheck.mapTileNum[entityLeftCol][entityBottomRow];
                if (tileCheck.tile[tileNum1].collision == true || tileCheck.tile[tileNum2].collision == true){
                    entity.collisionOn = true;
                }
                break;
            case "right":
                entityRightCol = (entityRightWorldX + entity.speed)/graphic.tileFin;
                tileNum1 = tileCheck.mapTileNum[entityRightCol][entityTopRow];
                tileNum2 = tileCheck.mapTileNum[entityRightCol][entityBottomRow];
                if (tileCheck.tile[tileNum1].collision == true || tileCheck.tile[tileNum2].collision == true){
                    entity.collisionOn = true;
                }
                break;
        }
    }
}
