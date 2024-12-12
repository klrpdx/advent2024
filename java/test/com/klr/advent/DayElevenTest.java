package com.klr.advent;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


class DayElevenTest {

    @Test
    void rule1() {
        DayEleven eleven = new DayEleven();
        List<Long> expected = new ArrayList<>();
        expected.add(1L);

        assertEquals(expected, eleven.applyRule1(0));
        assertTrue(eleven.applyRule1(2).isEmpty());
        assertTrue(eleven.applyRule1(22).isEmpty());
    }

    @Test
    void rule2() {
        DayEleven eleven = new DayEleven();

        List<Long> expected = new ArrayList<>();
        expected.add(2L);
        expected.add(2L);

        assertEquals(expected, eleven.applyRule2(22));
        assertTrue(eleven.applyRule2(0).isEmpty());
        assertTrue(eleven.applyRule2(2).isEmpty());
    }

    @Test
    void rule3() {
        DayEleven eleven = new DayEleven();

        List<Long> expected = new ArrayList<>();
        expected.add(4048L);

        assertEquals(expected, eleven.applyRule3(2));
        assertTrue(eleven.applyRule3(0).isEmpty());
        assertTrue(eleven.applyRule3(22).isEmpty());
    }

    @Test
    void stoneList() {
        DayEleven eleven = new DayEleven();

        List<Long> stones = new ArrayList<>();
        stones.add(125L);
        stones.add(17L);

        List<Long> expected = new ArrayList<>();
        expected.add(253000L);
        expected.add(1L);
        expected.add(7L);

        List<Long> actual = eleven.blink(stones);
        assertEquals(expected, actual);
    }

    @Test
    void stoneListBlinkTwice() {
        DayEleven eleven = new DayEleven();

        List<Long> stones = new ArrayList<>();
        stones.add(125L);
        stones.add(17L);

        List<Long> expected6 = new ArrayList<>();
        expected6.add(2097446912L);
        expected6.add(14168L);
        expected6.add(4048L);
        expected6.add(2L);
        expected6.add(0L);
        expected6.add(2L);
        expected6.add(4L);
        expected6.add(40L);
        expected6.add(48L);
        expected6.add(2024L);
        expected6.add(40L);
        expected6.add(48L);
        expected6.add(80L);
        expected6.add(96L);
        expected6.add(2L);
        expected6.add(8L);
        expected6.add(6L);
        expected6.add(7L);
        expected6.add(6L);
        expected6.add(0L);
        expected6.add(3L);
        expected6.add(2L);


        List<Long> actual = eleven.blink(stones);
        actual = eleven.blink(actual);
        actual = eleven.blink(actual);
        actual = eleven.blink(actual);
        actual = eleven.blink(actual);
        actual = eleven.blink(actual);

        assertEquals(expected6, actual);
    }

    @Test
    void stoneListBlink25Times() {
        DayEleven eleven = new DayEleven();

        List<Long> stones = new ArrayList<>();
        stones.add(125L);
        stones.add(17L);

        for (int blink = 0; blink < 25; blink++) {
            stones = eleven.blink(stones);
        }

        assertEquals(55312, stones.size());
    }

    @Test
    void stoneListBlink25TimesSplit() {
        DayEleven eleven = new DayEleven();

        List<Long> stones1 = new ArrayList<>();
        stones1.add(125L);
        List<Long> stones2 = new ArrayList<>();
        stones2.add(17L);

        for (int blink = 0; blink < 25; blink++) {
            stones1= eleven.blink(stones1);
        }

        for (int blink = 0; blink < 25; blink++) {
            stones2= eleven.blink(stones2);
        }

        assertEquals(55312, stones1.size()+stones2.size());
    }


}