package executionEngine.impl;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class IntCodeTestOutputUtil {
    protected void expectProgramOutputToBe(long expected, IntCode intCode, long... input) {
        intCode.execute(new Input(input));
        final List<Long> outputs = intCode.getOutputsAsList();
        final Long outputsOfProgram = outputs.get(outputs.size() - 1);
        assertEquals(Long.valueOf(expected), outputsOfProgram);
    }

    protected void expectProgramOutputToBe(List<Long> expected, IntCode intCode, long... input) {
        intCode.execute(new Input(input));
        final List<Long> outputs = intCode.getOutputsAsList();
        assertEquals(expected, outputs);
    }
}
