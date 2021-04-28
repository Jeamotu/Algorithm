package leetcode;

import java.util.Stack;

public class LeetCode_00005_LongestPalindrome {
    private int start = 0;
    private int end = 0;
    private int maxLength = 0;

    public String longestPalindrome(String s) {
        if (s.length() == 1) {
            return s;
        }

        for(int i = 0; i < s.length(); i++) {
            extend(s, i, i);
            extend(s, i, i + 1);
        }

        return s.substring(start, end + 1);
    }

    private void extend(String s, int left, int right) {
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        int length = right - left - 1;
        left++;
        right--;
        if (left >= 0 && length > maxLength) {
            start = left;
            end = right;
            maxLength = length;
        }
    }
}
