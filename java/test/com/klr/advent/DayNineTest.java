package com.klr.advent;

import com.klr.advent.util.Defragmenter;
import com.klr.advent.util.FileLoader;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Arrays;
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
        assertArrayEquals(expected, disk.getFragmentedArray());
    }

    @Test
    void initalArrayWithZeros() {
        String input = "12305";
        Defragmenter disk = new Defragmenter(input);
        disk.defragment();
        Integer[] expected = new Integer[]{0, -1, -1, 1, 1, 1, 2, 2, 2, 2, 2};
        assertArrayEquals(expected, disk.getFragmentedArray());
    }

    @Test
    void longArray() {
        String input = "2333133121414131402";
        Defragmenter disk = new Defragmenter(input);
        disk.defragment();
        Integer[] expected = new Integer[]{0, 0, -1, -1, -1, 1, 1, 1, -1, -1, -1, 2, -1, -1, -1, 3, 3, 3, -1, 4, 4, -1, 5, 5, 5, 5, -1, 6, 6, 6, 6, -1, 7, 7, 7, -1, 8, 8, 8, 8, 9, 9};
        assertArrayEquals(expected, disk.getFragmentedArray());
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

    @Test
    void defragmentCompleteFiles() {
        String input = "13345";
        Defragmenter disk = new Defragmenter(input);
        Integer[] fileDefragmentationExpectation = new Integer[]{0,1,1,1,-1,-1,-1,-1,-1,-1,-1,2,2,2,2,2};
        assertArrayEquals(fileDefragmentationExpectation, disk.fileDefragment());
    }

    @Test
    void defragmentCompleteComplex() {
        String input = "2333133121414131402";
        Defragmenter disk = new Defragmenter(input);
        Integer[] fileDefragmentationExpectation = new Integer[]{0, 0, 9, 9, 2, 1, 1, 1, 7, 7, 7, -1, 4, 4,-1, 3, 3, 3, -1, -1, -1, -1, 5, 5, 5, 5, -1, 6, 6, 6, 6, -1, -1, -1,-1, -1, 8, 8, 8, 8, -1, -1};
        assertArrayEquals(fileDefragmentationExpectation, disk.fileDefragment());
    }

    @Test
    void getChecksumFile() {
        String input = "2333133121414131402";
        Defragmenter disk = new Defragmenter(input);
        Integer[] defragmented =  disk.fileDefragment();
        int expected = 2858;
        assertEquals(expected, disk.getChecksum(defragmented));
    }

    @Test
    void checksum1() {
        String input = "673253833464635054191677274350925861527651788483";
        Defragmenter disk = new Defragmenter(input);
        Integer[] defragmented =  disk.fileDefragment();
        int expected = 149706;
        assertEquals(expected, disk.getChecksum(defragmented));
    }

    @Test
    void checksum2() {

        String index =     "0 . 1 . 2 . - . - . 3 . 4 . 5 . 6 . - . - . - . - . 7 . 8 . 9 . 10 . 11 .  12  ";
        String inputviz =  "3 2 2 2 1 2 0 2 0 2 5 2 5 2 8 2 8 2 0 2 0 2 0 2 0 2 7 2 7 2 2 2 1  2 1  2  1";

        String input =  "3222120202525282820202020272722212121";
        Defragmenter disk = new Defragmenter(input);
        Integer[] defragmented =  disk.fileDefragment();
        System.out.println(Arrays.toString(disk.getFragmentedArray()));
        int expected = 7705;
        assertEquals(expected, disk.getChecksum(defragmented));
    }



}