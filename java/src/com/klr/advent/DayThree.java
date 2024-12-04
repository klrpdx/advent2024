package com.klr.advent;

import com.klr.advent.util.FileLoader;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DayThree {


    private final FileLoader loader;
    private String regex = "mul\\((\\d+),(\\d+)\\)";
    private String ignoreThis = "don't\\(\\)(.*?)do\\(\\)";
    private int totalLines = 0;

    public DayThree(FileLoader loader) {
        this.loader = loader;
    }

    private String readFile() throws IOException {
        StringBuilder sb = new StringBuilder();
        String nextLine;
        while ((nextLine = loader.readLine()) != null) {
            nextLine = nextLine.replace("\n", "").replace("\r", "");
            sb.append(nextLine);
            totalLines++;
        }
        return sb.toString();
    }

    private String removeDonts(String text) {
        Pattern pattern = Pattern.compile(ignoreThis);
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            text = matcher.replaceAll("");
        }
        return text;
    }

    public int solve() throws IOException {
        int result = 0;

        String text = readFile();
        text = removeDonts(text);
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            int val1 = Integer.parseInt(matcher.group(1));
            int val2 = Integer.parseInt(matcher.group(2));
            result = result + (val1 * val2);
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        FileLoader fileLoader = new FileLoader("/Users/klr/Projects/advent2024/resources/day3input.txt");
        DayThree solver = new DayThree(fileLoader);
        System.out.println("The solution part 1: "+solver.solve());
        System.out.println("\tLines processed: "+  solver.totalLines);
    }


}
