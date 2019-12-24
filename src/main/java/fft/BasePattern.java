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

    public BasePattern(String stringInput, int times) {
        final int[] inputs = new int[stringInput.length() * times];
        for (int i = 0; i < times; i++) {
            for (int j = 0; j < stringInput.length(); j++) {
                inputs[(i * stringInput.length()) + j] = Character.digit(stringInput.charAt(j), 10);
            }
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

    public int getMessage2() {
        final BasePattern basePatternWithOffset = applyTimes(this, 100);
        final int offset = convertToInteger(basePatternWithOffset.inputs, 0, 7);

        return  convertToInteger(basePatternWithOffset.inputs, offset, offset + 8);
    }

    private int convertToInteger(int[] digits, int start, int end) {
        int result = 0;
        final int length = end - start;
        for (int i = 0; i < length; i++) {
            final int multiplicationFactor = (int) Math.pow(10,  (length - 1)-i);
            result += digits[i] * multiplicationFactor;
        }
        return result;
    }
}

