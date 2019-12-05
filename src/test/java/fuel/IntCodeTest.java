package fuel;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class IntCodeTest {

    @Test
    public void shouldHaltImmediatelyWhenOpCodeIs99() {
        assertArrayEquals(
          new int[]{99},
          new IntCode(99).execute()
        );
    }

    @Test
    public void shouldReturn2_0_0_0_99WhenOpCodeIs1_0_0_0_99() {
        assertArrayEquals(
          new int[]{2,0,0,0,99},
          new IntCode(1,0,0,0,99).execute()
        );
    }

    @Test
    public void shouldReturn2_0_0_6_99WhenOpCodeIs2_3_0_3_99() {
        assertArrayEquals(
          new int[]{2,3,0,6,99},
          new IntCode(2,3,0,3,99).execute()
        );
    }

    @Test
    public void shouldReturn2_4_4_5_99_9801WhenOpCodeIs2_4_4_5_99_0() {
        assertArrayEquals(
          new int[]{2,4,4,5,99,9801},
          new IntCode(2,4,4,5,99,0).execute()
        );
    }

    @Test
    public void shouldReturnCorrectValueWhenOpCodeIs() {
        final int[] expected = {30,1,1,4,2,5,6,0,99};
        final int[] opCodes = {1,1,1,4,99,5,6,0,99};
        assertArrayEquals(
          expected,
          new IntCode(opCodes).execute()
        );
    }

    @Test
    public void printProperValueForPuzzle() {
        final int[] opCodes = {1,12,2,3,1,1,2,3,1,3,4,3,1,5,0,3,2,6,1,19,1,19,5,23,2,10,23,27,2,27,13,31,1,10,31,35,1,35,9,39,2,39,13,43,1,43,5,47,1,47,6,51,2,6,51,55,1,5,55,59,2,9,59,63,2,6,63,67,1,13,67,71,1,9,71,75,2,13,75,79,1,79,10,83,2,83,9,87,1,5,87,91,2,91,6,95,2,13,95,99,1,99,5,103,1,103,2,107,1,107,10,0,99,2,0,14,0};

        System.out.println(Arrays.toString(new IntCode(opCodes).execute()));

    }

    @Test
    public void printInputsAndAnsForLoc1AndLoc2For19690720AtPositon0Puzzle() {
        final int[] opCodes = {1,12,2,3,1,1,2,3,1,3,4,3,1,5,0,3,2,6,1,19,1,19,5,23,2,10,23,27,2,27,13,31,1,10,31,35,1,35,9,39,2,39,13,43,1,43,5,47,1,47,6,51,2,6,51,55,1,5,55,59,2,9,59,63,2,6,63,67,1,13,67,71,1,9,71,75,2,13,75,79,1,79,10,83,2,83,9,87,1,5,87,91,2,91,6,95,2,13,95,99,1,99,5,103,1,103,2,107,1,107,10,0,99,2,0,14,0};

        final int[] res = calucalateRequiredInputs(opCodes);

        System.out.println(Arrays.toString(res));
        System.out.println(100*res[0]+res[1]);

    }

    private int[] calucalateRequiredInputs(int[] opCodes) {
        for (int i = 0; i <100 ; i++) {
            for (int j = 0; j < 100; j++) {
                final int[] newOpCodes = Arrays.copyOf(opCodes, opCodes.length);
                newOpCodes[1]=i;
                newOpCodes[2]=j;
                final int[] result = new IntCode(newOpCodes).execute();
                if(result[0]==19690720) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[0];
    }
}