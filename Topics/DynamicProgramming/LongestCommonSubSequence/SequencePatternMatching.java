package Topics.DynamicProgramming.LongestCommonSubSequence;

/**
 * a: axy
 * b: adxcpy
 * is "a" a subsequence of b?
 */

public class SequencePatternMatching {
    public static int lcs(String a, String b, int n, int m){
        int [][] t = new int[n+1][m+1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                if (i == 0 || j == 0) {
                    t[i][j] = 0;
                } else if((a.charAt(i-1) == b.charAt(j-1))){
                    t[i][j] = 1 + t[i-1][j-1];
                }else{
                    t[i][j] = Math.max(t[i][j-1], t[i-1][j]);
                }
            }
        }
        return t[n][m];
    }

    public static void main(String[] args) {
        String a = "axy";
        String b = "adxcpy";
        int n = a.length();
        int m = b.length();
        int ans = lcs(a, b, n, m);
        System.out.println(ans == n);
    }
}
