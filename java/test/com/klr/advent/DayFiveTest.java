package com.klr.advent;

import com.klr.advent.util.FileLoader;
import com.klr.advent.util.RuleMaker;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class DayFiveTest {

    @Mock
    private FileLoader loader;

    @Test
    void createRules() throws IOException {

        RuleMaker maker = new RuleMaker();
        maker.addRule("47|53");
        maker.addRule("97|13");
        maker.addRule("97|61");
        maker.addRule("97|47");

        final List<Integer> comesBefore = maker.getRule(47);
        assertTrue(comesBefore.contains(53));
    }

    @Test
    void createRuleMultiple() {
        RuleMaker maker = new RuleMaker();
        maker.addRule("47|53");
        maker.addRule("97|13");
        maker.addRule("97|61");
        maker.addRule("97|47");

        final List<Integer> comesBefore = maker.getRule(97);
        assertAll(
                () -> assertTrue(comesBefore.contains(13)),
                () -> assertTrue(comesBefore.contains(61)),
                () -> assertTrue(comesBefore.contains(47)),
                () -> assertEquals(3, comesBefore.size())
        );
    }

    @Test
    void violateRule() throws IOException {
        DayFive solver = new DayFive(loader);
        when(loader.readLine()).thenReturn("47|53").thenReturn("\n").thenReturn("53,12,47").thenReturn(null);

        int answer = solver.solve();
        assertEquals(0, answer);
    }

    @Test
    void validRule() throws IOException {
        DayFive solver = new DayFive(loader);
        when(loader.readLine()).thenReturn("47|53").thenReturn("\n").thenReturn("47,53,12").thenReturn(null);

        int answer = solver.solve();
        assertEquals(53, answer);
    }

    @Test
    void sumOfMiddlesOneRule() throws IOException {
        DayFive solver = new DayFive(loader);
        when(loader.readLine())
                .thenReturn("47|53")
                .thenReturn("97|13")
                .thenReturn("97|61")
                .thenReturn("97|47")
                .thenReturn("\n")
                .thenReturn("47,53,12")
                .thenReturn("53,97,12,13,47,61")
                .thenReturn(null);

        int answer = solver.solve();
        assertEquals(53, answer);
    }

    @Test
    void sumOfMiddlesAllRules() throws IOException {
        DayFive solver = new DayFive(loader);
        when(loader.readLine())
                .thenReturn("47|53")
                .thenReturn("97|13")
                .thenReturn("97|61")
                .thenReturn("97|47")
                .thenReturn("\n")
                .thenReturn("47,53,12")
                .thenReturn("12,97,12,13,47,53,61")
                .thenReturn(null);

        int answer = solver.solve();
        assertEquals(66, answer);
    }

}