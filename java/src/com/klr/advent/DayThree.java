package com.klr.advent;

import com.klr.advent.util.FileLoader;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DayThree {


    private final FileLoader loader;
    private String regex = "mul\\((\\d+),(\\d+)\\)";

    public DayThree(FileLoader loader) {
        this.loader = loader;
    }

    public int solve() throws IOException {
        int result = 0;
        Pattern pattern = Pattern.compile(regex);
        String nextLine = null;
        while ((nextLine = loader.readLine()) != null) {
            Matcher matcher = pattern.matcher(nextLine);
            while (matcher.find()) {
                int val1 = Integer.parseInt(matcher.group(1));
                int val2 = Integer.parseInt(matcher.group(2));
                result = result + (val1 * val2);
            }
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        FileLoader fileLoader = new FileLoader("/Users/klr/Projects/advent2024/resources/day3input.txt");
        DayThree solver = new DayThree(fileLoader);
        System.out.println("The solution part 1: "+solver.solve());
    }


}
