package helper;

import java.security.SecureRandom;
import java.util.Random;

public class TCKNHelper {

    protected String getTckn() {
        Random rnd = new SecureRandom();
        Integer pool1 = Integer.valueOf(String.valueOf(Math.floor(rnd.nextDouble() * 90000 + 10000)));
        String[] p1Chars = toStringArray(pool1);
        Integer pool1Sum = arraySum(p1Chars);
        Integer pool2 = Integer.valueOf(String.valueOf(Math.floor(rnd.nextDouble()  * 9000 + 1000)));
        String[] p2Chars = toStringArray(pool2);
        Integer pool2Sum = arraySum(p2Chars);
        int digit10 = calculateDigit10(pool1Sum, pool2Sum);
        int digit11 = calculateDigit11(pool1Sum, pool2Sum, digit10);
        return p1Chars[0] + p2Chars[0] + p1Chars[1] + p2Chars[1] + p1Chars[2] + p2Chars[2] + p1Chars[3] + p2Chars[3] + p1Chars[4] + digit10 + digit11;
    }

    protected String[] toStringArray(Integer integer) {
        String string = integer.toString();
        char[] chars = string.toCharArray();
        String[] strings = new String[chars.length];
        for (int i = 0; i < chars.length; i++) {
            strings[i] = chars[i] + "";
        }
        return strings;
    }

    protected int calculateDigit11(int pool1Sum, int pool2Sum, int digit10) {
        return (pool1Sum + pool2Sum + digit10) % 10;
    }

    protected int calculateDigit10(Integer pool1Sum, Integer pool2Sum) {
        int i = pool1Sum * 7;
        return (i - pool2Sum) % 10;
    }

    protected Integer arraySum(String[] arr) {
        int sum = 0;
        for (String s : arr) {
            sum += Integer.parseInt(s);
        }
        return sum;
    }
}