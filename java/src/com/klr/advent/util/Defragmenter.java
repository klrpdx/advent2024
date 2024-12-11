package com.klr.advent.util;

import java.util.*;

public class Defragmenter {

    private final String diskMap;
    private final List<Integer> fileblocks = new ArrayList<Integer>();
    private final List<Integer> freeblocks = new ArrayList<Integer>();
    private final Map<String, Integer> indexMap = new HashMap<String, Integer>();
    private int totalBlocks;

    public Defragmenter(String input) {
        diskMap = input;
    }


    public Integer[] defragment() {
        processMap();
        Integer[] fragmented = getFragmentedArray();
        return fillFree(fragmented);
    }

    public Integer[] fileDefragment() {
        processMap();
        Integer[] fragmented = getFragmentedArray();
        return fillFreeWithWholeFiles(fragmented);
    }

    private Integer[] fillFreeWithWholeFiles(Integer[] fragmented) {
        for (int fileIndex = fileblocks.size() - 1; fileIndex >= 0; fileIndex--) {
            int fileSize = fileblocks.get(fileIndex);
            for (int freeIndex=0; freeIndex < fileIndex; freeIndex++) {
                int freeSize = freeblocks.get(freeIndex);
                if (freeSize >= fileSize) {
                    moveFile(fileIndex, freeIndex, fragmented);
                    break;
                }
            }
        }
        return fragmented;
    }

    private void moveFile(Integer fileIndex, Integer freeIndex, Integer[] array) {
        int freeStartIndex = indexMap.get(freeIndex+"Free");
        int fileStartIndex = indexMap.get(fileIndex+"File");
        int fileSize = fileblocks.get(fileIndex);
        int freeSize = freeblocks.get(freeIndex);

        for (int i=0; i<fileSize; i++) {
            array[freeStartIndex+i] = array[fileStartIndex+i];
            array[fileStartIndex+i] = -1;
        }
        freeblocks.set(freeIndex,freeSize-fileSize);
        indexMap.put(freeIndex+"Free", freeStartIndex+fileSize);
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
        boolean zeroFile = false;
        for (int i = 0; i < chars.length; i++) {
            int size = Integer.parseInt(String.valueOf(chars[i]));
            totalBlocks += size;
            if (i % 2 == 0) {
                if (size > 0) {
                    fileblocks.add(size);
                }
                else {
                    System.out.printf("Found a zero-sized file at index %d\n", i);
                    zeroFile = true;
                }
            } else {
                if (zeroFile) {
                    int prevIndex = fileblocks.size() - 1;
                    int prevFreeBlock = freeblocks.get(prevIndex);
                    freeblocks.set(prevIndex, prevFreeBlock+size);
                    zeroFile = false;
                }
                else {
                    freeblocks.add(size);
                }
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

    public Integer[] getFragmentedArray() {
        Integer[] array = new Integer[totalBlocks];
        int index = 0;
        for (int fb = 0; fb < fileblocks.size(); fb++) {
            indexMap.put(fb+"File",index);
            for (int j = 0; j < fileblocks.get(fb); j++) {
                array[index] = fb;
                index++;
            }
            if (fb < freeblocks.size()) {
                indexMap.put(fb+"Free",index);
                for (int j = 0; j < freeblocks.get(fb); j++) {
                    array[index] = -1;
                    index++;
                }
            }
        }
        System.out.println("Fragmented: " + Arrays.toString(array));
        return array;
    }
}
