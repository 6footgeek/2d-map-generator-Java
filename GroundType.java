package com.sixfootgeek;


import java.awt.*;


/**
 * File:	GroundType.java
 * Version:	0.32476
 * Date:	28th February 2015.
 * Author: Andy Barlow
 *
 * Description:
 *
 *      This enum class  sets up all the different properties for groundtypes
 *      #  whether passable,
 *      #  the print character for console
 *      #  the colour
 *
 *      then there are access methods for retrieving this data for the map objects later on.
 */
public enum GroundType {
    GRASS(',', true, Color.GREEN),
    WATER('~', false, Color.BLUE),
    DIRT('.', true, Color.RED.darker()),
    FENCE('|', false, Color.DARK_GRAY);

//declare the primitives we want
    private final char mChar;
    private final boolean mPassable;
    private final Color mColour;


    private GroundType(char printChar, boolean printStatus, Color printColor) {
        mChar = printChar;
        mPassable = printStatus;
        mColour = printColor;
    }
//access methods for the enum.
    //gets colour
    public Color getColour() {
        return mColour;
    }
    //getChar returns the char representation of the enum
    public char getChar() {
        return mChar;
    }
    //unused in current implementation of map but useful later on
    public Boolean getPassable() {
        return mPassable;
    }
}