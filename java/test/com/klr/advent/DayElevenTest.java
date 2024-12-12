package com.klr.advent;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


class DayElevenTest {

    @Test
    void rule1() {
        DayEleven eleven = new DayEleven(null);
        List<Long> expected = new ArrayList<>();
        expected.add(1L);

        List<Long> notExpected1 = new ArrayList<>();
        notExpected1.add(2L);

        List<Long> notExpected2 = new ArrayList<>();
        notExpected2.add(22L);

        assertEquals(expected, eleven.applyRule1(0));
        assertEquals(notExpected1, eleven.applyRule1(2));
        assertEquals(notExpected2, eleven.applyRule1(22));
    }

    @Test
    void rule2() {
        DayEleven eleven = new DayEleven(null);

        List<Long> expected = new ArrayList<>();
        expected.add(2L);
        expected.add(2L);

        List<Long> notExpected1 = new ArrayList<>();
        notExpected1.add(0L);

        List<Long> notExpected2 = new ArrayList<>();
        notExpected2.add(2L);

        assertEquals(expected, eleven.applyRule2(22));
        assertEquals(notExpected1, eleven.applyRule2(0));
        assertEquals(notExpected2, eleven.applyRule2(2));
    }

    @Test
    void rule3() {
        DayEleven eleven = new DayEleven(null);

        List<Long> expected = new ArrayList<>();
        expected.add(4048L);

        List<Long> notExpected1 = new ArrayList<>();
        notExpected1.add(0L);

        List<Long> notExpected2 = new ArrayList<>();
        notExpected2.add(22L);

        assertEquals(expected, eleven.applyRule3(2));
        assertEquals(notExpected1, eleven.applyRule3(0));
        assertEquals(notExpected2, eleven.applyRule3(22));
    }


}