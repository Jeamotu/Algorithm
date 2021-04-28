package leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class LeetCode_00020_IsValid {

    public boolean isValid(String s) {
        if (s.length() % 2 == 1) {
            return false;
        }
        HashMap<Character, Character> map = new HashMap();
        map.put('}', '{');
        map.put(')', '(');
        map.put(']', '[');
        LinkedList<Character> stack = new LinkedList<>();
        for (int index = 0; index < s.length(); index++) {
            char currCh = s.charAt(index);
            if (map.containsKey(currCh)) {
                if (stack.isEmpty()) {
                    return false;
                } else {
                    char ch = stack.peek();
                    if (map.get(currCh) == ch) {
                        stack.poll();
                    } else {
                        return false;
                    }
                }
            } else {
                stack.push(currCh);
            }
        }
        return stack.isEmpty();
    }
}
