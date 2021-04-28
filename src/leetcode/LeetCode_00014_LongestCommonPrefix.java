package leetcode;

import util.ZZZLog;

public class LeetCode_00014_LongestCommonPrefix {

    public static void execute() {
        String[] strs = {"hellao", "hellaaa", "hellasscf", "hellasbcj", "hellsucj", "hellxvcuid", "hellubvu"};
        String prefix = longestCommonPrefix(strs);
        ZZZLog.d("leetcode.LeetCode_00014_LongestCommonPrefix", "prefix = " + prefix);
    }


    private static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        } else {
            return longestCommonPrefix(strs, 0, strs.length - 1);
        }
    }

    private static String longestCommonPrefix(String[] strs, int start, int end) {
        if (start == end) {
            return strs[start];
        } else {
            int mid = (start + end) / 2;
            String leftString = longestCommonPrefix(strs, start, mid);
            String rightString = longestCommonPrefix(strs, mid+1, end);
            return commonPrefix(leftString, rightString);
        }
    }

    private static String commonPrefix(String lcpLeft, String lcpRight) {
        int minLength = Math.min(lcpLeft.length(), lcpRight.length());
        for (int i = 0; i < minLength; i++) {
            if (lcpLeft.charAt(i) != lcpRight.charAt(i)) {
                return lcpLeft.substring(0, i);
            }
        }
        return lcpLeft.substring(0, minLength);
    }
}
