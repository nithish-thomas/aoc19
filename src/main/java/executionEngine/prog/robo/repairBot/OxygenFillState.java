package executionEngine.prog.robo.repairBot;

import executionEngine.prog.robo.Direction;
import executionEngine.prog.robo.Location;

import java.util.Comparator;

public class OxygenFillState implements Comparable<OxygenFillState>{
    final public Location location;
    final public Direction direction;
    final public int step;

    public OxygenFillState(Location location, Direction direction, int step) {
        this.location = location;
        this.direction = direction;
        this.step = step;
    }

    public Location getLocation() {
        return location;
    }

    public Direction getDirection() {
        return direction;
    }

    public int getStep() {
        return step;
    }

    private static final Comparator<OxygenFillState> STATE_COMPARATOR = Comparator
      .comparingInt(OxygenFillState::getStep)
      .thenComparingInt(state -> state.location.manhattanDistance())
      .thenComparing(Comparator.<OxygenFillState>comparingInt(state -> state.location.getX()).reversed())
      .thenComparing(Comparator.<OxygenFillState>comparingInt(state -> state.location.getY()).reversed())
      .thenComparing(state -> state.direction);

    @Override
    public int compareTo(OxygenFillState o) {
        return STATE_COMPARATOR.compare(this, o);
    }
}
