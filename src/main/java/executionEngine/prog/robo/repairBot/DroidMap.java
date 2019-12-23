package executionEngine.prog.robo.repairBot;

import executionEngine.prog.robo.Direction;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class DroidMap {
    private final Set<DroidState> states = new TreeSet<>();
    private final long[] program;

    public DroidMap(long... program) {
        this.program = program;
    }

    private void playAllPossibleMoves(RepairDroid droid, int step) {
        states.add(new DroidState(droid.cloneDrone(), Direction.UP, step + 1));
        states.add(new DroidState(droid.cloneDrone(), Direction.DOWN, step + 1));
        states.add(new DroidState(droid.cloneDrone(), Direction.LEFT, step + 1));
        states.add(new DroidState(droid.cloneDrone(), Direction.RIGHT, step + 1));
    }

    public int play() {
        playAllPossibleMoves(new RepairDroid(program), 0);
        while (!states.isEmpty()) {
            final Iterator<DroidState> iterator = states.iterator();
            final DroidState state = iterator.next();
            iterator.remove();
            final long result = state.droid.move(state.direction);
            if (result == 0) return Integer.MAX_VALUE;
            if (result == 2) return state.step;
            playAllPossibleMoves(state.droid, state.step);
        }
        return Integer.MAX_VALUE;
    }


}
