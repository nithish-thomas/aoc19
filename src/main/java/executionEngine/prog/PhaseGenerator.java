package executionEngine.prog;

import java.util.Arrays;
import java.util.stream.IntStream;

public class PhaseGenerator{
    private final int phaseLength;
    private final int[] currPhase;
    private int count =0;


    public PhaseGenerator(int phaseLength) {
        this.phaseLength = phaseLength;
        this.currPhase = IntStream.rangeClosed(0,phaseLength-1).toArray();

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