package fft;

import java.util.Iterator;

class BasePatternIterator implements Iterator<Integer> {
    private final static int pattern[] = new int[]{0, 1, 0, -1};

    private final int level;
    private long currentLoc;

    BasePatternIterator(int level) {
        this.level = level;
    }

    @Override
    public boolean hasNext() {
        return true;
    }

    @Override
    public Integer next() {
        final int patternSize = pattern.length;
        return pattern[(int) ((currentLoc++/level)% patternSize)];
    }

    public static int getPattern(long currentLoc , int level) {
        final int patternSize = pattern.length;
        return pattern[(int) (((currentLoc+1)/level)% patternSize)];
    }

    public static int getPattern2(long currentLoc , int level) {
        final int patternSize = pattern.length;
        return pattern[(int) ((currentLoc/level)% patternSize)];
    }
}
