package leetcode;

public class LeetCode_00011_MaxArea {

    public int maxArea(int[] height) {
// 暴力解法 超时
//        int max = 0;
//        for(int i = 0; i < height.length - 1; i++) {
//            for(int j = i + 1; j < height.length; j++) {
//                int area = Math.min(height[i], height[j]) * (j - i);
//                max = Math.max(area, max);
//            }
//        }
//        return max;
        int max = 0;
        int left = 0;
        int right = height.length - 1;
        while (left != right) {
            int area = Math.min(height[left], height[right]) * (right - left);
            max = Math.max(area, max);
            if (height[left] > height[right]) {
                right--;
            } else {
                left++;
            }
        }
        return max;
    }
}
