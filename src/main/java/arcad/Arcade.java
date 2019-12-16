package arcad;

import executionEngine.impl.IntCode;
import executionEngine.impl.Output;

import java.util.*;

public class Arcade {
    final IntCode program;

    public Arcade(long... intCode) {
        this.program = new IntCode(intCode);
    }

    public char[][] play() {
        final Output output = program.execute();
        final LinkedList<Long> outputs = output.getOutputQueue();
        final Iterator<Long> iterator = outputs.iterator();
        final LinkedHashSet<ScreenOutputs> screen = new LinkedHashSet<>();
        while (iterator.hasNext()){
            final Long left = iterator.next();
            final Long top = iterator.next();
            final Long item = iterator.next();
            final ScreenOutputs screenOutput = new ScreenOutputs(left, top, item);
            screen.add(screenOutput);
        }


        final OptionalInt maxLeft = screen.parallelStream()
          .mapToInt(ScreenOutputs::getLeft)
          .max();
        final OptionalInt maxTop = screen.parallelStream()
          .mapToInt(ScreenOutputs::getTop)
          .max();

        char[][] res = new char[maxTop.getAsInt()+1][maxLeft.getAsInt()+1];

        for (int i = 0; i < res.length; i++) {
            Arrays.fill(res[i],' ');
        }
        screen.stream()
          .forEachOrdered(screenOutputs -> {
              res[screenOutputs.getTop()][screenOutputs.getLeft()] = screenOutputs.getOutput();
          });

        return res;
    }

//    public void playInteractive(){
//        try {
//            play();
//        }
//    }
}
