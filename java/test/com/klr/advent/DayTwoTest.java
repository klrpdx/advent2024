package com.klr.advent;

import com.klr.advent.util.FileLoader;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class DayTwoTest {

    @Mock
    private FileLoader loader;


    @Test
    void readLines() throws IOException {

        DayTwo solver = new DayTwo(loader);

        when(loader.readLine()).thenReturn("2 5 6 7 8").thenReturn("87 89 90 93 96 99 100").thenReturn("1 2").thenReturn(null);

        int answer = solver.solve();
        assertEquals(3, answer);

    }

    @Test
    void endTest() throws IOException {
        DayTwo solver = new DayTwo(loader);

        when(loader.readLine()).thenReturn("2 3 4 5 100").thenReturn("1 2").thenReturn(null);

        int answer = solver.solve();
        assertEquals(2, answer);
    }

    @Test
    void directionTest() throws IOException {
        DayTwo solver = new DayTwo(loader);

        when(loader.readLine()).thenReturn("2 5 3 6 8 6").thenReturn("1 2").thenReturn(null);

        int answer = solver.solve();
        assertEquals(1, answer);
    }

    @Test
    void incrementTest() throws IOException {
        DayTwo solver = new DayTwo(loader);

        when(loader.readLine()).thenReturn("2 5 6 7 8").thenReturn("1 2 2 6").thenReturn("14 13 13 12 8 5 2 1").thenReturn(null);

        int answer = solver.solve();
        assertEquals(1, answer);
    }

    @Test
    void dampenerTest() throws IOException {
        DayTwo solver = new DayTwo(loader);

        when(loader.readLine()).thenReturn("2 5 5 7 8").thenReturn("53 55 56 59 62 61 65").thenReturn("14 13 12 9 6 3 2").thenReturn(null);

        int answer = solver.solve();
        assertEquals(3, answer);
    }

    @Test
    void dampenerTest2() throws IOException {
        DayTwo solver = new DayTwo(loader);

        when(loader.readLine()).thenReturn("53 55 56 59 62 61 65").thenReturn(null);

        int answer = solver.solve();
        assertEquals(1, answer);
    }

}