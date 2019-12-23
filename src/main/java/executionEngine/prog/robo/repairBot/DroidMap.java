package executionEngine.prog.robo.repairBot;

import executionEngine.prog.robo.Direction;
import executionEngine.prog.robo.Location;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class DroidMap {
    private final Set<DroidState> unexploredStates = new TreeSet<>();
    private final Set<Location> visitedLocation = new HashSet<>();
    private final long[] program;

    public DroidMap(long... program) {
        this.program = program;
    }

    private void addToStateAllPossibleMoves(RepairDroid droid, int step) {
        if(visitedLocation.add(droid.getCurrentLocation())) {
            addState(droid, Direction.UP, step + 1);
            addState(droid, Direction.DOWN, step + 1);
            addState(droid, Direction.LEFT, step + 1);
            addState(droid, Direction.RIGHT, step + 1);
        }
    }

    private boolean addState(RepairDroid droid, Direction up, int step) {
        return unexploredStates.add(new DroidState(droid.cloneDrone(), up, step));
    }

    public int play() {
        addToStateAllPossibleMoves(new RepairDroid(program), 0);
        while (!unexploredStates.isEmpty()) {
            final Iterator<DroidState> iterator = unexploredStates.iterator();
            final DroidState state = iterator.next();
            iterator.remove();
            final long result = state.droid.move(state.direction);
            if (result == 1) {
                addToStateAllPossibleMoves(state.droid, state.step);
            }
            if (result == 2) return state.step;
        }
        return Integer.MAX_VALUE;
    }


}
