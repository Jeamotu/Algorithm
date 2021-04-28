package leetcode;

public class LeetCode_00633_JudgeSquareSum {

    public boolean judgeSquareSumEnum(int c) {
        for (long a = 0; a * a <= c; a++) {
            double b = Math.sqrt(c - a * a);
            if (b == (int) b) {
                return true;
            }
        }
        return false;
    }

    public boolean judgeSquareSumDoublePoint(int c) {
        long a = 0;
        long b = (long) Math.sqrt(c);

        while (a < b) {
            long sum = a * a + b * b;
            if (sum == c) {
                return true;
            }
            if (sum > c) {
                b--;
            } else {
                a++;
            }
        }

        return false;
    }

}
