import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode id=1647 lang=java
 *
 * [1647] Minimum Deletions to Make Character Frequencies Unique
 */

// @lc code=start
class Solution {
    public int minDeletions(String s) {
        int[] arr = new int[26];
        int res = 0;
        for (char ch : s.toCharArray()) {
            arr[ch - 'a']++;
        }
        Set<Integer> usedFrequency = new HashSet<>();
        for (int i = 0; i < 26; i++) {
            int freq = arr[i];
            while (freq > 0) {
                if (!usedFrequency.contains(freq)) {
                    usedFrequency.add(freq);
                    break;
                } 
                freq--;
                res++;
            }
        }
        return res;        
    }

}
// @lc code=end

