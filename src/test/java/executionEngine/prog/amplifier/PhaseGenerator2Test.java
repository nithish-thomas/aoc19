package executionEngine.prog.amplifier;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class PhaseGenerator2Test {

    private int[][] generate = PhaseGenerator2.generate(new int[]{0, 1, 2, 3, 4});

    @Test
    public void printAll() {
        for (int i = 0; i < generate.length;   i++) {
            System.out.println(Arrays.toString(generate[i]));
        }
        System.out.println(generate.length);
    }

    @Test
    public void shoulHave41320() {
        hasValue(4,1,3,2,0);
    }

    @Test
    public void shoulHave120Elements() {
        assertEquals(120, generate.length);
    }

    @Test
    public void shoulHave01234() {
        hasValue(0,1,2,3,4);
    }

    @Test
    public void shoulHave13204() {
        hasValue(1,3,2,0,4);
    }

    @Test
    public void shoulHave20431() {
        hasValue(2,0,4,3,1);
    }

    @Test
    public void shoulHave43210() {
        hasValue(4,3,2,1,0);
    }


    private void hasValue(int... expected) {
        for (int[] generated:generate) {
            if(Arrays.equals(expected, generated)){
                Assert.assertTrue(true);
                return;
            }
        }
        Assert.fail();
    }
}