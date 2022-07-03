package Topics.DynamicProgramming.LongestCommonSubSequence;

public class ShortestCommonSuperSequence {
    public static int lcs(String a, String b, int m, int n){
        int[][]t = new int[n+1][m+1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                if(i==0||j==0){
                    t[i][j] = 0;
                }else if(a.charAt(i-1) == b.charAt(j-1)){
                    t[i][j] = 1 + t[i-1][j-1];
                }else{
                    t[i][j] = Math.max(t[i-1][j], t[i][j-1]);
                }
            }
        }
        return t[n][m];
    }
    public static void main(String[] args) {
        String a = "AGGTAB";
        String b = "GXTXAYB";
        int n = a.length();
        int m = b.length();
        
        int ans = n + m - lcs(a, b, m, n);

        System.out.println(ans);
    }
}
