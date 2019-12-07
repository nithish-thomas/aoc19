package executionEngine.prog;

import executionEngine.impl.IntCode;

import java.util.Arrays;

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

    public static class PhaseGenerator{
        private final int phaseLength;
        private final int[] currPhase;


        public PhaseGenerator(int phaseLength) {
            this.phaseLength = phaseLength;
            this.currPhase = new int[phaseLength];
            Arrays.fill(currPhase,0);
        }

        public int[] next(){
            int[] res = Arrays.copyOf(currPhase, currPhase.length);
            for (int i = 0; i < phaseLength; i++) {
                if(canIncrementPhaseAt(i)){
                    currPhase[i]++;
                    if(i>0) {
                        currPhase[i-1]=0;
                    }
                    break;
                }
            }
            return res;
        }

        public boolean hasNext(){
            for (int i = 0; i < phaseLength; i++) {
                if(canIncrementPhaseAt(i)){
                    return true;
                }
            }
            return false;
        }

        private boolean canIncrementPhaseAt(int i) {
            return currPhase[i] < 4;
        }

    }
}
