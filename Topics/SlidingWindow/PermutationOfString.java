package Topics.SlidingWindow;

import java.util.HashMap;

import java.util.*;

public class PermutationOfString {

    public static boolean findPermutation(String s1, String s2) {
        if (s1 == null || s2 == null) {
            return false;
        }
        int len = s1.length();
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s1.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int count = map.size();
        int i = 0;
        int j = 0;
        while (j < s2.length()) {
            char ch = s2.charAt(j);
            if (map.containsKey(ch)) {
                map.put(ch, map.get(ch) - 1);
                if (map.get(ch) == 0) {
                    count--;
                }
            }
            while (count == 0) {
                if (j - i + 1 == len) {
                    return true;
                }
                char temp = s2.charAt(i);
                if (map.containsKey(temp)) {
                    map.put(temp, map.get(temp) + 1);
                    if (map.get(temp) > 0) {
                        count++;
                    }
                }
                i++;
            }
            j++;
        }
        return false;

    }

    public static void main(String[] args) {

    }
}
