package Topics.DynamicProgramming.LongestCommonSubSequence;

import java.util.*;
public class PrintLCSubsequence {
    public static String lcsDp(String a, String b, int n, int m){
        int[][] t = new int[n+1][m+1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                if (i == 0 || j == 0) {
                    t[i][j] = 0;
                }else if(a.charAt(i-1) == b.charAt(j-1)){
                    t[i][j] = 1 + t[i-1][j-1];
                }else{
                    t[i][j] = Math.max(t[i][j-1], t[i-1][j]);
                }
            }
        }

        String res = "";

        int i = n;
        int j = m;
        while(i > 0 && j > 0){
            if(a.charAt(i-1) == b.charAt(j-1)){
                res += a.charAt(i-1);
                i--;
                j--;
            }else {
                if(t[i][j-1] > t[i-1][j]){
                    j--;
                }else{
                    i--;
                }
            }
        }
        String ans = "";
        for (int k = res.length() - 1; k >= 0 ; k--) {
            ans += res.charAt(k);
        }
        return ans;
    }

    public static void main(String[] args) {
        String a = "abcdgh";
        String b = "abedfhr";
        int n = a.length();
        int m = b.length();

        System.out.println(lcsDp(a, b, n, m));
    }
}
