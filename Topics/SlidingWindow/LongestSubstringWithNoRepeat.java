package Topics.SlidingWindow;

/**
 * Given a string s, find the length of the longest substring without repeating characters.
 * 
 * Input: s = "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 * 
 * Input: s = "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 * Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */
import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithNoRepeat {

    public static int lengthOfLongestSubstring(String s) {

        if (s == null || s.length() == 0) {
            return 0;
        }

        Map<Character, Integer> hm = new HashMap<>();

        int i = 0;
        int j = 0;
        int ans = Integer.MIN_VALUE;
        while (j < s.length()) {
            hm.put(s.charAt(j), hm.getOrDefault(s.charAt(j), 0) + 1);

            if (hm.size() > j - i + 1) {
                j++;
                continue;
            } else if (hm.size() == j - i + 1) {
                ans = Math.max(ans, j - i + 1);
                j++;
            } else if (hm.size() < j - i + 1) {
                while (hm.size() < j - i + 1) {
                    hm.put(s.charAt(i), hm.get(s.charAt(i)) - 1);

                    if (hm.get(s.charAt(i)) == 0) {
                        hm.remove(s.charAt(i));
                    }
                    i++;
                }
                j++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String a = "aabccbb";
        System.out.println(lengthOfLongestSubstring(a));
        System.out.println(lengthOfLongestSubstring("abbb"));
        System.out.println(lengthOfLongestSubstring("abccde"));
        System.out.println(lengthOfLongestSubstring("pwwkew"));
    }
}
