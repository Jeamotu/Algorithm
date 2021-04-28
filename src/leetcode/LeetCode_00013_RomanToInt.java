package leetcode;

import java.util.HashMap;
import java.util.PriorityQueue;

public class LeetCode_00013_RomanToInt {
    public int romanToInt1(String s) {
        int[] nums = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] romans = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        int result = 0;
        int index = 0;

        while(s.length() > 0) {
            String ch1 = String.valueOf(s.charAt(0));
            String ch2 = "";
            if (s.length() >= 2) {
                ch2 = s.substring(0, 2);
            }

            if (ch1.equals(romans[index])) {
                result = result + nums[index];
                s = s.substring(1);
            } else if (ch2.equals(romans[index])) {
                result = result + nums[index];
                s = s.substring(2);
            } else {
                index++;
            }
        }
        return result;
    }

    public int romanToInt2(String s) {
        HashMap<Character, Integer> romanNumMap = new HashMap<>();
        romanNumMap.put('M', 1000);
        romanNumMap.put('D', 500);
        romanNumMap.put('C', 100);
        romanNumMap.put('L', 50);
        romanNumMap.put('X', 10);
        romanNumMap.put('V', 5);
        romanNumMap.put('I', 1);

        int preNum = romanNumMap.get(s.charAt(0));
        int result = 0;
        for(int i = 1; i < s.length(); i++) {
            int num = romanNumMap.get(s.charAt(i));
            if (num > preNum) {
                result = result - preNum;
            } else {
                result = result + preNum;
            }
            preNum = num;
        }

        result = result + preNum;

        return result;
    }
}
