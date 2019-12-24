package fft;

import javafx.util.Pair;

import java.util.HashMap;

public class BasePattern2 {

    private final int[] inputs;
    private final HashMap<Pair<Integer,Integer>, Integer> cache = new HashMap<>();

    public BasePattern2(String input) {
        final int[] inputs = new int[input.length()];
        for (int i = 0; i < inputs.length; i++) {
            inputs[i] = Character.digit(input.charAt(i), 10);
        }
        this.inputs = inputs;
    }

    public BasePattern2(String stringInput, int times) {
        final int[] inputs = new int[stringInput.length() * times];
        for (int i = 0; i < times; i++) {
            for (int j = 0; j < stringInput.length(); j++) {
                inputs[(i * stringInput.length()) + j] = Character.digit(stringInput.charAt(j), 10);
            }
        }
        this.inputs = inputs;
    }

    public BasePattern2(int[] inputs) {
        this.inputs = inputs;
    }


    public int getValueAt(final int level, final int times) {
        final Pair<Integer, Integer> cacheKey = new Pair<>(level, times);
        if(cache.containsKey(cacheKey)){
            return cache.get(cacheKey);
        }

        final int phasePattern = BasePatternIterator.getPattern(level, level);
        if(phasePattern == 0 ) return 0;
        if(times == 1){
            final int result = applyPhaseForTimes1(level);
            cache.put(cacheKey, result);
            return result;
        }
        int sum = 0;
        for (int i = level-1; i <= inputs.length; i++) {
            int phasePattern2= BasePatternIterator.getPattern(i, level);
            if(phasePattern2 == 0) continue;
            sum += phasePattern2 * getValueAt(i+1, times-1);
        }
        final int result = Math.abs(sum % 10);
        cache.put(cacheKey, result);
        return result;
    }

    private int applyPhaseForTimes1(int level) {
        int sum = 0;
        for (int i = level-1; i < inputs.length; i++) {
            sum += inputs[i] * BasePatternIterator.getPattern(i, level);
        }
        return Math.abs(sum % 10);
    }


    public int getMessage2(int offset) {
        final int length = 9;
        int message = 0;
        for (int i = 0; i < length; i++) {
            final int multiplicationFactor = (int) Math.pow(10, (length - 1) - i);
            message += getValueAt(offset+i, 100) * multiplicationFactor;
        }
        return message;
    }

    private int convertToInteger(int[] digits, int start, int end) {
        int result = 0;
        final int length = end - start;
        for (int i = 0; i < length; i++) {
            final int multiplicationFactor = (int) Math.pow(10, (length - 1) - i);
            result += digits[i] * multiplicationFactor;
        }
        return result;
    }
}

