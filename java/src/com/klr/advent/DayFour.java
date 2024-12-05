package com.klr.advent;

import com.klr.advent.util.Direction;
import com.klr.advent.util.FileLoader;

import java.io.IOException;

public class DayFour {

    private final FileLoader fileLoader;

    DayFour(FileLoader fileLoader) {
        this.fileLoader = fileLoader;
    }


    boolean findXmas(char[][] grid, int xStart, int yStart, Direction direction) {
        boolean found = true;
        char[] mas = new char[]{'X', 'M', 'A', 'S'};
        for (int i = 1; i < 4; i++) {
            int newX = xStart + i * direction.getXDir();
            int newY = yStart + i * direction.getYDir();
            if (newY < 0 || newY >= grid.length || newX < 0 || newX >= grid[0].length) {
                found = false;
                break;
            }
            char letter = grid[newY][newX];
            if (letter != mas[i]) {
                found = false;
                break;
            }
        }
        return found;
    }

    private char[][] createArray() throws IOException {
        String nextLine = fileLoader.readLine();
        char[][] xmas = new char[(int) fileLoader.lineCount()][nextLine.length()];
        int line = 0;
        while (nextLine != null) {
            xmas[line] = nextLine.toCharArray();
            line++;
            nextLine = fileLoader.readLine();
        }
        return xmas;
    }


    public int solve() throws IOException {
        char[][] xmas = createArray();
        int y = 0;
        int countOnXmas = 0;
        for (char[] row : xmas) {
            int x = 0;
            for (char c : row) {
                if (c == 'X') {
                    countOnXmas = countOnXmas + (findXmas(xmas, x, y, Direction.RIGHT) ? 1 : 0);
                    countOnXmas = countOnXmas + (findXmas(xmas, x, y, Direction.LEFT) ? 1 : 0);
                    countOnXmas = countOnXmas + (findXmas(xmas, x, y, Direction.DOWN) ? 1 : 0);
                    countOnXmas = countOnXmas + (findXmas(xmas, x, y, Direction.UP) ? 1 : 0);
                    countOnXmas = countOnXmas + (findXmas(xmas, x, y, Direction.UPLEFT) ? 1 : 0);
                    countOnXmas = countOnXmas + (findXmas(xmas, x, y, Direction.DOWNLEFT) ? 1 : 0);
                    countOnXmas = countOnXmas + (findXmas(xmas, x, y, Direction.UPRIGHT) ? 1 : 0);
                    countOnXmas = countOnXmas + (findXmas(xmas, x, y, Direction.DOWNRIGHT) ? 1 : 0);
                }
                x++;
            }
            y++;
        }
        return countOnXmas;
    }


    public static void main(String[] args) throws IOException {
        FileLoader fileLoader = new FileLoader("/Users/klr/Projects/advent2024/resources/day4input.txt");
        DayFour solver = new DayFour(fileLoader);
        System.out.printf("Found %d Xmases!%n",solver.solve());
    }
}
