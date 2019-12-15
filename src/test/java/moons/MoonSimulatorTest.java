package moons;

import org.apache.commons.math3.util.ArithmeticUtils;
import org.junit.Test;

import java.util.Arrays;

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

    @Test
    public void validateDay12_Puzzle2_Example1() {
        MoonSimulator moonSimulator = new MoonSimulator(new Moon(-1, 0, 2),
          new Moon(2, -10, -7),
          new Moon(4, -8, 8),
          new Moon(3, 5, -1)
        );

        Long dimensionalRepeatInterval[] = new Long[3];
        for (long i = 1; i < Long.MAX_VALUE; i++) {
            moonSimulator.simulate();
            checkAndSetMinimumRepeatIntevalOnDimension(moonSimulator, dimensionalRepeatInterval, i, 0);
            checkAndSetMinimumRepeatIntevalOnDimension(moonSimulator, dimensionalRepeatInterval, i, 1);
            checkAndSetMinimumRepeatIntevalOnDimension(moonSimulator, dimensionalRepeatInterval, i, 2);
            if(dimensionalRepeatInterval[0]!=null&&dimensionalRepeatInterval[2]!=null&&dimensionalRepeatInterval[1]!=null){
                break;
            }
        }
        long result = ArithmeticUtils.lcm(dimensionalRepeatInterval[0], dimensionalRepeatInterval[1]);
        result = ArithmeticUtils.lcm(result, dimensionalRepeatInterval[2]);
        System.out.println(Arrays.toString(dimensionalRepeatInterval));
        System.out.println(result);
        assertEquals(2772, result);
    }
    @Test
    public void day12_Puzzle2() {
        MoonSimulator moonSimulator = new MoonSimulator(
          new Moon(15, -2, -6),
          new Moon(-5, -4, -11),
          new Moon(0, -6, 0),
          new Moon(5, 9, 6)
        );

        Long dimensionalRepeatInterval[] = new Long[3];
        for (long i = 1; i < Long.MAX_VALUE; i++) {
            moonSimulator.simulate();
            checkAndSetMinimumRepeatIntevalOnDimension(moonSimulator, dimensionalRepeatInterval, i, 0);
            checkAndSetMinimumRepeatIntevalOnDimension(moonSimulator, dimensionalRepeatInterval, i, 1);
            checkAndSetMinimumRepeatIntevalOnDimension(moonSimulator, dimensionalRepeatInterval, i, 2);
            if(dimensionalRepeatInterval[0]!=null&&dimensionalRepeatInterval[2]!=null&&dimensionalRepeatInterval[1]!=null){
                break;
            }
        }
        long result = ArithmeticUtils.lcm(dimensionalRepeatInterval[0], dimensionalRepeatInterval[1]);
        result = ArithmeticUtils.lcm(result, dimensionalRepeatInterval[2]);
        System.out.println(Arrays.toString(dimensionalRepeatInterval));
        System.out.println(result);
        assertEquals(326489627728984L, result);
    }

    private void checkAndSetMinimumRepeatIntevalOnDimension(MoonSimulator moonSimulator, Long[] dimensionalRepeatInterval, long i, int dimension) {
        if(dimensionalRepeatInterval[dimension]==null && moonSimulator.isAtBeginning(dimension)){
            dimensionalRepeatInterval[dimension] = i;
        }
    }
}