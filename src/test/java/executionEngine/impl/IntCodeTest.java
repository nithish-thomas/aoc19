package executionEngine.impl;

import org.junit.Test;

import java.util.Arrays;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class IntCodeTest {

    @Test
    public void shouldHaltImmediatelyWhenOpCodeIs99() {
        final IntCode intCode = new IntCode(99);
        intCode.execute();
        assertArrayEquals(
          new int[]{99},
          intCode.getWorkingMemory()
        );
    }

    @Test
    public void shouldReturn2_0_0_0_99WhenOpCodeIs1_0_0_0_99() {
        final IntCode intCode = new IntCode(1, 0, 0, 0, 99);
        intCode.execute();
        assertArrayEquals(
          new int[]{2,0,0,0,99},
          intCode.getWorkingMemory()
        );
    }

    @Test
    public void shouldReturn2_0_0_6_99WhenOpCodeIs2_3_0_3_99() {
        final IntCode intCode = new IntCode(2, 3, 0, 3, 99);
        intCode.execute();
        assertArrayEquals(
          new int[]{2,3,0,6,99},
          intCode.getWorkingMemory()
        );
    }

    @Test
    public void shouldReturn2_4_4_5_99_9801WhenOpCodeIs2_4_4_5_99_0() {
        final IntCode intCode = new IntCode(2, 4, 4, 5, 99, 0);
        intCode.execute();
        assertArrayEquals(
          new int[]{2,4,4,5,99,9801},
          intCode.getWorkingMemory()
        );
    }

    @Test
    public void shouldReturnCorrectValueWhenOpCodeIs() {
        final int[] expected = {30,1,1,4,2,5,6,0,99};
        final int[] opCodes = {1,1,1,4,99,5,6,0,99};
        final IntCode intCode = new IntCode(opCodes);
        intCode.execute();
        assertArrayEquals(
          expected,
          intCode.getWorkingMemory()
        );
    }

    @Test
    public void printProperValueForPuzzle() {
        final int[] opCodes = {1,12,2,3,1,1,2,3,1,3,4,3,1,5,0,3,2,6,1,19,1,19,5,23,2,10,23,27,2,27,13,31,1,10,31,35,1,35,9,39,2,39,13,43,1,43,5,47,1,47,6,51,2,6,51,55,1,5,55,59,2,9,59,63,2,6,63,67,1,13,67,71,1,9,71,75,2,13,75,79,1,79,10,83,2,83,9,87,1,5,87,91,2,91,6,95,2,13,95,99,1,99,5,103,1,103,2,107,1,107,10,0,99,2,0,14,0};

        final IntCode intCode = new IntCode(opCodes);
        intCode.execute();
        System.out.println(Arrays.toString(intCode.getWorkingMemory()));

    }

    @Test
    public void printInputsAndAnsForLoc1AndLoc2For19690720AtPositon0Puzzle() {
        final int[] opCodes = {1,12,2,3,1,1,2,3,1,3,4,3,1,5,0,3,2,6,1,19,1,19,5,23,2,10,23,27,2,27,13,31,1,10,31,35,1,35,9,39,2,39,13,43,1,43,5,47,1,47,6,51,2,6,51,55,1,5,55,59,2,9,59,63,2,6,63,67,1,13,67,71,1,9,71,75,2,13,75,79,1,79,10,83,2,83,9,87,1,5,87,91,2,91,6,95,2,13,95,99,1,99,5,103,1,103,2,107,1,107,10,0,99,2,0,14,0};

        final int[] res = calucalateRequiredInputs(opCodes);

        System.out.println(Arrays.toString(res));
        final int x = 100 * res[0] + res[1];
        System.out.println(x);
        assertEquals(5485,x );


    }

    private int[] calucalateRequiredInputs(int[] opCodes) {
        for (int i = 0; i <100 ; i++) {
            for (int j = 0; j < 100; j++) {
                final int[] newOpCodes = Arrays.copyOf(opCodes, opCodes.length);
                newOpCodes[1]=i;
                newOpCodes[2]=j;
                final IntCode intCode = new IntCode(newOpCodes);
                intCode.execute();
                final int[] result = intCode.getWorkingMemory();
                if(result[0]==19690720) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[0];
    }

    @Test
    public void shouldPrintDay5Test(){
        final int[] opCodes = {3,225,1,225,6,6,1100,1,238,225,104,0,1101,61,45,225,102,94,66,224,101,-3854,224,224,4,224,102,8,223,223,1001,224,7,224,1,223,224,223,1101,31,30,225,1102,39,44,224,1001,224,-1716,224,4,224,102,8,223,223,1001,224,7,224,1,224,223,223,1101,92,41,225,101,90,40,224,1001,224,-120,224,4,224,102,8,223,223,1001,224,1,224,1,223,224,223,1101,51,78,224,101,-129,224,224,4,224,1002,223,8,223,1001,224,6,224,1,224,223,223,1,170,13,224,101,-140,224,224,4,224,102,8,223,223,1001,224,4,224,1,223,224,223,1101,14,58,225,1102,58,29,225,1102,68,70,225,1002,217,87,224,101,-783,224,224,4,224,102,8,223,223,101,2,224,224,1,224,223,223,1101,19,79,225,1001,135,42,224,1001,224,-56,224,4,224,102,8,223,223,1001,224,6,224,1,224,223,223,2,139,144,224,1001,224,-4060,224,4,224,102,8,223,223,101,1,224,224,1,223,224,223,1102,9,51,225,4,223,99,0,0,0,677,0,0,0,0,0,0,0,0,0,0,0,1105,0,99999,1105,227,247,1105,1,99999,1005,227,99999,1005,0,256,1105,1,99999,1106,227,99999,1106,0,265,1105,1,99999,1006,0,99999,1006,227,274,1105,1,99999,1105,1,280,1105,1,99999,1,225,225,225,1101,294,0,0,105,1,0,1105,1,99999,1106,0,300,1105,1,99999,1,225,225,225,1101,314,0,0,106,0,0,1105,1,99999,1008,677,226,224,102,2,223,223,1006,224,329,101,1,223,223,108,677,677,224,102,2,223,223,1005,224,344,101,1,223,223,107,677,677,224,1002,223,2,223,1005,224,359,101,1,223,223,1107,226,677,224,1002,223,2,223,1005,224,374,1001,223,1,223,1008,677,677,224,102,2,223,223,1006,224,389,1001,223,1,223,1007,677,677,224,1002,223,2,223,1006,224,404,1001,223,1,223,8,677,226,224,102,2,223,223,1005,224,419,1001,223,1,223,8,226,226,224,102,2,223,223,1006,224,434,101,1,223,223,1107,226,226,224,1002,223,2,223,1006,224,449,101,1,223,223,1107,677,226,224,102,2,223,223,1005,224,464,101,1,223,223,1108,226,226,224,102,2,223,223,1006,224,479,1001,223,1,223,7,677,677,224,1002,223,2,223,1006,224,494,101,1,223,223,7,677,226,224,102,2,223,223,1005,224,509,101,1,223,223,1108,226,677,224,1002,223,2,223,1006,224,524,101,1,223,223,8,226,677,224,1002,223,2,223,1005,224,539,101,1,223,223,1007,226,226,224,102,2,223,223,1006,224,554,1001,223,1,223,108,226,226,224,1002,223,2,223,1006,224,569,1001,223,1,223,1108,677,226,224,102,2,223,223,1005,224,584,101,1,223,223,108,226,677,224,102,2,223,223,1005,224,599,101,1,223,223,1007,226,677,224,102,2,223,223,1006,224,614,1001,223,1,223,1008,226,226,224,1002,223,2,223,1006,224,629,1001,223,1,223,107,226,226,224,1002,223,2,223,1006,224,644,101,1,223,223,7,226,677,224,102,2,223,223,1005,224,659,1001,223,1,223,107,677,226,224,102,2,223,223,1005,224,674,1001,223,1,223,4,223,99,226};
        final IntCode intCodeExecutor = new IntCode( opCodes);
        intCodeExecutor.execute(new Input(1));
        System.out.println(intCodeExecutor.getOutputsAsList());
        assertEquals(asList(0, 0, 0, 0, 0, 0, 0, 0, 0, 16574641),intCodeExecutor.getOutputsAsList());
    }
}