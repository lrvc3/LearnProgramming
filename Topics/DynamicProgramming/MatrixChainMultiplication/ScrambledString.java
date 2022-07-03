package Topics.DynamicProgramming.MatrixChainMultiplication;

import java.util.HashMap;
import java.util.Map;

public class ScrambledString {

    public static boolean isScramble(String a, String b) {
        if (a.equals(b)) {
            return true;
        }
        if (a.length() <= 1) {
            return false;
        }

        boolean flag = false; // Assuming its not a scrambled string
        for (int i = 1; i < a.length(); i++) {
            String s1Left = a.substring(0, i);
            String s1Right = a.substring(i);
            String s2Left = b.substring(0, i);
            String s2Right = b.substring(i);
            String s3Left = b.substring(0, b.length() - i);
            String s3Right = b.substring(b.length() - i);
            
            if ((isScramble(s1Left, s2Left) && isScramble(s1Right, s2Right)) ||
                (isScramble(s1Left, s3Right) && isScramble(s1Right, s3Left))) {
                    flag = true;
                return true;
            }
        }

        return flag;
    }

    public static Map<String, Integer> hm = new HashMap<>();
    public static boolean isScrambleMemo(String a, String b) {
        String key = a + " " + b;

        if(hm.containsKey(key)){
            return hm.get(key) == 1;
        }
        
        if (a.equals(b)) {
            hm.put(key, 1);
            return true;
        }
        if (a.length() <= 1) {
            hm.put(key, 0);
            return false;
        }

        boolean flag = false; // Assuming its not a scrambled string
        for (int i = 1; i < a.length(); i++) {
            String s1Left = a.substring(0, i);
            String s1Right = a.substring(i);
            String s2Left = b.substring(0, i);
            String s2Right = b.substring(i);
            String s3Left = b.substring(0, b.length() - i);
            String s3Right = b.substring(b.length() - i);
            
            if ((isScrambleMemo(s1Left, s2Left) && isScrambleMemo(s1Right, s2Right)) ||
                (isScrambleMemo(s1Left, s3Right) && isScrambleMemo(s1Right, s3Left))) {
                    flag = true;
                return true;
            }
        }
        int val = flag == true ? 1: 0; 
        hm.put(key, val);
        return flag;
    }

    public static void main(String[] args) {
        String a = "great";
        String b = "rgeat";
        // String a = "abcde";
        // String b = "caebd";

        if (a.length() != b.length()) {
            System.out.println(false);
        } else if (a.isEmpty() && b.isEmpty()) {
            System.out.println(true);
        } else {
            // boolean res = isScramble(a, b);
            boolean res = isScrambleMemo(a, b);
            System.out.println(res);
        }
    }
}
