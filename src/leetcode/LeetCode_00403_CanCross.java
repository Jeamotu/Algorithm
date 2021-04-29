package leetcode;

import java.util.HashSet;

public class LeetCode_00403_CanCross {

    public static void main(String[] args) {
        System.out.println("canCross = " + canCross(new int[]{0, 1, 3, 4, 5, 7, 9, 10, 12}));
    }

    public static boolean canCross(int[] stones) {
        return jumpStone(stones, 0, 0);
    }

    static HashSet<Integer> set = new HashSet<>();

    private static boolean jumpStone(int[] stones, int index, int preUnit) {
        System.out.println("index = " + index + " preunit = " + preUnit);
        int key = index * 123 + preUnit;
        if (set.contains(key)) {
            return false;
        } else {
            set.add(key);
        }
        for (int i = index + 1; i < stones.length; i++) {
            int distance = stones[i] - stones[index];
            if (distance >= preUnit - 1 && distance <= preUnit + 1) {
                if (jumpStone(stones, i, distance)) {
                    return true;
                }
            } else if (distance > preUnit + 1) {
                return false;
            }
        }
        return index == stones.length - 1;
    }
}
