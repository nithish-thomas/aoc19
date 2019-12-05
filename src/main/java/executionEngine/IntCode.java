package executionEngine;

import java.util.LinkedList;
import java.util.List;

public class IntCode {
    private final int[] intCodes;

    private final int inputs[];
    private final List<Integer> outputs = new LinkedList<>();
    private int inputLoc = 0;
    private int opCodeExecutionLocation = 0;

    public IntCode(int... intCodes) {
        this( new int[0], intCodes);
    }

    public IntCode(int[] inputs, int... intCodes) {
        this.intCodes = intCodes;
        this.inputs = inputs;
    }

    public int[] execute() {
        executeFrom();
        return intCodes;
    }

    private void executeFrom() {
        while (true) {
            final Instruction instruction = new Instruction(intCodes[opCodeExecutionLocation]);
            switch (instruction.getOpCode()) {
                case 99:
                    return;
                case 1:
                    add(opCodeExecutionLocation, instruction);
                    opCodeExecutionLocation += 4;
                    break;
                case 2:
                    multiply(opCodeExecutionLocation, instruction);
                    opCodeExecutionLocation += 4;
                    break;
                case 3:
                    input(opCodeExecutionLocation, instruction);
                    opCodeExecutionLocation += 2;
                    break;
                case 4:
                    output(opCodeExecutionLocation, instruction);
                    opCodeExecutionLocation += 2;
                    break;

                default:
                    throw new RuntimeException("Int code exception");
            }
        }

    }

    private void output(int opCodeExecutionLocation, Instruction instruction) {
        outputs.add(getParm(opCodeExecutionLocation + 1, instruction.getMode(1)));
    }

    private void input(int opCodeExecutionLocation, Instruction instruction) {
        setParm(opCodeExecutionLocation + 1, inputs[inputLoc++]);
    }

    private void add(int opCodeExecutionLocation, Instruction instruction) {
        final int parm1 = getParm(opCodeExecutionLocation + 1, instruction.getMode(1));
        final int parm2 = getParm(opCodeExecutionLocation + 2, instruction.getMode(2));
        final int result = parm1 + parm2;
        setParm(opCodeExecutionLocation + 3, result);
    }

    private void multiply(int opCodeExecutionLocation, Instruction instruction) {
        final int parm1 = getParm(opCodeExecutionLocation + 1, instruction.getMode(1));
        final int parm2 = getParm(opCodeExecutionLocation + 2, instruction.getMode(2));
        final int result = parm1 * parm2;
        setParm(opCodeExecutionLocation + 3, result);
    }

    private int getParm(int location, int mode) {
        final int valueAtLoc = intCodes[location];
        return mode == 0 ? intCodes[valueAtLoc] : valueAtLoc;
    }

    private int setParm(int location, int value) {
        final int valueAtLoc = intCodes[location];
        intCodes[valueAtLoc] = value;
        return value;
    }

    public List<Integer> getOutputs() {
        return outputs;
    }
}
