package com.sixfootgeek;

/**
 * File:	PrinterRenderer.java
 * Version:	0.32476
 * Date:	28th February 2015.
 * Author: Andy Barlow
 *
 * Description:
 *
 *     Another render class that implements iRenderer (render)
 *     This will print out (to console) the actual enum name for each tile in the map.
 *
 *
 *
 */
public class PrinterRenderer implements iRenderer {

    @Override
    public void render(TiledMap aMap) {
        System.out.println("\n\nPrinter Renderer\n\n");

        for (int y = 0; y < aMap.getMapHeight(); y++) {
            for (int x = 0; x < aMap.getMapWidth(); x++) {
                //print out word value (enum name) for printer
                System.out.print(aMap.get(x, y));
            }
            System.out.println();
        }
    }


}


