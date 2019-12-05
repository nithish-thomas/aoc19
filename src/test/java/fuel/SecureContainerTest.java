package fuel;

import org.junit.Test;

import static org.junit.Assert.*;

public class SecureContainerTest {
    @Test
    public void expectNumOfPasswordsToBeZeroIfTheStartAndEndIsWithinTheSameRegionAndItIsNotAPassword() {
        assertEquals(0, SecureContainer.numPassWords(1315678,1135678));
    }

    @Test
    public void expectNumOfPasswordsToBeOneIfTheStartAndEndIsWithinTheSameRegionAndItIsAPassword() {
        assertEquals(1, SecureContainer.numPassWords(135578,135578));
    }

    @Test
    public void expectNumOfPasswordsToBeZeroIfTheStartAndEndIsWithinTheSameRegionAndItIsNotAPasswordWithAdjacentDigits() {
        assertEquals(0, SecureContainer.numPassWords(135678,135678));
    }

    @Test
    public void expectNumOfPasswordsToBeZeroIfTheStartAndEndIsWithinTheSameRegionAndItIsNotAPasswordWithStrictlyIncreasingDigits() {
        assertEquals(0, SecureContainer.numPassWords(135576,135576));
    }

    @Test
    public void expectNumOfPasswordsToBeZeroIfTheStartAndEndIsSameForNumber111111() {
        final int number = 111111;
        assertEquals(0, SecureContainer.numPassWords(number, number));
    }

    @Test
    public void expectNumOfPasswordsToBeZeroIfTheStartAndEndIsSameForNumber223450() {
        final int number = 223450;
        assertEquals(0, SecureContainer.numPassWords(number, number));
    }

    @Test
    public void expectNumOfPasswordsToBeZeroIfTheStartAndEndIsSameForNumber123789() {
        final int number = 123789;
        assertEquals(0, SecureContainer.numPassWords(number, number));
    }

    @Test
    public void expectNumOfPasswordsToBeOneIfTheStartAndEndIsSameForNumber112233() {
        final int number = 112233;
        assertEquals(1, SecureContainer.numPassWords(number, number));
    }

    @Test
    public void expectNumOfPasswordsToBeZeroIfTheStartAndEndIsSameForNumber123444() {
        final int number = 123444;
        assertEquals(0, SecureContainer.numPassWords(number, number));
    }

    @Test
    public void expectNumOfPasswordsToBeOneIfTheStartAndEndIsSameForNumber111122() {
        final int number = 111122;
        assertEquals(1, SecureContainer.numPassWords(number, number));
    }

    @Test
    public void printPuzzle_1() {
        System.out.println(SecureContainer.numPassWords(136760, 595730));
    }
}