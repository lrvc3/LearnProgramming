package Topics.DynamicProgramming.LongestCommonSubSequence;

public class PrintShortCommonSuperSequence {

    public static String printscs(String a, String b, int n, int m){
        int[][] t = new int[n+1][m+1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                if (i == 0 || j == 0) {
                    t[i][j] = 0;
                }else if(a.charAt(i-1) == b.charAt(j-1)){
                    t[i][j] = 1 + t[i-1][j-1];
                }else{
                    t[i][j] = Math.max(t[i-1][j], t[i][j-1]);
                }
            }
        }

        int i = n;
        int j = m;
        String res = "";
        while (i > 0 && j > 0) {
            if (a.charAt(i-1) == b.charAt(j-1)) {
                res += a.charAt(i-1);
                j--;
                i--;
            }else if (t[i][j-1] > t[i-1][j]) {
                res += b.charAt(j-1);
                j--;
            }else{
                res += a.charAt(i-1);
                i--;
            }
        }

        while (i > 0) {
            res += a.charAt(i-1);
            i--;
        }
        while (j > 0) {
            res += b.charAt(j-1);
            j--;
        }

        String ans = "";
        for (int k = res.length() - 1; k >= 0 ; k--) {
            ans += res.charAt(k);
        }
        return ans;

    }

    public static void main(String[] args) {
        String a = "abac";
        String b = "cab";
        int n = a.length();
        int m = b.length();
        System.out.println(printscs(a, b, n, m));
    }
}

/**
 * String a = "abcdgh";
 * String b = "abedfhr";
 * Output: abecdfghr
 * 
 * String a = "AGGTAB";
 * String b = "GXTXAYB";
 * Output: AGXGTXAYB
 * 
 * String a = "abac";
 * String b = "cab";
 * Output: cabac
 */
