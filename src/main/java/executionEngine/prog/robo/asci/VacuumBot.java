package executionEngine.prog.robo.asci;

import executionEngine.impl.IntCode;
import executionEngine.impl.Output;

import java.util.HashMap;
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
        final Output camOut = program.execute();
        camOut.getOutputQueue().stream()
          .map(value->Character.valueOf((char)(int)(long)value))
          .forEachOrdered(result::append);

        return result.toString();
    }
}
