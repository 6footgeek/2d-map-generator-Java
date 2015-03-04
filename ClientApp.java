package com.sixfootgeek;

/**
 * File:	ClientApp.java
 * Version:	0.32476
 * Date:	28th February 2015.
 * Author: Andy Barlow
 *
 * Description:
 *
 *          This class is the client facing app or starting point of the entire program.
 *          It sets up a simple JFrame GUI with which the client can define what size map they wish to create.
 *          It also allows the renderer of the map to be changed.
 *          #  ConsoleRenderer will print out a console representation of the map using ASCII chars
 *          #  SwingRenderer will display the map in a JFrame with colours
 *          #  OrientationRenderer displays the map using numbers to decide the
 *
 */

import javax.swing.*;
import java.awt.*;

public final class ClientApp {

    //main method. all of the magic happens here.
    public static void main(String[] args) {

        final TiledMap map = createMap();      //make the map object

        map.setRenderer(new ConsoleRenderer());     //render map to console
        map.render();
        map.setRenderer(new PrinterRenderer());
        map.render();

        SwingUtilities.invokeLater(new Runnable() {  //safely open swing thread and render swing map
            @Override
            public void run() {
                //create window with map object
                JpanelRender(map);
            }
        });
    }

    private final static TiledMap createMap() {
        TiledMap map = new TiledMap(50, 50, GroundType.GRASS);

        //the subarea method could do with more work as the 4 ints passed to it require maths to function correctly.
        map.setRandomSubArea(map.randomFromRange(1, map.getMapWidth() / 2), map.randomFromRange(1, map.getMapHeight() / 2),
                map.randomFromRange(map.getMapWidth() / 2 + 1, map.getMapWidth() - 2), map.randomFromRange(map.getMapHeight() / 2 + 1, map.getMapHeight() - 1), GroundType.WATER);
        return map;

    }

    //method to render
    private static final void JpanelRender(TiledMap aMap) {
        //create swing panel dimensions here to pass to renderer later
        //needs to be created here as jframe needs an object to render. cant be created on the fly.
        SwingRenderer swingPanel = new SwingRenderer(aMap.getMapWidth() * aMap.TILE_SIZE, aMap.getMapHeight() * aMap.TILE_SIZE);

        //make JFrame and set to visible
        final JFrame f = new JFrame("Map creator");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.add(swingPanel, BorderLayout.CENTER);
        f.pack();
        f.setVisible(true);
        //render the map using swingpanel object created above
        aMap.setRenderer(swingPanel);

        aMap.render();

    }
}







