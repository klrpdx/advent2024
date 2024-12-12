package com.klr.advent;

import com.klr.advent.util.GardenPlot;
import com.klr.advent.util.TrailGraph;
import org.junit.jupiter.api.Test;

class DayTwelveTest {


    @Test
    void makeGraph() {
        final String ascii = "AAAA\n" +
                "BBCD\n" +
                "BBCC\n" +
                "EEEC";


        GardenPlot plot = new GardenPlot(ascii);
        TrailGraph graph = plot.getGardenGraph();

    }



}