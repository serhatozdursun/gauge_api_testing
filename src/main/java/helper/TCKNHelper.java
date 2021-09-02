package helper;

public class TCKNHelper {

    public String getTckn() {
        Integer pool1 = Double.valueOf(Math.floor(Math.random() * 90000 + 10000)).intValue();
        String[] p1Chars = toStringArray(pool1);
        Integer pool1Sum = arraySum(p1Chars);
        Integer pool2 = Double.valueOf(Math.floor(Math.random() * 9000 + 1000)).intValue();
        String[] p2Chars = toStringArray(pool2);
        Integer pool2Sum = arraySum(p2Chars);
        int digit10 = calculateDigit10(pool1Sum, pool2Sum);
        int digit11 = calculateDigit11(pool1Sum, pool2Sum, digit10);
        return p1Chars[0] + p2Chars[0] + p1Chars[1] + p2Chars[1] + p1Chars[2] + p2Chars[2] + p1Chars[3] + p2Chars[3] + p1Chars[4] + digit10 + digit11;
    }

    private String[] toStringArray(Integer integer) {
        String string = integer.toString();
        char[] chars = string.toCharArray();
        String[] strings = new String[chars.length];
        for (int i = 0; i < chars.length; i++) {
            strings[i] = chars[i] + "";
        }
        return strings;
    }

    private int calculateDigit11(int pool1Sum, int pool2Sum, int digit10) {
        return (pool1Sum + pool2Sum + digit10) % 10;
    }

    private int calculateDigit10(Integer pool1Sum, Integer pool2Sum) {
        int i = pool1Sum * 7;
        return (i - pool2Sum) % 10;
    }

    private Integer arraySum(String[] arr) {
        int sum = 0;
        for (String s : arr) {
            sum += Integer.parseInt(s);
        }
        return sum;
    }
}