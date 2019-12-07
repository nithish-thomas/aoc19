package executionEngine.prog;

import executionEngine.impl.IntCode;

public class Amplifier {
    private static int NUM_OF_AMPLIFIERS = 5;

    private final IntCode amp[];

    public Amplifier(int... program) {
        amp= new IntCode[NUM_OF_AMPLIFIERS];
        for (int i = 0; i < NUM_OF_AMPLIFIERS; i++) {
            amp[i]= new IntCode(program);
        }
    }

    public long execute(int... phaseSettingForEachAmplifier){
        int outputSignalFromPrevAmplifier =0;
        for (int i = 0; i < NUM_OF_AMPLIFIERS; i++) {
            amp[i].execute(phaseSettingForEachAmplifier[i],outputSignalFromPrevAmplifier);
            outputSignalFromPrevAmplifier = amp[i].getOutputs().get(0);
        }
        return outputSignalFromPrevAmplifier;
    }


}
