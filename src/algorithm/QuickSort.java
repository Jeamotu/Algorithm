package algorithm;

import util.ZZZLog;

import java.util.Arrays;

public class QuickSort {
    static int[] intData = new int[]{12, 213, 24, 123, 45, 12, 658, 234, 63, 689, 3341, 14, 779, 31, 279, 27, 356};

    public static void execute() {
        quickSort(0, intData.length - 1);
        ZZZLog.d("algorithm.QuickSort", Arrays.toString(intData));
    }

    private static void quickSort(int left, int right) {
        if (left < right) {
            int i = left;
            int j = right;
            int key = intData[i];

            while (i < j) {
                while (i < j && intData[j] >= key) {
                    j--;
                }
                if (i < j) {
                    intData[i] = intData[j];
                    i++;
                }

                while (i < j && intData[i] < key) {
                    i++;
                }
                if (i < j) {
                    intData[j] = intData[i];
                    j--;
                }
            }

            intData[i] = key;
            quickSort(left, i - 1);
            quickSort(i + 1, right);
        }
    }
}
