package executionEngine.prog.hullPaint;

import executionEngine.impl.Input;
import executionEngine.impl.IntCode;
import executionEngine.impl.Output;
import executionEngine.impl.error.WaitingForInputException;

import java.util.HashSet;
import java.util.Set;

public class HullPaint {
    private IntCode robotBrain;

    public HullPaint(long... program) {
        robotBrain = new IntCode(program);
    }

    long paint(long[][] hull) {
        int y = hull.length/2, x = hull[0].length/2;
        Direction currentDirection = Direction.UP;
        Set<Location> locationsPainted = new HashSet<>();

        final Input input = new Input();
        final Output output = new Output();
        hull[y][x] =1;
        while (!robotBrain.hasHalted()) {
            try {
                input.addInput(hull[y][x]);
                robotBrain.execute(input,output);
            }catch (WaitingForInputException e){
                final Long color = output.getOutputQueue().remove();
                hull[y][x] = color;
                locationsPainted.add(new Location(y,x));
                final Long direction = output.getOutputQueue().remove();
                if(direction==0){
                    currentDirection = currentDirection.turnLeft();
                }else {
                    currentDirection = currentDirection.turnRight();
                }
                switch (currentDirection){
                    case UP: y--; break;
                    case RIGHT: x++; break;
                    case DOWN: y++; break;
                    case LEFT: x--; break;
                }
            }

        }
        return locationsPainted.size();
    }
}
