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
class DayThreeTest {

    @Mock
    private FileLoader loader;



    @Test
    void simpleMatch() throws IOException {
        DayThree solver = new DayThree(loader);
        when(loader.readLine()).thenReturn("mul(2,3)").thenReturn(null);
        assertEquals(6, solver.solve());
    }
    @Test
    void multiMatch() throws IOException {
        DayThree solver = new DayThree(loader);
        when(loader.readLine()).thenReturn("mul(2,3)xxmul(12,3)").thenReturn(null);
        assertEquals(42, solver.solve());
    }

    @Test
    void complex() throws IOException {
        DayThree solver = new DayThree(loader);
        when(loader.readLine()).thenReturn("{!how()'&where()don't()select()@]how()}mul(884,758);-mul(971,475)who()~from()]~mul(358,23)~;").thenReturn(null);
        assertEquals(1139531, solver.solve());
    }

    @Test
    void doDontHandling() throws IOException {
        DayThree solver = new DayThree(loader);
        when(loader.readLine()).thenReturn("xmul(2,4)&mul[3,7]!^don't()_mul(5,5)+mul(32,64](mul(11,8)undo()?mul(8,5))\n").thenReturn(null);
        assertEquals(48, solver.solve());
    }


    @Test
    void doDontHandlingLineBreaks() throws IOException {
        DayThree solver = new DayThree(loader);
        when(loader.readLine()).thenReturn("xmul(2,4)&mul[3,7]!^don't()_mul(5,5)+mul(32,64]\n").thenReturn("(mul(11,8)undo()?mul(8,5))\n").thenReturn(null);
        assertEquals(48, solver.solve());
    }

}