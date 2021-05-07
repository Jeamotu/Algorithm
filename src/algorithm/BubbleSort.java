package algorithm;

import util.ZZZLog;

import java.util.Arrays;

public class BubbleSort {

    static int[] intData = new int[]{3, 5, 4, 1, 2, 6};

    public static void execute() {
        bubbleSort(intData, intData.length);
    }

    private static void bubbleSort(int[] a, int n) {
        if (n <= 1) return;
        for (int i = 0; i < n; ++i) {
            // 提前退出冒泡循环的标志位
//            boolean flag = false;
            for (int j = 0; j < n - i - 1; ++j) {
                if (a[j] > a[j + 1]) { // 交换
                    int tmp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = tmp;
//                    flag = true; // 表示有数据交换
                }
                ZZZLog.d("algorithm.BubbleSort", Arrays.toString(intData));
            }
//            if (!flag) break; // 没有数据交换，提前退出
        }
    }
}
