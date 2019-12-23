package executionEngine.prog.robo.repairBot;

import executionEngine.prog.robo.Direction;

import java.util.Comparator;

public class DroidState implements Comparable<DroidState>{
    final public RepairDroid droid;
    final public Direction direction;
    final public int step;

    public DroidState(RepairDroid droid, Direction direction, int step) {
        this.droid = droid;
        this.direction = direction;
        this.step = step;
    }

    public RepairDroid getDroid() {
        return droid;
    }

    public Direction getDirection() {
        return direction;
    }

    public int getStep() {
        return step;
    }


    private static final Comparator<DroidState> DROID_STATE_COMPARATOR = Comparator.comparingInt(DroidState::getStep)
      .thenComparingInt(value -> value.droid.getCurrentLocation().manhattanDistance())
      .thenComparing(Comparator.<DroidState>comparingInt(value -> value.droid.getCurrentLocation().getX()).reversed())
      .thenComparing(Comparator.<DroidState>comparingInt(value -> value.droid.getCurrentLocation().getY()).reversed())
      .thenComparing(droidState -> droidState.direction);

    @Override
    public int compareTo(DroidState o) {
        return DROID_STATE_COMPARATOR.compare(this, o);
    }
}
