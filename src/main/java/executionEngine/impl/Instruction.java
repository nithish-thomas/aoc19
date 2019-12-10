package executionEngine.impl;

/**
 * ABCDE
 *  1002
 *
 * DE - two-digit opcode,      02 == opcode 2
 *  C - mode of 1st parameter,  0 == position mode
 *  B - mode of 2nd parameter,  1 == immediate mode
 *  A - mode of 3rd parameter,  0 == position mode,
 *                                   omitted due to being a leading zero
 */
public class Instruction {
    private final long code;

    public Instruction(long code) {
        this.code = code;
    }

    public int getOpCode() {
        return (int) (code % 100);
    }

    public int getMode(int position) {
        final int multiplication = (int) (Math.pow(10,position) * 100);
        final long mode = (code % multiplication )/(multiplication/10) ;
        return (int) mode;
    }

}
