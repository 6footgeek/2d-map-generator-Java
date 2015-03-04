package com.sixfootgeek;

/**
 * File:	iTiledMap.java
 * Version:	0.32476
 * Date:	28th February 2015.
 * Author: Andy Barlow
 *
 * Description:
 *
 *      Interface for tiledmap object
 *
 */
public interface iTiledMap {

    public int getMapHeight();
    public int getMapWidth();
    public GroundType get(int x, int y);
    public void set(int x, int y, GroundType a);
    public void setRenderer(iRenderer r);
    public void render();
    public void setRandomSubArea(int startX, int startY, int endX, int endY, GroundType a);

}
