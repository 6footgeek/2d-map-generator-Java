package com.sixfootgeek;

/**
 * File:	iRenderer.java
 * Version:	0.32476
 * Date:	28th February 2015.
 * Author: Andy Barlow
 *
 * Description:
 *
 *       iRenderer is the rendering interface that provides on the fly output selection
 *          This method is essential for the strategy design pattern.
 */


public interface iRenderer {
    void render(TiledMap aMap);
}
