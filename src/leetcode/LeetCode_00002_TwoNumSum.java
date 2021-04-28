package leetcode;

import util.ZZZLog;

import java.util.Arrays;
import java.util.HashMap;

public class LeetCode_00002_TwoNumSum {
    static int[] data1 = {2, 7, 11, 15};
    static int target1 = 18;

    static int[] data2 = {3, 2, 4};
    static int target2 = 6;

    static int[] data3 = {3, 3};
    static int target3 = 6;

    public static void execute() {
        ZZZLog.d("TwoNumSum", Arrays.toString(twoSum1(data1, target1)));
        ZZZLog.d("TwoNumSum", Arrays.toString(twoSum1(data2, target2)));
        ZZZLog.d("TwoNumSum", Arrays.toString(twoSum1(data3, target3)));

        ZZZLog.d("TwoNumSum", Arrays.toString(twoSum2(data1, target1)));
        ZZZLog.d("TwoNumSum", Arrays.toString(twoSum2(data2, target2)));
        ZZZLog.d("TwoNumSum", Arrays.toString(twoSum2(data3, target3)));
    }

    private static int[] twoSum1(int[] nums, int target) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{};
    }

    private static int[] twoSum2(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            } else {
                map.put(nums[i], i);
            }
        }
        return new int[]{};
    }
}
