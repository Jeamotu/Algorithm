package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode_00018_FourSum {
    public static void main(String[] args) {
        System.out.println("result = " + fourSum(new int[]{1, -2, -5, -4, -3, 3, 3, 5}, -11));
    }

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();

        if (nums.length < 4) {
            return result;
        }

        Arrays.sort(nums);

        if (target >= 0 && nums[0] > target) {
            return result;
        }

        for (int a = 0; a < nums.length - 3; a++) {
            if (a > 0 && nums[a] == nums[a - 1]) {
                continue;
            }
            // start
            if (nums[a] + nums[a + 1] + nums[a + 2] + nums[a + 3] > target) {
                break;
            }
            if (nums[a] + nums[nums.length - 1] + nums[nums.length - 2] + nums[nums.length - 3] < target) {
                continue;
            }
            // end
            for (int b = a + 1; b < nums.length - 2; b++) {
                if (b > a + 1 && nums[b] == nums[b - 1]) {
                    continue;
                }
                // start
                if (nums[a] + nums[b] + nums[b + 1] + nums[b + 2] > target) {
                    break;
                }
                if (nums[a] + nums[b] + nums[nums.length - 1] + nums[nums.length - 2] < target) {
                    continue;
                }
                // end

                int c = b + 1;
                int d = nums.length - 1;

                while (c < d) {
                    int sum = nums[a] + nums[b] + nums[c] + nums[d];
                    if (sum == target) {
                        result.add(Arrays.asList(nums[a], nums[b], nums[c], nums[d]));
                        d--;
                        c++;
                        while (c < d && nums[d] == nums[d + 1]) {
                            d--;
                        }
                        while (c < d && nums[c] == nums[c - 1]) {
                            c++;
                        }
                    } else if (sum < target) {
                        c++;
                        while (c < d && nums[c] == nums[c - 1]) {
                            c++;
                        }
                    } else {
                        d--;
                        while (c < d && nums[d] == nums[d + 1]) {
                            d--;
                        }
                    }
                }
            }
        }
        return result;
    }
}
