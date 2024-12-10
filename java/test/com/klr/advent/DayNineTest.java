package com.klr.advent;

import com.klr.advent.util.Defragmenter;
import com.klr.advent.util.FileLoader;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class DayNineTest {


    @Mock
    private FileLoader fileloader;


    @Test
    void fileBlocks() {
        String input = "12345";
        Defragmenter disk = new Defragmenter(input);
        disk.defragment();

        List<Integer> expected = new ArrayList<>();
        expected.add(1);
        expected.add(3);
        expected.add(5);
        List<Integer> fileBlocks = disk.getFileBlocks();
        assertEquals(expected, fileBlocks);
    }

    @Test
    void freeSpace() {
        String input = "12345";
        Defragmenter disk = new Defragmenter(input);
        disk.defragment();

        List<Integer> expected = new ArrayList<>();
        expected.add(2);
        expected.add(4);
        List<Integer> fileBlocks = disk.getFreeBlocks();
        assertEquals(expected, fileBlocks);
    }

    @Test
    void freeSpaceWithZeros() {
        String input = "12305";
        Defragmenter disk = new Defragmenter(input);
        disk.defragment();

        List<Integer> expected = new ArrayList<>();
        expected.add(2);
        expected.add(0);
        List<Integer> fileBlocks = disk.getFreeBlocks();
        assertEquals(expected, fileBlocks);
    }

    @Test
    void initalArray() {
        String input = "12345";
        Defragmenter disk = new Defragmenter(input);
        disk.defragment();
        Integer[] expected = new Integer[]{0, -1, -1, 1, 1, 1, -1, -1, -1, -1, 2, 2, 2, 2, 2};
        assertArrayEquals(expected, disk.getArray());
    }

    @Test
    void initalArrayWithZeros() {
        String input = "12305";
        Defragmenter disk = new Defragmenter(input);
        disk.defragment();
        Integer[] expected = new Integer[]{0, -1, -1, 1, 1, 1, 2, 2, 2, 2, 2};
        assertArrayEquals(expected, disk.getArray());
    }

    @Test
    void longArray() {
        String input = "2333133121414131402";
        Defragmenter disk = new Defragmenter(input);
        disk.defragment();
        Integer[] expected = new Integer[]{0, 0, -1, -1, -1, 1, 1, 1, -1, -1, -1, 2, -1, -1, -1, 3, 3, 3, -1, 4, 4, -1, 5, 5, 5, 5, -1, 6, 6, 6, 6, -1, 7, 7, 7, -1, 8, 8, 8, 8, 9, 9};
        assertArrayEquals(expected, disk.getArray());
    }

    @Test
    void defragment() {
        String input = "12345";
        Defragmenter disk = new Defragmenter(input);
        Integer[] expected = new Integer[]{0, 2, 2, 1, 1, 1, 2, 2, 2, -1, -1, -1, -1, -1, -1};
        assertArrayEquals(expected, disk.defragment());
    }

    @Test
    void defragmentLong() {
        String input = "2333133121414131402";
        Defragmenter disk = new Defragmenter(input);
        Integer[] expected = new Integer[]{0,0,9,9,8,1,1,1,8,8,8,2,7,7,7,3,3,3,6,4,4,6,5,5,5,5,6,6,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1};
        assertArrayEquals(expected, disk.defragment());
    }

    @Test
    void getChecksum() {
        String input = "12345";
        Defragmenter disk = new Defragmenter(input);
        Integer[] defragmented =  disk.defragment();
        int expected = 60;
        assertEquals(expected, disk.getChecksum(defragmented));
    }

    @Test
    void getChecksumLong() {
        String input = "2333133121414131402";
        Defragmenter disk = new Defragmenter(input);
        Integer[] defragmented =  disk.defragment();
        int expected = 1928;
        assertEquals(expected, disk.getChecksum(defragmented));
    }

}