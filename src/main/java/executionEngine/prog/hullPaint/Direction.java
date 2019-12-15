package executionEngine.prog.hullPaint;

public enum Direction {
    UP, RIGHT, DOWN, LEFT;

    public Direction turnRight() {
        switch (this) {
            case UP:
                return RIGHT;
            case RIGHT:
                return DOWN;
            case DOWN:
                return LEFT;
            case LEFT:
                return UP;
        }
        return null;
    }

    public Direction turnLeft() {
        switch (this) {
            case UP:
                return LEFT;
            case LEFT:
                return DOWN;
            case DOWN:
                return RIGHT;
            case RIGHT:
                return UP;
        }
        return null;
    }
}
