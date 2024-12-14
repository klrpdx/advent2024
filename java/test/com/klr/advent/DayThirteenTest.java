package com.klr.advent;

import com.klr.advent.util.ClawMachine;
import com.klr.advent.util.PrizeReader;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DayThirteenTest {


    @Test
    void getMachine() {
        String text = "Button A: X+94, Y+34\n" +
                "Button B: X+22, Y+67\n" +
                "Prize: X=8400, Y=5400\n" +
                " ";

        PrizeReader prizeReader = new PrizeReader(text);
        List<ClawMachine> machines = prizeReader.getMachines();

        assertEquals(1, machines.size());

        ClawMachine machine = machines.getFirst();
        assertEquals(94, machine.buttonA().x());
        assertEquals(34, machine.buttonA().y());
        assertEquals(22, machine.buttonB().x());
        assertEquals(67, machine.buttonB().y());
        assertEquals(8400, machine.prize().x());
        assertEquals(5400, machine.prize().y());
    }

    @Test
    void price() {
        String text = "Button A: X+94, Y+34\n" +
                "Button B: X+22, Y+67\n" +
                "Prize: X=8400, Y=5400\n" +
                " ";

        PrizeReader prizeReader = new PrizeReader(text);
        List<ClawMachine> machines = prizeReader.getMachines();
        DayThirteen dayThirteen = new DayThirteen(null);

        assertEquals(280, dayThirteen.price(machines.getFirst()));
    }

    @Test
    void noPrice() {
        String text = "Button A: X+26, Y+66\n" +
                "Button B: X+67, Y+21\n" +
                "Prize: X=12748, Y=12176" +
                " ";

        PrizeReader prizeReader = new PrizeReader(text);
        List<ClawMachine> machines = prizeReader.getMachines();
        DayThirteen dayThirteen = new DayThirteen(null);

        ClawMachine machine = machines.getFirst();
        assertEquals(0, dayThirteen.price(machines.getFirst()));
    }

    @Test
    void price2() {
        String text = "Button A: X+17, Y+86\n" +
                "Button B: X+84, Y+37\n" +
                "Prize: X=7870, Y=6450" +
                " ";

        PrizeReader prizeReader = new PrizeReader(text);
        List<ClawMachine> machines = prizeReader.getMachines();
        DayThirteen dayThirteen = new DayThirteen(null);

        assertEquals(200, dayThirteen.price(machines.getFirst()));
    }

    @Test
    void priceLargeNumbers() {
        String text = "Button A: X+26, Y+66\n" +
                "Button B: X+67, Y+21\n" +
                "Prize: X=12748, Y=12176" +
                " ";

        PrizeReader prizeReader = new PrizeReader(text);
        List<ClawMachine> machines = prizeReader.getMachines(true);
        DayThirteen dayThirteen = new DayThirteen(null);

        assertEquals(459236326669L, dayThirteen.price(machines.getFirst()));
    }

}