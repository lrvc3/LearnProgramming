2-package Topics.DynamicProgramming.LongestCommonSubSequence;

public class LongestPalindromicSubsequence {

    public static int lcs(String a, String b, int n, int m){
        int [][] t = new int[n+1][m+1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0) {
                    t[i][j] = 0;
                } else if(a.charAt(i-1) == b.charAt(j-1)){
                    t[i][j] = 1 + t[i-1][j-1];
                }else{
                    t[i][j] = Math.max(t[i][j-1], t[i-1][j]);
                }
            }
        }
        return t[n][m];
    }

    public static void main(String[] args) {
        String a = "agbcba";

        String b = "";
        for (int i = a.length() - 1; i >= 0 ; i--) {
            b += a.charAt(i);
        }
        System.out.println(lcs(a, b, a.length(), b.length()));
    }
}
/**
 * a = "agbcba"
 * output: 5
 * 
 * 
 */
