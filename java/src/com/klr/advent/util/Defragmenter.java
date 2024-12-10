package com.klr.advent.util;

import java.util.ArrayList;
import java.util.List;

public class Defragmenter {

    private final String diskMap;
    private final List<Integer> fileblocks = new ArrayList<Integer>();
    private final List<Integer> freeblocks = new ArrayList<Integer>();

    public Defragmenter(String input) {
        diskMap = input;
    }


    public List<Integer> getFileBlocks() {
        return fileblocks;
    }

    public void defragment() {
        char[] chars = diskMap.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (i%2 == 0) {
                fileblocks.add(Integer.parseInt(String.valueOf(chars[i])));
            }
            else {
                freeblocks.add(Integer.parseInt(String.valueOf(chars[i])));
            }
        }
    }

    public List<Integer> getFreeBlocks() {
        return freeblocks;
    }
}
