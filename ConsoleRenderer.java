package com.sixfootgeek;

/**
 * File:	ConsoleRender.java
 * Version:	0.32476
 * Date:	28th February 2015.
 * Author: Andy Barlow
 *
 * Description:
 *
 * This class simply does an x,y loop thought the passed TiledMap object and prints out the character
 * associated in the enum at whatever position currently being checked in the map object to the console.
 * Some light formatting is applied to represent the correct orientation of the map.
 * Top left is 0,0.
 */

public class ConsoleRenderer implements iRenderer {

    @Override
    public void render(TiledMap aMap) {

        System.out.println("console renderer\n\n");
        for (int y = 0; y < aMap.getMapHeight(); y++) {
            for (int x = 0; x < aMap.getMapWidth(); x++) {
                System.out.print(aMap.get(x, y).getChar());
            }
            System.out.println();
        }

    }
}

