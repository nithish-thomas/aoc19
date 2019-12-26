package executionEngine.prog.robo.asci;

import executionEngine.impl.IntCode;
import executionEngine.impl.Output;
import executionEngine.prog.robo.Location;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class VacuumBot {
    private final IntCode program;
    private static final Map<Long, Character> codeToCharMapping= new HashMap<>();
    {
        codeToCharMapping.put(35L,'#');
        codeToCharMapping.put(46L,'.');
        codeToCharMapping.put(10L,'\n');
    }

    public VacuumBot(long... program) {
        this.program = new IntCode(program);
    }

    public String printCamera() {
        StringBuilder result = new StringBuilder();
        final Output camOut = program.getOutput();
        camOut.getOutputQueue().stream()
          .map(value-> (char) (int) (long) value)
          .forEachOrdered(result::append);

        return result.toString();
    }

    public Output execute() {
        return program.execute();
    }

    public int alignmentParameters() {
        final String cameraOut = printCamera();
        final char[][] cameraArray = ASCIMap.convertToArray(cameraOut);

        final List<Location> intersection = getIntersection(cameraArray);
        return intersection.stream()
          .mapToInt(location-> location.getX()*location.getY())
          .sum();
    }

    private List<Location> getIntersection(char[][] cameraArray) {
        List<Location> result = new LinkedList<>();
        for (int i = 1; i < cameraArray.length-1; i++) {
            for (int j = 1; j < cameraArray[i].length-1; j++) {
                if(cameraArray[i][j] != '#') continue;
                if(cameraArray[i-1][j] != '#') continue;
                if(cameraArray[i][j-1] != '#') continue;
                if(cameraArray[i+1][j] != '#') continue;
                if(cameraArray[i][j+1] != '#') continue;
                result.add(new Location(i,j));
            }
        }
        return result;
    }
}
