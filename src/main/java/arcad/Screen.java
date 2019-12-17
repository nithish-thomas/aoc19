package arcad;

import java.util.*;

public class Screen {
    LinkedHashSet<ScreenOutputs> buffer= new LinkedHashSet();

    public void addToBuffer(List<Long> outputs){
        final Iterator<Long> iterator = outputs.iterator();
        while (iterator.hasNext()) {
            final Long left = iterator.next();
            final Long top = iterator.next();
            final Long item = iterator.next();
            final ScreenOutputs screenOutput = new ScreenOutputs(left, top, item);
            buffer.remove(screenOutput);
            buffer.add(screenOutput);
        }
    }

    public char[][] convertToScreenCharArray() {
        final OptionalInt maxLeft = buffer.parallelStream()
          .mapToInt(ScreenOutputs::getLeft)
          .max();
        final OptionalInt maxTop = buffer.parallelStream()
          .mapToInt(ScreenOutputs::getTop)
          .max();

        char[][] res = new char[maxTop.getAsInt() + 1][maxLeft.getAsInt() + 1];

        for (int i = 0; i < res.length; i++) {
            Arrays.fill(res[i], ' ');
        }
        buffer.stream()
          .filter(screenOutputs -> !screenOutputs.equals(ScreenOutputs.SCORE_SCREEN))
          .forEachOrdered(screenOutputs -> {
              res[screenOutputs.getTop()][screenOutputs.getLeft()] = screenOutputs.getOutputAsChar();
          });

        return res;
    }

    public void printScreen() {
        char[][] finalOut = convertToScreenCharArray();
        System.out.println();
        System.out.println();
        for (int i = 0; i < finalOut.length; i++) {
            System.out.println(Arrays.toString(finalOut[i]));
        }
        System.out.println();
        System.out.println();
    }
}
