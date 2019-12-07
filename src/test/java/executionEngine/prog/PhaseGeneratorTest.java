package executionEngine.prog;

import org.junit.Test;

import java.util.Arrays;

public class PhaseGeneratorTest {

    @Test
    public void printAllPhases() {
        final PhaseGenerator phaseGenerator = new PhaseGenerator(5);
        while (phaseGenerator.hasNext()){
            final int[] next = phaseGenerator.next();
            System.out.println(Arrays.toString(next));
        }
    }
}