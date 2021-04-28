package leetcode;

import java.util.ArrayList;

public class LeetCode_00006_ZConvert {
    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }

        ArrayList<StringBuilder> rows = new ArrayList<>();
        for (int i = 0; i < Math.min(numRows, s.length()); i++) {
            rows.add(new StringBuilder());
        }

        Boolean goDown = false;
        int currentRow = 0;
        for (int i = 0; i < s.length(); i++) {
            rows.get(currentRow).append(s.charAt(i));
            if (currentRow == 0 || currentRow == rows.size() - 1) {
                goDown = !goDown;
            }
            currentRow = currentRow + (goDown ? 1 : -1);
        }

        StringBuilder result = new StringBuilder();
        for (StringBuilder builder : rows) {
            result.append(builder.toString());
        }
        return result.toString();
    }
}
