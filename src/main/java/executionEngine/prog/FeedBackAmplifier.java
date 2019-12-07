package executionEngine.prog;

import executionEngine.impl.Input;
import executionEngine.impl.IntCode;
import executionEngine.impl.error.WaitingForInputException;

import static executionEngine.IntCodeUtils.getLast;

public class FeedBackAmplifier {
    private static int NUM_OF_AMPLIFIERS = 5;

    private final IntCode amp[];

    public FeedBackAmplifier(int... program) {
        amp= new IntCode[NUM_OF_AMPLIFIERS];
        for (int i = 0; i < NUM_OF_AMPLIFIERS; i++) {
            amp[i]= new IntCode(program);
        }
    }


    public long execute(int... phaseSettingForEachAmplifier){
        int outputSignalFromPrevAmplifier =0;
        while (true) {
            for (int i = 0; i < NUM_OF_AMPLIFIERS; i++) {
                try {
                    amp[i].execute(new Input(phaseSettingForEachAmplifier[i], outputSignalFromPrevAmplifier));
                    outputSignalFromPrevAmplifier = getLast(amp[i].getOutputsAsList());
                }catch (WaitingForInputException e){
                    e.printStackTrace(System.err);
                }
            }
            if(amp[NUM_OF_AMPLIFIERS-1].hasHalted()){
                return getLast(amp[NUM_OF_AMPLIFIERS - 1].getOutputsAsList());
            }
        }
    }


}
