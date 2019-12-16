package arcad;

import executionEngine.impl.IntCode;

public class Arcade {
    final IntCode program;

    public Arcade(long... intCode) {
        this.program = new IntCode(intCode);
    }

//    public char[][] play() {
//        final Output output = program.execute();
//        output.getOutputQueue().
//    }
}
