package Topics.SlidingWindow;

import java.util.HashMap;

import java.util.*;
public class LongestSubstringWithKDistinct {

    public static int findLength(String s, int k){

        Map<Character, Integer> hm = new HashMap<>();
        int i = 0, j = 0, mx = Integer.MIN_VALUE;

        while( j < s.length()){

            hm.put(s.charAt(j), hm.getOrDefault(s.charAt(j), 0) + 1);

            if(hm.size() == k){
                mx = Math.max(mx, j-i+1);
            }else if( hm.size() > k){
                while (hm.size() > k) {
                    hm.put(s.charAt(i), hm.get(s.charAt(i)) - 1);
                    if (hm.get(s.charAt(i)) == 0) {
                        hm.remove(s.charAt(i));
                    }
                    i++;
                }
            }
            j++;
        }
        return mx;
    }

    public static void main(String[] args) {
        System.out.println(findLength("arraci", 2));
        System.out.println(findLength("araaci", 1));
        System.out.println(findLength("cbbebi", 3));
    }
}
