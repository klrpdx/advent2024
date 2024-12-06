package com.klr.advent;

import com.klr.advent.util.FileLoader;

import java.io.IOException;

public abstract class Solver {

    final FileLoader fileLoader;

    Solver(FileLoader fileLoader) {
        this.fileLoader = fileLoader;
    }


    abstract int solve() throws IOException;

}
