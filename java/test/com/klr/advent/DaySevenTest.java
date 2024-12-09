package com.klr.advent;

import com.klr.advent.util.FileLoader;
import com.klr.advent.util.MathMaker;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class DaySevenTest {

    @Mock
    private FileLoader fileLoader;


    @Test
    void getResult() throws IOException {
        final String numbersString = ("1069: 4 2 5 2 989");
        MathMaker mathMaker = new MathMaker(numbersString);

        assertEquals(1069, mathMaker.getTargetResult());
    }

    @Test
    void getOperands() {
        final String numbersString = ("1069: 4 2 5 2 989");
        MathMaker mathMaker = new MathMaker(numbersString);
        List<Long> operands = mathMaker.getOperands();
        assertAll("List is correct and in order",
                () -> assertEquals(4, operands.get(0)),
                () -> assertEquals(2, operands.get(1)),
                () -> assertEquals(5, operands.get(2)),
                () -> assertEquals(2, operands.get(3)),
                () -> assertEquals(989, operands.get(4))
        );
    }

    @Test
    void isSolvable() {
        final String numbersString = ("42: 22 20");
        MathMaker mathMaker = new MathMaker(numbersString);

        assertTrue(mathMaker.isSolvable());
    }

    @Test
    void handleLargeNumbers() {
        final String numbersString = ("65816524826: 3 29 7 451 5 64 26 1 1 9");
        MathMaker mathMaker = new MathMaker(numbersString);
        assertFalse(mathMaker.isSolvable());
    }

    @Test
    void recursion() {
        final String numbersString = ("292: 11 6 16 20");
        MathMaker mathMaker = new MathMaker(numbersString);
        assertTrue(mathMaker.isSolvable());
    }

    @Test
    void notSolvable() {
        final String numbersString = ("161011: 16 10 13");
        MathMaker mathMaker = new MathMaker(numbersString);
        assertFalse(mathMaker.isSolvable());
    }

    @Test
    void calibration() throws IOException {
        DaySeven solver = new DaySeven(fileLoader);
        when(fileLoader.readLine())
                .thenReturn("42: 22 20")
                .thenReturn("292: 11 6 16 20")
                .thenReturn(null);
        assertEquals(334, solver.solve());
    }

    @Test
    void smallNumbers() {
        final String numbersString = ("27: 2 1 3 3");
        MathMaker mathMaker = new MathMaker(numbersString);
        assertTrue(mathMaker.isSolvable());
    }


}