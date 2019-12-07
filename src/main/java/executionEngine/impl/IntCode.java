package executionEngine.impl;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class IntCode {
    private final int[] program;

    private int[] workingMemory;
    private int inputs[];
    private List<Integer> outputs = new LinkedList<>();
    private int inputLoc = 0;
    private int opCodeExecutionLocation = 0;


    public IntCode( int... program) {
        this.program = program;
        workingMemory = Arrays.copyOf(program, program.length);
    }

    public int[] execute(int... inputs) {
        this.inputs = inputs;
        _execute();
        return workingMemory;
    }

    public void reset() {
        workingMemory = Arrays.copyOf(program, program.length);
        opCodeExecutionLocation = 0;
        inputLoc = 0;
        outputs = new LinkedList<>();
    }

    private void _execute() {
        while (true) {
            final Instruction instruction = new Instruction(workingMemory[opCodeExecutionLocation]);
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
        int mode = new Instruction(workingMemory[opCodeExecutionLocation]).getMode(param);
        final int valueAtLoc = workingMemory[opCodeExecutionLocation + param];
        return mode == 0 ? workingMemory[valueAtLoc] : valueAtLoc;
    }

    private int setParm(int param, int value) {
        final int valueAtLoc = workingMemory[opCodeExecutionLocation + param];
        workingMemory[valueAtLoc] = value;
        return value;
    }

    public List<Integer> getOutputs() {
        return outputs;
    }
}
