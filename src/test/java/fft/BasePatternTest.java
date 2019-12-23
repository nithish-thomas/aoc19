package fft;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class BasePatternTest {
    @Test
    public void shouldReturn48226158For12345678() {
        final BasePattern basePattern = new BasePattern("12345678");
        final int[] outputs = basePattern.applyPhaseOnce();
        assertArrayEquals(new int[]{4,8,2,2,6,1,5,8}, outputs);
    }

    @Test
    public void shouldReturn34040438For12345678With2Phases() {
        final BasePattern basePattern = new BasePattern("12345678");
        final BasePattern result = BasePattern.applyTimes(basePattern, 2);
        assertArrayEquals(new int[]{3,4,0,4,0,4,3,8}, result.getInputs());
    }

    @Test
    public void shouldReturn03415518For12345678With3Phases() {
        final BasePattern basePattern = new BasePattern("12345678");
        final BasePattern result = BasePattern.applyTimes(basePattern, 3);
        assertArrayEquals(new int[]{0,3,4,1,5,5,1,8}, result.getInputs());
    }
}