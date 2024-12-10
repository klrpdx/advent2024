package com.klr.advent.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Defragmenter {

    private final String diskMap;
    private final List<Integer> fileblocks = new ArrayList<Integer>();
    private final List<Integer> freeblocks = new ArrayList<Integer>();
    private int totalBlocks;

    public Defragmenter(String input) {
        diskMap = input;
    }


    public Integer[] defragment() {
        processMap();
        Integer[] fragmented = getArray();
        return fillFree(fragmented);
    }

    private Integer[] fillFree(Integer[] fragmented) {
        Integer[] defragmented = Arrays.copyOf(fragmented, fragmented.length);
        int end = defragmented.length - 1;
        for (int i = 0; i < defragmented.length; i++) {
            if (i > end) {
                break;
            }
            while (defragmented[end] == -1 && end > i) {
                end--;
            }
            if (defragmented[i] == -1) {
                defragmented[i] = defragmented[end];
                defragmented[end] = -1;
            }
        }
        return defragmented;
    }

    private void processMap() {
        char[] chars = diskMap.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            int size = Integer.parseInt(String.valueOf(chars[i]));
            totalBlocks += size;
            if (i % 2 == 0) {
                fileblocks.add(size);
            } else {
                freeblocks.add(Integer.parseInt(String.valueOf(chars[i])));
            }
        }
    }

    public long getChecksum(Integer[] array) {
        long checksum = 0;
        for (int i=0; i<array.length; i++) {
            if (array[i] != -1) {
                checksum += (long) i * array[i];
            }
        }
        return checksum;
    }

    public List<Integer> getFileBlocks() {
        return fileblocks;
    }

    public List<Integer> getFreeBlocks() {
        return freeblocks;
    }

    public Integer[] getArray() {
        Integer[] array = new Integer[totalBlocks];
        int index = 0;
        for (int fb = 0; fb < fileblocks.size(); fb++) {
            for (int j = 0; j < fileblocks.get(fb); j++) {
                array[index] = fb;
                index++;
            }
            if (fb < freeblocks.size()) {
                for (int j = 0; j < freeblocks.get(fb); j++) {
                    array[index] = -1;
                    index++;
                }
            }
        }
        return array;
    }
}
