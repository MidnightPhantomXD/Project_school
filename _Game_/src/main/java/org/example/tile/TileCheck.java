package org.example.tile;

import org.example.GameGraphics;

import javax.imageio.ImageIO;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class TileCheck {
    GameGraphics graphic;
    public Tile [] tile;
    public int mapTileNum[][];

    public TileCheck(GameGraphics graphic){
        this.graphic = graphic;

        tile = new Tile[14];
        mapTileNum = new int[graphic.maxWorldCol][graphic.maxWorldRow];

        getTileImage();
        loadMap("/maps/World Map.txt");
    }

    public void getTileImage(){

        try{
            tile[0] = new Tile();
            tile[0].image = ImageIO.read(getClass().getResourceAsStream("/tiles/Floor.png"));

            tile[1] = new Tile();
            tile[1].image = ImageIO.read(getClass().getResourceAsStream("/tiles/Canal.png"));

            tile[2] = new Tile();
            tile[2].image = ImageIO.read(getClass().getResourceAsStream("/tiles/Ramp.png"));

            tile[3] = new Tile();
            tile[3].image = ImageIO.read(getClass().getResourceAsStream("/tiles/Shelf.png"));
            tile[3].collision = true;

            tile[4] = new Tile();
            tile[4].image = ImageIO.read(getClass().getResourceAsStream("/tiles/Light_floor.png"));

            tile[5] = new Tile();
            tile[5].image = ImageIO.read(getClass().getResourceAsStream("/tiles/Wall.png"));
            tile[5].collision = true;

            tile[6] = new Tile();
            tile[6].image = ImageIO.read(getClass().getResourceAsStream("/tiles/Boxes.png"));
            tile[6].collision = true;

            tile[7] = new Tile();
            tile[7].image = ImageIO.read(getClass().getResourceAsStream("/tiles/Shelf_I.png"));
            tile[7].collision = true;
            tile[7].interactive = true;

            tile[8] = new Tile();
            tile[8].image = ImageIO.read(getClass().getResourceAsStream("/tiles/Boxes_I.png"));
            tile[8].collision = true;
            tile[8].interactive = true;

            tile[9] = new Tile();
            tile[9].image = ImageIO.read(getClass().getResourceAsStream("/tiles/A.png"));
            tile[9].collision = true;

            tile[10] = new Tile();
            tile[10].image = ImageIO.read(getClass().getResourceAsStream("/tiles/B.png"));
            tile[10].collision = true;

            tile[11] = new Tile();
            tile[11].image = ImageIO.read(getClass().getResourceAsStream("/tiles/C.png"));
            tile[11].collision = true;

            tile[12] = new Tile();
            tile[12].image = ImageIO.read(getClass().getResourceAsStream("/tiles/D.png"));
            tile[12].collision = true;

            tile[13] = new Tile();
            tile[13].image = ImageIO.read(getClass().getResourceAsStream("/tiles/E.png"));
            tile[13].collision = true;



        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void loadMap(String filePath){

        try{
            InputStream is = getClass().getResourceAsStream(filePath);
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            int col = 0;
            int row = 0;

            while(col < graphic.maxWorldCol && row < graphic.maxWorldRow){

                String line = br.readLine();

                while(row < graphic.maxWorldRow){

                    String numbers[] = line.split(" ");

                    int num = Integer.parseInt(numbers[row]);

                    mapTileNum[row][col] = num;
                    row++;
                }
                if (row == graphic.maxWorldRow){
                    row = 0;
                    col++;
                }
            }
            br.close();

        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
