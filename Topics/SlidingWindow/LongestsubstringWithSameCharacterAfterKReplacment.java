package Topics.SlidingWindow;

import java.util.*;
/**
 * Longest Substring with Same Letters after (k) Replacement
 * Given a string with lowercase letters only, if you are allowed to replace no more than ‘k’ letters with any letter, 
 * find the length of the longest substring having the same letters after replacement.
 * 
 * Input: String="aabccbb", k=2
 * Output: 5
 * Explanation: Replace the two 'c' with 'b' to have a longest repeating substring "bbbbb".
 * 
 */
public class LongestsubstringWithSameCharacterAfterKReplacment {

    public static int characterReplacement(String s, int k) {
        Map<Character, Integer> map = new HashMap<>(); //char -> index
        int max = 0;
        int mostFreqCount = 0;
        int i = 0, j = 0;
        int n = s.length();
        while(j < n) {
            
            char c = s.charAt(j);
            map.put(c, map.getOrDefault(c, 0) + 1);
            
            mostFreqCount = Math.max(mostFreqCount, map.get(c));
            
            int numOfOtherCharacters = (j - i + 1) - mostFreqCount;
            //i don't need to know which chars. 
            //keep track of total chars that were replaced max

            if(numOfOtherCharacters > k) {
                char charAti = s.charAt(i);
                i++;
                map.put(charAti, map.get(charAti) - 1);
            }
            max = Math.max(max, j - i + 1);
            j++;
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(characterReplacement("ABAB", 2));
        System.out.println(characterReplacement("AABABBA", 1));
    }
}
