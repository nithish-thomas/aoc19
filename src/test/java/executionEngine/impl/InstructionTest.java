package executionEngine.impl;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class InstructionTest {
    @Test
    public void expectOpCodeToBeCalculated() {
        assertEquals(2, new Instruction(1002).getOpCode());
        assertEquals(2, new Instruction(2).getOpCode());
        assertEquals(1, new Instruction(1011001).getOpCode());
        assertEquals(99, new Instruction(1099).getOpCode());
    }

    @Test
    public void expectOpCodeFor21102() {
        final Instruction instruction = new Instruction(21102);
        assertEquals(2, instruction.getOpCode());
        assertEquals(1, instruction.getMode(1));
        assertEquals(1, instruction.getMode(2));
        assertEquals(2, instruction.getMode(3));
    }

    @Test
    public void expectPositionModeToBeCalculated() {
        assertEquals(0, new Instruction(1002).getMode(1));
        assertEquals(1, new Instruction(1002).getMode(2));
    }
}