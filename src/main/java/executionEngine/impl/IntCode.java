package executionEngine.impl;

import java.util.LinkedList;

public class IntCode {
    private final long[] program;
    private Output output = new Output();

    private Memory workingMemory;
    private Input input;
    private int opCodeExecutionLocation = 0;
    private int relativeBase = 0;


    public IntCode(long... program) {
        this.program = program;
        workingMemory = Memory.create(program);
    }

    public Output execute() {
        return execute(new Input());
    }

    public Output execute(Input input) {
        return execute(input, new Output());
    }

    public Output execute(Input input, Output output) {
        this.input = input;
        this.output = output;
        _execute();
        return this.output;
    }

    public long[] getWorkingMemory() {
        return workingMemory.getAsArray();
    }

    public void reset() {
        workingMemory = Memory.create(program);
        opCodeExecutionLocation = 0;
        relativeBase = 0;
        output = new Output();
    }

    public boolean hasHalted() {
        return getCurrentInstruction().getOpCode() == 99;
    }

    private void _execute() {
        while (true) {
            final Instruction instruction = getCurrentInstruction();
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
                case 9:
                    relativeBaseAdjust();
                    break;

                default:
                    throw new RuntimeException("Int code exception");
            }
        }

    }

    private void relativeBaseAdjust() {
        final long param1 = getParam(1);
        relativeBase += param1;
        opCodeExecutionLocation += 2;
    }

    private Instruction getCurrentInstruction() {
        return new Instruction(workingMemory.getValueAt(opCodeExecutionLocation));
    }

    private void opEquals() {
        final long param1 = getParam(1);
        final long param2 = getParam(2);
        setParm(3, param1 == param2 ? 1 : 0);
        opCodeExecutionLocation += 4;
    }

    private void lessThan() {
        final long param1 = getParam(1);
        final long param2 = getParam(2);
        setParm(3, param1 < param2 ? 1 : 0);
        opCodeExecutionLocation += 4;
    }

    private void jumpIfFalse() {
        final long param1 = getParam(1);
        if (param1 == 0) {
            opCodeExecutionLocation = (int) getParam(2);
        } else {
            opCodeExecutionLocation += 3;
        }
    }

    private void jumpIfTrue() {
        final long param1 = getParam(1);
        if (param1 != 0) {
            opCodeExecutionLocation = (int) getParam(2);
        } else {
            opCodeExecutionLocation += 3;
        }
    }

    private void output() {
        output.add(getParam(1));
        opCodeExecutionLocation += 2;
    }

    private void input() {
        setParm(1, input.getInputsWithException());
        opCodeExecutionLocation += 2;
    }

    private void add() {
        final long parm1 = getParam(1);
        final long parm2 = getParam(2);
        final long result = parm1 + parm2;
        setParm(3, result);

        opCodeExecutionLocation += 4;
    }

    private void multiply() {
        final long parm1 = getParam(1);
        final long parm2 = getParam(2);
        final long result = parm1 * parm2;
        setParm(3, result);

        opCodeExecutionLocation += 4;
    }

    private long getParam(int param) {
        int mode = getCurrentInstruction().getMode(param);
        final long valueAtLoc = workingMemory.getValueAt(opCodeExecutionLocation + param);
        switch (mode) {
            case 0:
                return workingMemory.getValueAt(valueAtLoc);
            case 1:
                return valueAtLoc;
            case 2:
                return workingMemory.getValueAt(relativeBase + valueAtLoc);
            default:
                throw new RuntimeException("Mode not known");
        }
    }

    private long setParm(int param, long value) {
        int mode = getCurrentInstruction().getMode(param);
        final long valueAtLoc = workingMemory.getValueAt(opCodeExecutionLocation + param);
        switch (mode) {
            case 0:
                return workingMemory.setValueAt(valueAtLoc, value);
            case 2:
                return workingMemory.setValueAt(relativeBase + valueAtLoc, value);
            default:
                throw new RuntimeException("Mode not known");
        }
    }

    public LinkedList<Long> getOutputsAsList() {
        return new LinkedList<>(output.getOutputQueue());
    }

    public Output getOutput() {
        return output;
    }
}
