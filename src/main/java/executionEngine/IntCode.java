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
        this(new int[0], intCodes);
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
                    add();
                    break;
                case 2:
                    multiply();
                    break;
                case 3:
                    input();
                    break;
                case 4:
                    output();
                    break;
                case 5:
                    jumpIfTrue();
                    break;
                case 6:
                    jumpIfFalse();
                    break;
                case 7:
                    lessThan();
                    break;
                case 8:
                    opEquals();
                    break;

                default:
                    throw new RuntimeException("Int code exception");
            }
        }

    }

    private void opEquals() {

        final int param1 = getParam(1);
        final int param2 = getParam(2);
        setParm(3, param1 == param2 ? 1 : 0);
        opCodeExecutionLocation += 4;
    }

    private void lessThan() {
        final int param1 = getParam(1);
        final int param2 = getParam(2);
        setParm(3, param1 < param2 ? 1 : 0);
        opCodeExecutionLocation += 4;
    }

    private void jumpIfFalse() {
        final int param1 = getParam(1);
        if (param1 == 0) {
            opCodeExecutionLocation = getParam(2);
        } else {
            opCodeExecutionLocation += 3;
        }
    }

    private void jumpIfTrue() {
        final int param1 = getParam(1);
        if (param1 != 0) {
            opCodeExecutionLocation = getParam(2);
        } else {
            opCodeExecutionLocation += 3;
        }
    }

    private void output() {
        outputs.add(getParam(1));
        opCodeExecutionLocation += 2;
    }

    private void input() {
        setParm(1, inputs[inputLoc++]);
        opCodeExecutionLocation += 2;
    }

    private void add() {
        final int parm1 = getParam(1);
        final int parm2 = getParam(2);
        final int result = parm1 + parm2;
        setParm(3, result);

        opCodeExecutionLocation += 4;
    }

    private void multiply() {
        final int parm1 = getParam(1);
        final int parm2 = getParam(2);
        final int result = parm1 * parm2;
        setParm(3, result);

        opCodeExecutionLocation += 4;
    }

    private int getParam(int param) {
        int mode = new Instruction(intCodes[opCodeExecutionLocation]).getMode(param);
        final int valueAtLoc = intCodes[opCodeExecutionLocation + param];
        return mode == 0 ? intCodes[valueAtLoc] : valueAtLoc;
    }

    private int setParm(int param, int value) {
        final int valueAtLoc = intCodes[opCodeExecutionLocation + param];
        intCodes[valueAtLoc] = value;
        return value;
    }

    public List<Integer> getOutputs() {
        return outputs;
    }
}
