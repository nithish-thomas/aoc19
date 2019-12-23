package arcad;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class ScreenOutputs {
    private final int left, top;
    private final long output;

    public ScreenOutputs(int left, int top, int output) {
        this.left = left;
        this.top = top;
        this.output = output;
    }
    public ScreenOutputs(long left, long top, long output) {
        this.left = Math.toIntExact(left);
        this.top = Math.toIntExact(top);
        this.output = output;
    }

    private static char getOutputChar(int output) {
        switch (output){
            case 0: return ' ';
            case 1: return 'w';
            case 2: return 'o';
            case 3: return 'h';
            case 4: return 'b';
        }
        return ' ';
    }

    public int getLeft() {
        return left;
    }

    public int getTop() {
        return top;
    }

    public char getOutputAsChar() {
        return getOutputChar(Math.toIntExact(output));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ScreenOutputs that = (ScreenOutputs) o;
        return left == that.left &&
          top == that.top;
    }

    @Override
    public int hashCode() {
        return Objects.hash(left, top);
    }

    public long getOutput() {
        return output;
    }

    public static final ScreenOutputs SCORE_SCREEN = new ScreenOutputs(-1, 0 , 0);

    public static List<ScreenOutputs> convertToScreenOutput(List<Long> outputs){
        List<ScreenOutputs> outputsList = new LinkedList<>();
        final Iterator<Long> iterator = outputs.iterator();
        while (iterator.hasNext()) {
            final Long left = iterator.next();
            final Long top = iterator.next();
            final Long item = iterator.next();
            outputsList.add(new ScreenOutputs(left, top, item));
        }
        return outputsList;
    }
}
