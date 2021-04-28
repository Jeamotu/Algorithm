package leetcode;

public class LeetCode_00007_ReverseInt {
    public int reverse(int x) {
        int res = 0;
        int last = 0;
        while (x != 0) {
            int tmp = x % 10;
            last = res;
            res = res * 10 + tmp;
            if (last != res / 10) {
                return 0;
            }
            x = x / 10;
        }
        return res;
    }
}
