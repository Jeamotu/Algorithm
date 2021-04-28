package leetcode;

public class LeetCode_00008_MyAtoi {
    public int myAtoi(String s) {
        if (s.isEmpty()) {
            return 0;
        }
        int res = 0;
        int last = 0;
        int symbol = 1;
        boolean numStart = false;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (!numStart) {
                if (ch == '+' || ch == '-') {
                    if (i == s.length() - 1) {
                        return 0;
                    } else {
                        char nextCh = s.charAt(i + 1);
                        if (nextCh < '0' || nextCh > '9') {
                            return 0;
                        }
                    }
                    symbol = ch == '+' ? 1 : -1;
                    continue;
                }
            }

            if (ch == ' ') {
                if (!numStart) {
                    continue;
                } else {
                    break;
                }
            }
            if (ch >= '0' && ch <= '9') {
                numStart = true;
                int tmp = ch - '0';
                last = res;
                res = res * 10 + tmp;

                if (last != res / 10) {
                    if (symbol == 1) {
                        return Integer.MAX_VALUE;
                    } else {
                        return Integer.MIN_VALUE;
                    }
                }
            } else {
                break;
            }
        }
        return res * symbol;
    }
}
