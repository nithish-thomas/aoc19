package executionEngine.prog.robo.repairBot;

import executionEngine.prog.robo.Direction;
import executionEngine.prog.robo.Location;

import java.util.*;

public class DroidMap {
    private final long[] program;
    private final Set<DroidState> unexploredStates = new TreeSet<>();
    private final Map<Location, Character> visitedLocation = new HashMap<>();

    public DroidMap(long... program) {
        this.program = program;
    }

    private void addToStateAllPossibleMoves(RepairDroid droid, int step) {
        if(!visitedLocation.keySet().contains(droid.getCurrentLocation())) {
            visitedLocation.put(droid.getCurrentLocation(), '_');
            addState(droid, Direction.UP, step + 1);
            addState(droid, Direction.DOWN, step + 1);
            addState(droid, Direction.LEFT, step + 1);
            addState(droid, Direction.RIGHT, step + 1);
        }
    }

    private boolean addState(RepairDroid droid, Direction up, int step) {
        return unexploredStates.add(new DroidState(droid.cloneDrone(), up, step));
    }

    public int nearestPathToOxygenSystem() {
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

    public Map<Location, Character> mapAll() {
        addToStateAllPossibleMoves(new RepairDroid(program), 0);
        while (!unexploredStates.isEmpty()) {
            final Iterator<DroidState> iterator = unexploredStates.iterator();
            final DroidState state = iterator.next();
            iterator.remove();
            final long result = state.droid.move(state.direction);
            if (result == 1) {
                addToStateAllPossibleMoves(state.droid, state.step);
            }
            if (result == 2) {
                visitedLocation.put(state.droid.getCurrentLocation(), 'O');
            }
        }
        return visitedLocation;
    }




}
