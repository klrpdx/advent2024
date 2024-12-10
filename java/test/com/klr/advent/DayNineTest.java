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

}