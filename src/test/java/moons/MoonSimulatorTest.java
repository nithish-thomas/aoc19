package moons;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class MoonSimulatorTest {
    @Test
    public void validateDay12_Example1() {
        MoonSimulator moonSimulator = new MoonSimulator(new Moon(-1, 0, 2),
          new Moon(2, -10, -7),
          new Moon(4, -8, 8),
          new Moon(3, 5, -1)
        );

        long energy = 0;

        for (int i = 0; i < 10; i++) {
            energy = moonSimulator.simulate();
        }
        System.out.println(energy);
        assertEquals(179, energy);
    }


    @Test
    public void validateDay12_Example2() {
        MoonSimulator moonSimulator = new MoonSimulator(
          new Moon(-8, -10, 0),
          new Moon(5, 5, 10),
          new Moon(2, -7, 3),
          new Moon(9, -8, -3)
        );

        long energy = 0;

        for (int i = 0; i < 100; i++) {
            energy = moonSimulator.simulate();
        }
        System.out.println(energy);
        assertEquals(1940, energy);
    }

    @Test
    public void day12_Puzzle1() {
        MoonSimulator moonSimulator = new MoonSimulator(
          new Moon(15, -2, -6),
          new Moon(-5, -4, -11),
          new Moon(0, -6, 0),
          new Moon(5, 9, 6)
        );

        long energy = 0;

        for (int i = 0; i < 1000; i++) {
            energy = moonSimulator.simulate();
        }
        System.out.println(energy);
        assertNotEquals(3083, energy);
        assertEquals(6735, energy);
    }
}