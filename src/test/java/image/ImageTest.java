package image;

import input_files.FileUtils;
import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ImageTest {

    @Test
    public void shouldPrintPuzzleDay8() throws IOException, URISyntaxException {
        final List<Integer> integers = FileUtils.readClassPathResourceAsListOfSingleDigits("input8_1.txt");
        final Image image = Image.createImage(25, 6, integers);

        final Layer leastCorruptedLayer = image.findLeastCorruptedLayer();

        int numOf1Digit = 0, numOf2Digit = 0;
        for (Integer sifCode : leastCorruptedLayer.getaSifCodedLayer()) {
            switch (sifCode.intValue()) {
                case 1:
                    numOf1Digit++;
                    break;
                case 2:
                    numOf2Digit++;
                    break;
            }
        }
        System.out.println(numOf1Digit*numOf2Digit);

        assertEquals(2286,numOf1Digit*numOf2Digit);

    }

}