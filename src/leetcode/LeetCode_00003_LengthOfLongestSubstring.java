package leetcode;

import java.util.HashMap;

public class LeetCode_00003_LengthOfLongestSubstring {

    /*
    abcdefghia123456789f
    输入: s = "abcabcbb"
    输出: 3
    输入: s = "bbbbb"
    输出: 1
    输入: s = "pwwkew"
    输出: 3
    输入: s = ""
    输出: 0
    */

    private int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int max = 0, start = 0;
        for (int end = 0; end < s.length(); end++) {
            char ch = s.charAt(end);
            if (map.containsKey(ch)) {
                start = Math.max(start, map.get(ch)+1);
            }
            max = Math.max(max, end - start + 1);
            map.put(ch, end);
        }

        return max;
    }
}
