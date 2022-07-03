package Topics.DynamicProgramming.LongestCommonSubSequence;


public class LCSubstring{
    public static int lcsubstring(String a, String b, int n, int m){
        int[][] t = new int[n+1][m+1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                if (i == 0 || j == 0) {
                    t[i][j] = 0;
                }else if(a.charAt(i-1) == b.charAt(j-1)){
                    t[i][j] = 1 + t[i-1][j-1];
                }else{
                    t[i][j] = 0;
                }
            }
        }

        int ans = 0;
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                ans = Math.max(ans, t[i][j]);
            }
        }
        

        return ans;
    }

    public static void main(String[] args) {
        String a = "abcdgh";
        String b = "abedfhr";
        int n = a.length();
        int m = b.length();

        System.out.println(lcsubstring(a, b, n, m));
    }
}

/**
 * String a = "abcdgh";
 * String b = "abedfhr";
 * Expected: 2
 */