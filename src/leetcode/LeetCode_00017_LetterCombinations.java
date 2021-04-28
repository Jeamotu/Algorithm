package leetcode;

import java.util.*;

public class LeetCode_00017_LetterCombinations {
    public List<String> letterCombinations(String digits) {
        HashMap<Character, String[]> map = new HashMap<>();
        map.put('2', new String[]{"a", "b", "c"});
        map.put('3', new String[]{"d", "e", "f"});
        map.put('4', new String[]{"g", "h", "i"});
        map.put('5', new String[]{"j", "k", "l"});
        map.put('6', new String[]{"m", "n", "o"});
        map.put('7', new String[]{"p", "q", "r", "s"});
        map.put('8', new String[]{"t", "u", "v"});
        map.put('9', new String[]{"w", "x", "y", "z"});

        Queue<String> queue = new LinkedList<>();
        for (int i = 0; i < digits.length(); i++) {
            processString(queue, map.get(digits.charAt(i)));
        }

        return new ArrayList<>(queue);
    }

    private void processString(Queue<String> queue, String[] strings) {
        if (queue.isEmpty()) {
            for (String str : strings) {
                queue.offer(str);
            }
        } else {
            for (int i = 0; i < queue.size(); i++) {
                String queueValue = queue.poll();
                for (String str : strings) {
                    queue.offer(queueValue + str);
                }
            }
        }
    }
}


