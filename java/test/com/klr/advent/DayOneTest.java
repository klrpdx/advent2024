package com.klr.advent;

import com.klr.advent.util.FileLoader;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class DayOneTest {

    @Mock
    private FileLoader loader;

    @Test
    void parseInput() throws Exception {
        DayOne dayOne = new DayOne(loader);

        String line = "12, 15";
        when(loader.readLine()).thenReturn(line).thenReturn(null);
        int answer = dayOne.solve();

        assertEquals(3, answer);
    }

    @Test
    void difference() throws Exception {
        DayOne dayOne = new DayOne(loader);

        String line1 = "12, 15";
        String line2 = "13, 18";
        when(loader.readLine()).thenReturn(line1).thenReturn(line2).thenReturn(null);
        int answer = dayOne.solve();

        assertEquals(8, answer);
    }



}