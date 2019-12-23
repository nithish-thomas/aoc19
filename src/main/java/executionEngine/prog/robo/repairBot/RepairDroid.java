package executionEngine.prog.robo.repairBot;

import executionEngine.impl.Input;
import executionEngine.impl.IntCode;
import executionEngine.impl.error.WaitingForInputException;
import executionEngine.prog.robo.Direction;
import executionEngine.prog.robo.Location;

public class RepairDroid {
    private final IntCode program;
    private Location currentLocation = new Location(0,0);

    public RepairDroid(long... program) {
        this.program = new IntCode(program);
    }
    public RepairDroid(IntCode program) {
        this.program = program;
    }

    /**
     *
     * @param direction north : UP, south: down, west: left, east: right
     * @return
     */
    public long move(Direction direction){
        try {
            program.execute(new Input(covertToInput(direction)));
        }catch (WaitingForInputException e){
        }
        final long output = program.getOutputsAsList().get(0);
        if(output!=0){
            currentLocation = currentLocation.newLocation(direction);
        }
        return output;
    }

    public Location getCurrentLocation() {
        return currentLocation;
    }

    private static int covertToInput(Direction direction){
        switch (direction){
            case UP: return 1;
            case DOWN: return 2;
            case LEFT: return 3;
            case RIGHT: return 4;
        }
        return 0;
    }

    public RepairDroid cloneDrone(){
        final RepairDroid repairDroid = new RepairDroid(program.clone());
        repairDroid.currentLocation = currentLocation;
        return repairDroid;
    }
}
