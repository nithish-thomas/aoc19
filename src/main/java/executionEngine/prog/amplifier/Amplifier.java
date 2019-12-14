package executionEngine.prog.amplifier;

import executionEngine.impl.Input;
import executionEngine.impl.IntCode;
import executionEngine.impl.Output;

import static executionEngine.IntCodeUtils.getLast;

public class Amplifier {
    private static int NUM_OF_AMPLIFIERS = 5;

    private final IntCode amp[];

    public Amplifier(long... program) {
        amp= new IntCode[NUM_OF_AMPLIFIERS];
        for (int i = 0; i < NUM_OF_AMPLIFIERS; i++) {
            amp[i]= new IntCode(program);
        }
    }

    public long execute(int... phaseSettingForEachAmplifier){
        long outputSignalFromPrevAmplifier =0;
        for (int i = 0; i < NUM_OF_AMPLIFIERS; i++) {
            final Input input = new Input(phaseSettingForEachAmplifier[i], outputSignalFromPrevAmplifier);
            amp[i].reset();
            amp[i].execute(input);
            final Output output = amp[i].getOutput();
            outputSignalFromPrevAmplifier = getLast(output.getOutputQueue());
        }
        return outputSignalFromPrevAmplifier;
    }


}
