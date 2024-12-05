package com.klr.advent.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileLoader {

    private final String file;
    private BufferedReader reader;

    public FileLoader(String file) {
        this.file = file;
    }

    public String readLine() throws IOException {
        if (reader == null) {
            reader = new BufferedReader(new FileReader(file));
        }

        return reader.readLine();
    }


    public long lineCount() throws IOException {
        return Files.lines(Paths.get(file)).count();
    }
}
