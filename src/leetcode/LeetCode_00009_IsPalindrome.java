package leetcode;

import util.ZZZLog;

public class LeetCode_00009_IsPalindrome {

    public static void execute() {
        isPalindrome(12333321);
    }
    private static boolean isPalindrome(int x) {
        if (x < 0 || (x / 10 == 0 && x != 0)) {
            return false;
        }

        int revertNum = 0;
        while (x > revertNum) {
            revertNum = revertNum * 10 + x % 10;
            x = x / 10;
        }
        ZZZLog.d("leetcode.LeetCode_00009_IsPalindrome", "revertNum = " + revertNum + " x = " + x);
        return true;
    }
}
