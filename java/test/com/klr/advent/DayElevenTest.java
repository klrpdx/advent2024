package com.klr.advent;

import net.bytebuddy.dynamic.scaffold.MethodGraph;
import org.junit.jupiter.api.Test;

import javax.swing.event.ListDataListener;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


class DayElevenTest {

    @Test
    void rule1() {
        DayEleven eleven = new DayEleven();
        assertEquals(1L, eleven.applyRule1(0));
    }

    @Test
    void rule2() {
        DayEleven eleven = new DayEleven();
        long[] expected = new long[]{2L,2L};
        assertArrayEquals(expected, eleven.applyRule2(22L));
    }



    @Test
    void stoneList() {
        DayEleven eleven = new DayEleven();

        LinkedList<Long> stones = new LinkedList<>();
        stones.add(125L);
        stones.add(17L);

        LinkedList<Long> expected = new LinkedList<>();
        expected.add(253000L);
        expected.add(1L);
        expected.add(7L);

        List<Long> actual = eleven.blinky(stones);
        assertEquals(expected, actual);
    }

    @Test
    void stoneListBlinkTwice() {
        DayEleven eleven = new DayEleven();

        LinkedList<Long> stones = new LinkedList<>();
        stones.add(125L);
        stones.add(17L);

        LinkedList<Long> expected6 = new LinkedList<>();
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


        LinkedList<Long> actual = eleven.blinky(stones);
        actual = eleven.blinky(actual);
        actual = eleven.blinky(actual);
        actual = eleven.blinky(actual);
        actual = eleven.blinky(actual);
        actual = eleven.blinky(actual);

        assertTrue(expected6.containsAll(actual));
        assertTrue(actual.containsAll(expected6));
        assertEquals(expected6.size(), actual.size());
    }

    @Test
    void stoneListBlink25Times() {
        DayEleven eleven = new DayEleven();

        List<Long> stones = new ArrayList<>();
        stones.add(125L);
        stones.add(17L);

        assertEquals(55312, eleven.blinkyMap(stones,25));
    }

    @Test
    void stoneListBlink25TimesSplit() {
        DayEleven eleven = new DayEleven();

        List<Long> stones1 = new ArrayList<>();
        stones1.add(125L);
        List<Long> stones2 = new ArrayList<>();
        stones2.add(17L);

        long count = 0;
            count += eleven.blinkyMap(stones1, 25);
            count += eleven.blinkyMap(stones2, 25);

        assertEquals(55312, count);
    }


}