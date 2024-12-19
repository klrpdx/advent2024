package com.klr.advent.util;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public enum Compass {
    NORTH, EAST, SOUTH, WEST;


    public static int diff(Compass a, Compass b) {
        int cost = 0;
        if (a == NORTH) {
            switch (b) {
                case SOUTH:
                    cost = 1;
                    break;
                case WEST:
                    cost = 1;
                    break;
                case EAST:
                    cost = 1;
                    break;
            }

        }
        if (a == SOUTH) {
            switch (b) {
                case NORTH:
                    cost = 1;
                    break;
                case WEST:
                    cost = 1;
                    break;
                case EAST:
                    cost = 1;
                    break;
            }
        }
        if (a == EAST) {
            switch (b) {
                case NORTH:
                    cost = 1;
                    break;
                case WEST:
                    cost = 1;
                    break;
                case SOUTH:
                    cost = 1;
                    break;
            }
        }
        if (a == WEST) {
            switch (b) {
                case NORTH:
                    cost = 1;
                    break;
                case EAST:
                    cost = 1;
                    break;
                case SOUTH:
                    cost = 1;
                    break;
            }
        }

        return cost;
    }
}

