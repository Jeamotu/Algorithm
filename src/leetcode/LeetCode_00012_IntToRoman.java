package leetcode;

import java.util.HashMap;

public class LeetCode_00012_IntToRoman {

    public String intToRoman(int num) {
        /*
        I             1
        V             5
        X             10
        L             50
        C             100
        D             500
        M             1000
         */
        StringBuilder result = new StringBuilder();
        int[] nums = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] romans = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        int index = 0;
        while (index < nums.length) {
            if (num >= nums[index]) {
                result.append(romans[index]);
                num = num - nums[index];
            } else {
                index++;
            }
        }

        return result.toString();
    }
}
