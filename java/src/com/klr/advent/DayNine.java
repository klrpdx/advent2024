package com.klr.advent;

import com.klr.advent.util.Defragmenter;
import com.klr.advent.util.FileLoader;

import java.io.IOException;

public class DayNine {

    private FileLoader loader;
    private String input;
    public DayNine(FileLoader loader) {
        this.loader = loader;
    }


    public long solve() throws IOException {
        input = this.loader.readLine();
        Defragmenter defragmenter = new Defragmenter(input);
        return defragmenter.getChecksum(defragmenter.fileDefragment());
    }
    public static void main(String[] args) throws IOException {
        FileLoader fileLoader = new FileLoader("/Users/klr/Projects/advent2024/resources/day9input.txt");
        DayNine dayNine = new DayNine(fileLoader);
        System.out.println("Results: "+dayNine.solve());
    }


}
