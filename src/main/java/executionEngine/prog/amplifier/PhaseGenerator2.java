package executionEngine.prog.amplifier;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class PhaseGenerator2 {
    public static int[][] generate(int[] phase) {
        List<int[]> result = new LinkedList<>();

        permute(result, phase,0);
        return result.toArray(new int[0][]);
    }

    private static void permute(List<int[]> result, int[] phase, int currIndex) {
        if(currIndex == phase.length){
            result.add(Arrays.copyOf(phase, phase.length));
        }
        for (int i = currIndex; i < phase.length; i++) {
                swap(phase, currIndex, i);
                permute(result,phase,currIndex+1);
                swap(phase,currIndex,i);

        }
    }

    private static void swap(int[] phase, int i, int j) {
        final int temp = phase[i];
        phase[i] = phase[j];
        phase[j] = temp;

    }

}
