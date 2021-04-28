package leetcode;

import java.util.Arrays;

public class LeetCode_01011_ShipWithinDays {
    public static void execute() {
        int value = shipWithinDays(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 5);
    }

    private static int shipWithinDays(int[] weights, int D) {
        int left = Arrays.stream(weights).max().getAsInt();
        int right = Arrays.stream(weights).sum();
        while (left < right) {
            int mid = (left + right) / 2;
            int curr = 0;
            int need = 1;
            for (int weight : weights) {
                if (curr + weight > mid) {
                    need++;
                    curr = 0;
                }
                curr = curr + weight;
            }
            if (need <= D) {
                right = mid;
            } else {
                left = mid + 1; // 不能理解
            }
        }
        return left;
    }
}
