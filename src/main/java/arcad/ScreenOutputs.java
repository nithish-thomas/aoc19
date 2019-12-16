package arcad;

import java.util.Objects;

public class ScreenOutputs {
    private final int left, top;
    private final char output;

    public ScreenOutputs(int left, int top, int output) {
        this.left = left;
        this.top = top;
        this.output = getOutputChar(output);
    }
    public ScreenOutputs(long left, long top, long output) {
        this.left = Math.toIntExact(left);
        this.top = Math.toIntExact(top);
        this.output = getOutputChar(Math.toIntExact(output));
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

    public char getOutput() {
        return output;
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
}
