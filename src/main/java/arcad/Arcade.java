package arcad;

import executionEngine.impl.Input;
import executionEngine.impl.IntCode;
import executionEngine.impl.Output;
import executionEngine.impl.error.WaitingForInputException;

import java.util.*;

public class Arcade {
    final IntCode program;

    public Arcade(long... intCode) {
        this.program = new IntCode(intCode);
    }

    public static void printScreen(char[][] finalOut) {
        for (int i = 0; i < finalOut.length; i++) {
            System.out.println(Arrays.toString(finalOut[i]));
        }
    }

    public char[][] playNonInteractive() {
        final Output output = program.execute();
        final LinkedList<Long> outputs = output.getOutputQueue();
        return convertToScreenCharArray(getScreen(outputs));
    }

    private char[][] convertToScreenCharArray(LinkedHashSet<ScreenOutputs> screen) {


        final OptionalInt maxLeft = screen.parallelStream()
          .mapToInt(ScreenOutputs::getLeft)
          .max();
        final OptionalInt maxTop = screen.parallelStream()
          .mapToInt(ScreenOutputs::getTop)
          .max();

        char[][] res = new char[maxTop.getAsInt() + 1][maxLeft.getAsInt() + 1];

        for (int i = 0; i < res.length; i++) {
            Arrays.fill(res[i], ' ');
        }
        screen.stream()
          .filter(screenOutputs -> !screenOutputs.equals(ScreenOutputs.SCORE_SCREEN))
          .forEachOrdered(screenOutputs -> {
              res[screenOutputs.getTop()][screenOutputs.getLeft()] = screenOutputs.getOutputAsChar();
          });

        return res;
    }

    private LinkedHashSet<ScreenOutputs> getScreen(List<Long> outputs) {
        final Iterator<Long> iterator = outputs.iterator();
        final LinkedHashSet<ScreenOutputs> screen = new LinkedHashSet<>();
        while (iterator.hasNext()) {
            final Long left = iterator.next();
            final Long top = iterator.next();
            final Long item = iterator.next();
            final ScreenOutputs screenOutput = new ScreenOutputs(left, top, item);
            screen.add(screenOutput);
        }
        return screen;
    }


    public void playInteractive() {
        final Scanner scanner = new Scanner(System.in);

        final Output output = new Output();
        while (!program.hasHalted()) {
            try {
                System.out.println("Enter ");
                final String consoleInput = scanner.nextLine();
                final int i = Integer.parseInt(consoleInput);
                program.execute(new Input(i), output);
            } catch (WaitingForInputException e) {
                final LinkedList<Long> outputs = program.getOutput().getOutputQueue();
//                outputs.subList(2283,2295)
                final char[][] chars = convertToScreenCharArray(getScreen(outputs));
                System.out.println();
                System.out.println();
                printScreen(chars);
                System.out.println();
                System.out.println();
            }
        }

        final LinkedList<Long> outputs = program.getOutputsAsList();
        final Optional<ScreenOutputs> score = getScreen(outputs).parallelStream()
          .filter(screen -> screen.equals(ScreenOutputs.SCORE_SCREEN))
          .findFirst();

        System.out.println("SCOre");
        System.out.println(score.get().getOutput());
    }
}
