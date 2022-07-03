package Topics.DynamicProgramming.LongestCommonSubSequence;

public class LongestRepeatingSubsequence {
    public static int lcs(String a, String b, int n, int m){
        int [][] t = new int[n+1][m+1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0) {
                    t[i][j] = 0;
                } else if((a.charAt(i-1) == b.charAt(j-1)) && i != j){
                    t[i][j] = 1 + t[i-1][j-1];
                }else{
                    t[i][j] = Math.max(t[i][j-1], t[i-1][j]);
                }
            }
        }
        return t[n][m];
    }

    public static void main(String[] args) {
        String a = "AABEBCDD";
        int n = a.length();
        int ans = lcs(a, a, n, n);
        System.out.println(ans);
    }    
}
/**
 * a = "AABEBCDD"
 * output: 3 [0->A, 2->B,D] [1->A, 4->B, D]
 * 
 * 
 */
