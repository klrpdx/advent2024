package com.klr.advent;

import com.klr.advent.util.FileLoader;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class DayFourTest {

    @Mock
    private FileLoader loader;


    @Test
    void solve() throws IOException {
        final String lines =
                        "MMMSXXMASM\n" +
                        "MSAMXMSMSA\n" +
                        "AMXSXMAAMM\n" +
                        "MSAMASMSMX\n" +
                        "XMASAMXAMM\n" +
                        "XXAMMXXAMA\n" +
                        "SMSMSASXSS\n" +
                        "SAXAMASAAA\n" +
                        "MAMMMXMMMM\n" +
                        "MXMXAXMASX";

        final String[] linesArray = lines.split("\n");

        DayFour solver = new DayFour(loader);
        when(loader.lineCount()).thenReturn(10L);
        when(loader.readLine())
                .thenReturn(linesArray[0])
                .thenReturn(linesArray[1])
                .thenReturn(linesArray[2])
                .thenReturn(linesArray[3])
                .thenReturn(linesArray[4])
                .thenReturn(linesArray[5])
                .thenReturn(linesArray[6])
                .thenReturn(linesArray[7])
                .thenReturn(linesArray[8])
                .thenReturn(linesArray[9])
                .thenReturn(null);
        int merryXmas = solver.solve();
        assertEquals(18, merryXmas);

    }

    @Test
    void findSimpleXmas() throws IOException {
        final String lines =
                "MMMSXXMASMXMAS\n";

        final String[] linesArray = lines.split("\n");

        DayFour solver = new DayFour(loader);
        when(loader.lineCount()).thenReturn(10L);
        when(loader.readLine())
                .thenReturn(linesArray[0])
                .thenReturn(null);
        int merryXmas = solver.solve();
        assertEquals(2, merryXmas);

    }

    @Test
    void findBackwardsXmas() throws IOException {
        final String lines =
                "MMMSAMXXMASMXMAS\n";

        final String[] linesArray = lines.split("\n");

        DayFour solver = new DayFour(loader);
        when(loader.lineCount()).thenReturn(10L);
        when(loader.readLine())
                .thenReturn(linesArray[0])
                .thenReturn(null);
        int merryXmas = solver.solve();
        assertEquals(3, merryXmas);

    }

    @Test
    void xmasOnTheEdge() throws IOException {
        final String lines =
                "MXMSXXMASMXM\n";

        final String[] linesArray = lines.split("\n");

        DayFour solver = new DayFour(loader);
        when(loader.lineCount()).thenReturn(10L);
        when(loader.readLine())
                .thenReturn(linesArray[0])
                .thenReturn(null);
        int merryXmas = solver.solve();
        assertEquals(1, merryXmas);

    }

    @Test
    void downForXmas() throws IOException {
        final String lines =
                        "MMMSXXMAAM\n" +
                        "MSAMMMSMSA\n" +
                        "AMMSAMAAMM\n" +
                        "MSAMSSMMMX\n";


        final String[] linesArray = lines.split("\n");

        DayFour solver = new DayFour(loader);
        when(loader.lineCount()).thenReturn(10L);
        when(loader.readLine())
                .thenReturn(linesArray[0])
                .thenReturn(linesArray[1])
                .thenReturn(linesArray[2])
                .thenReturn(linesArray[3])
                .thenReturn(null);
        int merryXmas = solver.solve();
        assertEquals(1, merryXmas);
    }

    @Test
    void upForXmas() throws IOException {
        final String lines =
                        "MMMSXMMAAS\n" +
                        "MSAMMMSMSA\n" +
                        "AMMSAMAAMM\n" +
                        "MSAMSSMMMX\n";


        final String[] linesArray = lines.split("\n");

        DayFour solver = new DayFour(loader);
        when(loader.lineCount()).thenReturn(10L);
        when(loader.readLine())
                .thenReturn(linesArray[0])
                .thenReturn(linesArray[1])
                .thenReturn(linesArray[2])
                .thenReturn(linesArray[3])
                .thenReturn(null);
        int merryXmas = solver.solve();
        assertEquals(2, merryXmas);
    }

    @Test
    void slantOnXmas() throws IOException {
        final String lines =
                        "MMMSXMSAAS\n" +
                        "MSAMMMSASA\n" +
                        "AMMSAMAAMM\n" +
                        "MSAMSSMMMX\n";


        final String[] linesArray = lines.split("\n");

        DayFour solver = new DayFour(loader);
        when(loader.lineCount()).thenReturn(10L);
        when(loader.readLine())
                .thenReturn(linesArray[0])
                .thenReturn(linesArray[1])
                .thenReturn(linesArray[2])
                .thenReturn(linesArray[3])
                .thenReturn(null);
        int merryXmas = solver.solve();
        assertEquals(3, merryXmas);
    }

    @Test
    void slantDownXmas() throws IOException {
        final String lines =
                        "MMMSXMSAAS\n" +
                        "MSAMMMSASA\n" +
                        "AMASAMAAMM\n" +
                        "MSAMSSMMMX\n";


        final String[] linesArray = lines.split("\n");

        DayFour solver = new DayFour(loader);
        when(loader.lineCount()).thenReturn(10L);
        when(loader.readLine())
                .thenReturn(linesArray[0])
                .thenReturn(linesArray[1])
                .thenReturn(linesArray[2])
                .thenReturn(linesArray[3])
                .thenReturn(null);
        int merryXmas = solver.solve();
        assertEquals(4, merryXmas);
    }

    @Test
    void upRightXmas() throws IOException {
        final String lines =
                        "MMMSXMSAAS\n" +
                        "MSAMMMSASA\n" +
                        "AMASAMAAMM\n" +
                        "XSAMSSMMMX\n";


        final String[] linesArray = lines.split("\n");

        DayFour solver = new DayFour(loader);
        when(loader.lineCount()).thenReturn(10L);
        when(loader.readLine())
                .thenReturn(linesArray[0])
                .thenReturn(linesArray[1])
                .thenReturn(linesArray[2])
                .thenReturn(linesArray[3])
                .thenReturn(null);
        int merryXmas = solver.solve();
        assertEquals(5, merryXmas);
    }

    @Test
    void downRightItsXmas() throws IOException {
        final String lines =
                        "MMMSXMSAAS\n" +
                        "MSAMMMSASA\n" +
                        "AMASAMAAMM\n" +
                        "XSAMSSMSMX\n";


        final String[] linesArray = lines.split("\n");

        DayFour solver = new DayFour(loader);
        when(loader.lineCount()).thenReturn(10L);
        when(loader.readLine())
                .thenReturn(linesArray[0])
                .thenReturn(linesArray[1])
                .thenReturn(linesArray[2])
                .thenReturn(linesArray[3])
                .thenReturn(null);
        int merryXmas = solver.solve();
        assertEquals(6, merryXmas);
    }


    @Test
    void downRightMasX() throws IOException {
        final String lines =
                        ".M.S......\n" +
                        "..A.......\n" +
                        ".M.S......\n" +
                        "..........\n";


        final String[] linesArray = lines.split("\n");

        DayFour solver = new DayFour(loader);
        when(loader.lineCount()).thenReturn(10L);
        when(loader.readLine())
                .thenReturn(linesArray[0])
                .thenReturn(linesArray[1])
                .thenReturn(linesArray[2])
                .thenReturn(linesArray[3])
                .thenReturn(null);
        int merryXmas = solver.solve2();
        assertEquals(1, merryXmas);
    }

    @Test
    void massMasX() throws IOException {
        final String lines =
                        ".M.S.M....\n" +
                        "..A.A.....\n" +
                        ".M.S.M....\n" +
                        "..........\n";


        final String[] linesArray = lines.split("\n");

        DayFour solver = new DayFour(loader);
        when(loader.lineCount()).thenReturn(10L);
        when(loader.readLine())
                .thenReturn(linesArray[0])
                .thenReturn(linesArray[1])
                .thenReturn(linesArray[2])
                .thenReturn(linesArray[3])
                .thenReturn(null);
        int merryXmas = solver.solve2();
        assertEquals(2, merryXmas);
    }

}