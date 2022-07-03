package Topics.DynamicProgramming.LongestIncreasingSubSequence;
import java.util.*;


public class LongestStringChain {

    public static boolean checkPossible(String a, String b){
        if(a.length() != 1 + b.length()){
            return false;
        }
        int first = 0;
        int second = 0;
        while(first < a.length()){
            if(second < b.length() && a.charAt(first) == b.charAt(second)){
                first++;
                second++;
            } else {
                first++;
            }
        }

        if(first == a.length() && second == b.length()){
            return true;
        } else {
            return false;
        }
    }

    public static int stringChain(String[] s){
        int[] t = new int[s.length];
        Arrays.sort(s, (a, b)->a.length() - b.length());
        int maxi = 1;
        for(int i = 0; i < s.length; i++){
            t[i] = 1;
            for (int j = 0; j < i; j++) {
                if(checkPossible(s[i], s[j]) && (1 + t[j] > t[i])){
                    t[i] = 1 + t[j];
                }
            }
            if(t[i] > maxi){
                maxi = t[i];
            }
        }
        return maxi;
    }

    public static void main(String[] args) {
        String[] s = {"a","b","ba","bca","bda","bdca"};
        String[] q = {"xbc","pcxbcf","xb","cxbc","pcxbc"};
        System.out.println(stringChain(q));
    }    
}
