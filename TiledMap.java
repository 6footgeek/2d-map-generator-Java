package com.sixfootgeek;

import java.util.Random;

/**
 * File:	TiledMap.java
 * Version:	0.32476
 * Date:	28th February 2015.
 * Author: Andy Barlow
 *
 * Description:
 *
 *      Provides the functionality required by the client to the map object
 *      TiledMap method creates a simple map and sets the immediate groundtype to whatever is specified.
 *
 *      SetBorder method provides the border. makes a perimeter of type Hedge.
 *      SetRandomSubArea creates a randomly sized subarea of specified type by picking a 4 random values from the map.
 *      The other methods are just getters and setters of various map related things such as height and width.
 *      RandomRange method just returns an int from within a specific range.
 *
 */


public class TiledMap implements iTiledMap {
    public GroundType[][] map;
    public int TILE_SIZE, mapHeight, mapWidth;
    private iRenderer renderer;


    public TiledMap(int createWidth, int createHeight, GroundType a) {
        TILE_SIZE = 15;
        this.map = new GroundType[createWidth][createHeight];

        //make entire map start true or false
        for (int x = 0; x < createWidth; x++) {
            for (int y = 0; y < createHeight; y++) {
                map[x][y] = a;
            }
        }
        //this initialises the borders after the main map is created
        setBorder(GroundType.DIRT, this);

    }

    public void setBorder(GroundType a,TiledMap map) {

        try {
            // Add the impassable boundary hedge.
            // The top and bottom boundaries ...
            for (int x = 0; x < getMapWidth(); x++) {
                map.set(x, 0, a);
                map.set(x, getMapHeight() - 1, a);
            }
            // Set the entrance gap at the middle of the bottom boundary ...
            final int startPosition = getMapWidth() / 2 - 2;
            for (int x = getMapWidth()/2; x < startPosition + 5; x++) {
                //TODO uncouple this method from the groundtype so that it can react to the client app and not be hardcoded.
                map.set(x, 0, get(getMapWidth()/2, getMapHeight()/2));
            }
            // set the left and right boundaries ...
            for (int y = 0; y < map.getMapHeight(); y++) {
                map.set(0, y, a);
                map.set(getMapWidth() - 1, y, a);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("map to small to generate fence");
        }
    }


    public void setRenderer(iRenderer r) {
        renderer = r;
    }

    public void render() {
        if (renderer == null) return;
        renderer.render(this);
    }


    public int getMapHeight() {
        return map[0].length;
    }


    public int getMapWidth() {
        return map.length;
    }

    public GroundType get(int x, int y) {
        return map[x][y];
    }

    public void set(int x, int y, GroundType a) {
        map[x][y] = a;
    }

//method to return a random int between a range.
    public int randomFromRange(int min, int max) {
        Random r = new Random();
        int randomNum = r.nextInt((max - min) + 1) + min;
        return randomNum;
    }


//make a random sub area

    public void setRandomSubArea(int startX, int startY, int endX, int endY, GroundType a) {
        for (int x = startX; x < endX; x++) {
            for (int y = startY; y < endY; y++) {
                map[x][y] = a;
            }
        }

    }
}




