package practice;

import util.ZZZLog;

public class JumpStep {

    public static void execute() {
        ZZZLog.d("WANGXIN", "result = " + jumpStepRecursion(10));
        jumpStepNormal(10);
    }

    private static int jumpStepRecursion(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        return jumpStepRecursion(n - 1) + jumpStepRecursion(n - 2);
    }

    private static void jumpStepNormal(int n) {
        int result = 0;
        if (n == 1) {
            result = 1;
        }
        if (n == 2) {
            result = 2;
        }

        int pre = 2;
        int prepare = 1;
        for (int i = 3; i <= n; i++) {
            ZZZLog.d("WANGXIN", "result = " + result + " pre = " + pre + " prepare = " + prepare);
            result = pre + prepare;
            prepare = pre;
            pre = result;
        }

        ZZZLog.d("WANGXIN", "result = " + result);
    }
}
