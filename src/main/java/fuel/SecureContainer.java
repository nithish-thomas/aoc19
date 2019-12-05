package fuel;

import java.util.stream.IntStream;

public class SecureContainer {
    public static long numPassWords(int startRange, int endRange) {
        return IntStream.rangeClosed(startRange, endRange)
          .filter(number -> isValidPassword(number))
          .count();
    }

    private static boolean isValidPassword(int number) {
        int digits[] = parse(number);
        if (digits.length != 6) {
            return false;
        }

        if ((!hasConsecutiveSameDigitsNotPartOfAnotherGroup(digits)) || !hasStrictlyIncreasingDigits(digits)) {
            return false;
        }
        return true;
    }

    private static boolean hasConsecutiveSameDigitsNotPartOfAnotherGroup(int digits[]) {
        boolean prevWasConsecutive = false;
        final int length = digits.length;
        if(digits[0]==digits[1]&&digits[1]!=digits[2]){
            return true;
        }
        for (int i = 0; i < length - 3; i++) {
            if (nonConsecutive(digits[i], digits[i+1], digits[i+2],digits[i+3])) {
                return true;
            }
        }
        if(digits[length-1]==digits[length-2] && digits[length-2]!= digits[length-3]){
            return true;
        }
        return false;
    }

    private static boolean nonConsecutive(int digit, int digit1, int digit2, int digit4) {
        if(digit1==digit2&&digit!=digit1&&digit2!=digit4){
            return true;
        }
        return false;
    }

    private static boolean hasStrictlyIncreasingDigits(int digits[]) {
        for (int i = 0; i < digits.length - 1; i++) {
            if (digits[i] > digits[i + 1]) {
                return false;
            }
        }
        return true;
    }

    private static int[] parse(int number) {
        final char[] chars = Integer.toString(number).toCharArray();
        final int[] digits = new int[chars.length];
        for (int i = 0; i < chars.length; i++) {
            digits[i] = Integer.parseInt("" + chars[i]);
        }
        return digits;
    }
}
