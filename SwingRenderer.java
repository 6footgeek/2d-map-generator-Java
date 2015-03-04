package com.sixfootgeek;

import javax.swing.*;
import java.awt.*;

/**
 * File:	SwingRenderer.java
 * Version:	0.32476
 * Date:	28th February 2015.
 * Author: Andy Barlow
 * <p/>
 * Description:
 * <p/>
 * provides the output of the map object as a visual map on a jpanel.
 * the tilesize is specified and all dimensions are based on the data received from the tiledmap object
 */
public class SwingRenderer extends JPanel implements iRenderer {
    private TiledMap mMap;

    public SwingRenderer(int aWidth, int aHeight) {
        int TILE_SIZE = 15;

        if (aWidth >= 0 && aHeight >= 0) {
            this.setPreferredSize((new Dimension(aWidth, aHeight)));
            mMap = null;
        } else {

            System.out.println("need to init map bigger than 0");
        }
    }

    @Override
    public void render(TiledMap aMap) {
        mMap = aMap;
        this.repaint();
        this.revalidate();
    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (this.mMap == null) {
            g.drawString("No map to display", 200, 200);
        } else if (this.getWidth() >= this.mMap.getMapWidth() && this.getHeight() >= this.mMap.getMapHeight()) {
            g.drawString("Map is ready to display", 200, 200);

            for (int x = 0; x < mMap.getMapWidth(); x++) {
                for (int y = 0; y < mMap.getMapHeight(); y++) {
                    g.setColor(mMap.get(x, y).getColour()); //get block colours
                    g.fillRect(x * mMap.TILE_SIZE, y * mMap.TILE_SIZE, mMap.TILE_SIZE, mMap.TILE_SIZE);
                    g.setColor(Color.black);//set grid outline colour
                    g.drawRect(x * mMap.TILE_SIZE, y * mMap.TILE_SIZE, mMap.TILE_SIZE, mMap.TILE_SIZE);
                }
            }
        } else {
            g.drawString("Error, map too large", 200, 200);
        }
    }
}