package fft;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BasePattern2Test {
    @Test
    public void shouldPrint6WhenFor5thDigitForInput12345678Phased1Time() {
        final int valueAt = new BasePattern2(new int[]{1, 2, 3, 4, 5, 6, 7, 8}).getValueAt(5, 1);
        assertEquals(6, valueAt);
    }

    @Test
    public void shouldPrint2WhenFor3thDigitForInput12345678Phased1Time() {
        final int valueAt = new BasePattern2(new int[]{1, 2, 3, 4, 5, 6, 7, 8}).getValueAt(3, 1);
        assertEquals(2, valueAt);
    }

    @Test
    public void shouldPrint8WhenFor8thDigitForInput12345678Phased1Time() {
        final int valueAt = new BasePattern2(new int[]{1, 2, 3, 4, 5, 6, 7, 8}).getValueAt(8, 1);
        assertEquals(8, valueAt);
    }

    @Test
    public void shouldPrint8WhenFor8thDigitForInput12345678Phased2Time() {
        final int valueAt = new BasePattern2(new int[]{1, 2, 3, 4, 5, 6, 7, 8}).getValueAt(8, 2);
        assertEquals(8, valueAt);
    }

    @Test
    public void shouldPrint0WhenFor3thDigitForInput12345678Phased2Time() {
        final int valueAt = new BasePattern2(new int[]{1, 2, 3, 4, 5, 6, 7, 8}).getValueAt(3, 2);
        assertEquals(0, valueAt);
    }

    @Test
    public void shouldPrint4WhenFor6thDigitForInput12345678Phased4Time() {
        final int valueAt = new BasePattern2(new int[]{1, 2, 3, 4, 5, 6, 7, 8}).getValueAt(6, 4);
        assertEquals(4, valueAt);
    }

    @Test
    public void shouldFindAnswerForPart2Ex1() {
        final int valueAt = new BasePattern2("03036732577212944063491565474664", 10000).getMessage2(303673);
        assertEquals(84462026, valueAt);
    }

    @Test
    public void printDay16_2() {
        final BasePattern2 basePattern2 = new BasePattern2("59750530221324194853012320069589312027523989854830232144164799228029162830477472078089790749906142587998642764059439173975199276254972017316624772614925079238407309384923979338502430726930592959991878698412537971672558832588540600963437409230550897544434635267172603132396722812334366528344715912756154006039512272491073906389218927420387151599044435060075148142946789007756800733869891008058075303490106699737554949348715600795187032293436328810969288892220127730287766004467730818489269295982526297430971411865028098708555709525646237713045259603175397623654950719275982134690893685598734136409536436003548128411943963263336042840301380655801969822", 10000);
        final int valueAt = basePattern2.getMessage2(5975053);
        assertEquals(84462026, valueAt);
    }
}