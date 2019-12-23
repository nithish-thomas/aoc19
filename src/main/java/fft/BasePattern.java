package fft;

import java.util.Arrays;

public class BasePattern {

    private final int[] inputs;

    public BasePattern(String input) {
        final int[] inputs = new int[input.length()];
        for (int i = 0; i < inputs.length; i++) {
            inputs[i] = Character.digit(input.charAt(i), 10);
        }
        this.inputs = inputs;
    }

    public BasePattern(int[] inputs) {
        this.inputs = inputs;
    }

    private static int output(int[] inputs, int level) {
        BasePatternIterator iterator = new BasePatternIterator(level);
        iterator.next();
        int sum = 0;
        for (int i = 0; i < inputs.length; i++) {
            sum += inputs[i] * iterator.next();
        }
        return Math.abs(sum % 10);
    }

    public static BasePattern applyTimes(BasePattern pattern, int times) {
        BasePattern result = pattern;
        for (int i = 0; i < times; i++) {
            final int[] outputs = result.applyPhaseOnce();
            result = new BasePattern(outputs);
        }
        return result;
    }

    public int[] getInputs() {
        return Arrays.copyOf(inputs, inputs.length);
    }

    public int[] applyPhaseOnce() {
        final int[] result = new int[inputs.length];

        for (int i = 0; i < inputs.length; i++) {
            result[i] = output(inputs, i + 1);
        }
        return result;
    }
}

