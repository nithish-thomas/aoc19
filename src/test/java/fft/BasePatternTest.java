package fft;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class BasePatternTest {
    @Test
    public void shouldReturn48226158For12345678() {
        final BasePattern basePattern = new BasePattern("12345678");
        final int[] outputs = basePattern.applyPhaseOnce();
        assertArrayEquals(new int[]{4,8,2,2,6,1,5,8}, outputs);
    }

    @Test
    public void shouldReturn34040438For12345678With2Phases() {
        final BasePattern basePattern = new BasePattern("12345678");
        final BasePattern result = BasePattern.applyTimes(basePattern, 2);
        assertArrayEquals(new int[]{3,4,0,4,0,4,3,8}, result.getInputs());
    }

    @Test
    public void shouldReturn03415518For12345678With3Phases() {
        final BasePattern basePattern = new BasePattern("12345678");
        final BasePattern result = BasePattern.applyTimes(basePattern, 3);
        assertArrayEquals(new int[]{0,3,4,1,5,5,1,8}, result.getInputs());
    }

    @Test
    public void shouldReturn01029498For12345678With3Phases() {
        final BasePattern basePattern = new BasePattern("12345678");
        final BasePattern result = BasePattern.applyTimes(basePattern, 4);
        assertArrayEquals(new int[]{0,1,0,2,9,4,9,8}, result.getInputs());
    }

    @Test
    public void shouldReturnFirst8DigitsAs24176176For80871224585914546619083218645595With100Phases() {
        final BasePattern basePattern = new BasePattern("80871224585914546619083218645595");
        final BasePattern result = BasePattern.applyTimes(basePattern, 100);
        assertArrayEquals(new int[]{2,4,1,7,6,1,7,6}, Arrays.copyOfRange(result.getInputs(), 0 ,8));
    }

    @Test
    public void shouldReturnFirst8DigitsAs73745418For19617804207202209144916044189917With100Phases() {
        final BasePattern basePattern = new BasePattern("19617804207202209144916044189917");
        final BasePattern result = BasePattern.applyTimes(basePattern, 100);
        assertArrayEquals(new int[]{7,3,7,4,5,4,1,8}, Arrays.copyOfRange(result.getInputs(), 0 ,8));
    }

    @Test
    public void shouldReturnFirst8DigitsAs52432133For69317163492948606335995924319873With100Phases() {
        final BasePattern basePattern = new BasePattern("69317163492948606335995924319873");
        final BasePattern result = BasePattern.applyTimes(basePattern, 100);
        assertArrayEquals(new int[]{5,2,4,3,2,1,3,3}, Arrays.copyOfRange(result.getInputs(), 0 ,8));
    }

    @Test
    public void printDay16_1() {
        final BasePattern basePattern = new BasePattern("59750530221324194853012320069589312027523989854830232144164799228029162830477472078089790749906142587998642764059439173975199276254972017316624772614925079238407309384923979338502430726930592959991878698412537971672558832588540600963437409230550897544434635267172603132396722812334366528344715912756154006039512272491073906389218927420387151599044435060075148142946789007756800733869891008058075303490106699737554949348715600795187032293436328810969288892220127730287766004467730818489269295982526297430971411865028098708555709525646237713045259603175397623654950719275982134690893685598734136409536436003548128411943963263336042840301380655801969822");
        final BasePattern result = BasePattern.applyTimes(basePattern, 100);
        assertArrayEquals(new int[]{8,4,4,8,7,7,2,4}, Arrays.copyOfRange(result.getInputs(), 0 ,8));
    }

    @Test
    public void shouldReturn84462026For03036732577212944063491565474664Times10000With100Phases() {
        final BasePattern basePattern = new BasePattern("03036732577212944063491565474664",100);
        assertEquals(84462026, basePattern.getMessage2());
    }

//    @Test
//    public void testTheory1() {
//        final BasePattern basePattern = new BasePattern("1",1000);
//        assertEquals(84462026, basePattern.getMessage2());
//    }
}