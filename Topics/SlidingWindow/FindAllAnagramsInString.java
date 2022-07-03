package Topics.SlidingWindow;

import java.util.*;

public class FindAllAnagramsInString {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<Integer>();
        if (s == null || s.length() == 0 || p == null || p.length() == 0)
            return res;
        int i = 0, end = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (char c : p.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int counter = map.size();
        while (end < s.length()) {
            char ch = s.charAt(end);
            if (map.containsKey(ch)) {
                map.put(ch, map.get(ch) - 1);
                if (map.get(ch) == 0) {
                    counter--;
                }
            }
            while (counter == 0) {
                if (end - i + 1 == p.length()) {
                    res.add(i);
                }
                char temp = s.charAt(i);
                if (map.containsKey(temp)) {
                    map.put(temp, map.get(temp) + 1);
                    if (map.get(temp) > 0) {
                        counter++;
                    }
                }
                i++;
            }
            end++;
        }
        return res;
    }

    public static void main(String[] args) {

    }
}
