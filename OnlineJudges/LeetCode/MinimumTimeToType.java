package Online Judges.LeetCode;
/**
 * There is a special typewriter with lowercase English letters 'a' to 'z' arranged in a circle with a pointer. 
 * A character can only be typed if the pointer is pointing to that character. 
 * The pointer is initially pointing to the character 'a'.
 * Each second, you may perform one of the following operations:
 *      Move the pointer one character counterclockwise or clockwise.
 *      Type the character the pointer is currently on.
 * 
 * Given a string word, return the minimum number of seconds to type out the characters in word.
 * 
 * Input: word = "abc"
 * Output: 5
 * Explanation: 
 * The characters are printed as follows:
    - Type the character 'a' in 1 second since the pointer is initially on 'a'.
    - Move the pointer clockwise to 'b' in 1 second.
    - Type the character 'b' in 1 second.
    - Move the pointer clockwise to 'c' in 1 second.
    - Type the character 'c' in 1 second.
 * 
 * 
 * Input: word = "bza"
 * Output: 7
 * Explanation:
 * The characters are printed as follows:
    - Move the pointer clockwise to 'b' in 1 second.
    - Type the character 'b' in 1 second.
    - Move the pointer counterclockwise to 'z' in 2 seconds.
    - Type the character 'z' in 1 second.
    - Move the pointer clockwise to 'a' in 1 second.
    - Type the character 'a' in 1 second.
 * 
 * 
 * Input: word = "zjpc"
Output: 34
Explanation:
The characters are printed as follows:
- Move the pointer counterclockwise to 'z' in 1 second.
- Type the character 'z' in 1 second.
- Move the pointer clockwise to 'j' in 10 seconds.
- Type the character 'j' in 1 second.
- Move the pointer clockwise to 'p' in 6 seconds.
- Type the character 'p' in 1 second.
- Move the pointer counterclockwise to 'c' in 13 seconds.
- Type the character 'c' in 1 second.
 * 
 * 
 * 
 * 
 * 
 * 
 */
public class MinimumTimeToType {
    public static int minTimeToType(String word) {
        int cnt = word.length();
        char prev = 'a';
        for (int i = 0; i < word.length(); ++i) {
            char cur = word.charAt(i);
            int diff = Math.abs(cur - prev);
            cnt += Math.min(diff, 26 - diff);
            prev = cur;
        }
        return cnt;
    }
    public static void main(String[] args) {
        int ans = minTimeToType("abc");

    }
}
