package leetcode;

import util.ZZZLog;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.PriorityQueue;
import java.util.Random;

public class LeetCode_00215_FindKthLargest {
    static int[] intData = new int[]{12, 213, 24, 123, 45, 12, 658, 234, 63, 689, 3341, 14, 779, 31, 279, 27, 356};

    static Random random = new Random();

    public static void execute() {
        findKthLargest(intData, 10);
    }

    public static int findKthLargest(int[] intData, int k) {
        ZZZLog.d("WANGXIN", Arrays.toString(intData));
        return quickSelect(intData, 0, intData.length - 1, intData.length - k);
    }

    public static int quickSelect(int[] data, int left, int right, int index) {
        int q = randomPartition(data, left, right);
        if (q == index) {
            ZZZLog.d("WANGXIN", "A q" + q + " index = " + index);
            return data[q];
        } else {
            ZZZLog.d("WANGXIN", "B");
            return q < index ? quickSelect(data, q + 1, right, index) : quickSelect(data, left, q - 1, index);
        }
    }

    public static int randomPartition(int[] data, int left, int right) {
        int i = random.nextInt(right - left + 1) + left;
        ZZZLog.d("WANGXIN", "i = " + i);
        swap(data, i, right);
        ZZZLog.d("WANGXIN", Arrays.toString(intData));
        return partition(data, left, right);
    }

    public static int partition(int[] a, int l, int r) {
        int x = a[r], i = l - 1;
        ZZZLog.d("WANGXIN", "x = " + x + " l = " + l + " r = " + r);
        for (int j = l; j < r; ++j) {
            if (a[j] <= x) {
                swap(a, ++i, j);
                ZZZLog.d("WANGXIN", "j = " + j);
                ZZZLog.d("WANGXIN", Arrays.toString(intData));
            }
        }
        swap(a, i + 1, r);
        ZZZLog.d("WANGXIN", Arrays.toString(intData));
        ZZZLog.d("WANGXIN", "partition return " + (i + 1));
        return i + 1;
    }

    public static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
