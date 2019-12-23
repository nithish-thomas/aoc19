package executionEngine.prog.robo.repairBot;

import executionEngine.prog.robo.Direction;
import executionEngine.prog.robo.Location;

import java.util.*;
import java.util.stream.Collectors;

public class DroidMapOxygenFill {
    private final long[] program;
    private final Set<OxygenFillState> toBeExploredStates = new TreeSet<>();
    private final Set<Location> unFilledLocations;
    private final Map<Location, Character> _map;
    private final Location oxygenGeneratorLocation;

    public DroidMapOxygenFill(long... program) {
        this.program = program;
        _map = Collections.unmodifiableMap(new DroidMap(program).mapAll());

        this.unFilledLocations = _map.entrySet().stream()
//          .filter(locationCharacterEntry -> 'O' != locationCharacterEntry.getValue())
          .map(Map.Entry::getKey).collect(Collectors.toSet());

        oxygenGeneratorLocation = _map.entrySet().stream()
          .filter(locationEntry -> 'O' == locationEntry.getValue())
          .findFirst().get().getKey();
    }

    private boolean addToStateAllPossibleMoves(Location location, int step) {
        if(unFilledLocations.contains(location)) {
            unFilledLocations.remove(location);
            addState(location, Direction.UP, step + 1);
            addState(location, Direction.DOWN, step + 1);
            addState(location, Direction.LEFT, step + 1);
            addState(location, Direction.RIGHT, step + 1);
            return true;
        }
        return false;
    }

    private boolean addState(Location location, Direction direction, int step) {
        return toBeExploredStates.add(new OxygenFillState(location, direction, step));
    }


    public long timeTakenForOxygen() {
        addToStateAllPossibleMoves(oxygenGeneratorLocation, 0);
        return fillLocation();
    }

    private long fillLocation() {
        long maxStep = 0;
        while (!unFilledLocations.isEmpty() && !toBeExploredStates.isEmpty()){
            final Iterator<OxygenFillState> iterator = toBeExploredStates.iterator();
            final OxygenFillState state = iterator.next();
            iterator.remove();

            if(addToStateAllPossibleMoves(state.location.newLocation(state.direction), state.step)) {
                maxStep = maxStep < state.step? state.step : maxStep;
            }
        }
        return maxStep;
    }


}
