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
        List<Integer> operands = mathMaker.getOperands();
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
        final String numbersString = ("42: 4 18 20");
        MathMaker mathMaker = new MathMaker(numbersString);

        assertTrue(mathMaker.isSolvable());
    }

}