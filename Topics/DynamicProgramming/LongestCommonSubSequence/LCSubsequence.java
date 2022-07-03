package Topics.DynamicProgramming.LongestCommonSubSequence;

public class LCSubsequence {

    public static int lcsRecursive(String a, String b, int n, int m){
        if (n == 0 || m == 0) {
            return 0;
        }

        if(a.charAt(n-1) == b.charAt(m-1)){
            return 1 + lcsRecursive(a, b, n-1, m-1);
        }else{
            return Math.max(lcsRecursive(a, b, n, m-1), lcsRecursive(a, b, n-1, m));
        }
    }

    public static int[][] t = new int[102][1002];
    public static int lcsMemo(String a, String b, int n, int m){
        if (n == 0 || m == 0) {
            return t[n][m] = 0;
        }
        if(t[n][m] != -1){
            return t[n][m];
        }

        if(a.charAt(n-1) == b.charAt(m-1)){
            t[n][m] = 1 + lcsMemo(a, b, n-1, m-1);
        }else{
            t[n][m] = Math.max(lcsMemo(a, b, n, m-1), lcsMemo(a, b, n-1, m));
        }

        return t[n][m];
    }


    public static int lcsDp(String a, String b, int n, int m){
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


        return t[n][m];
    }


    public static void main(String[] args) {
        String a = "abcdgh";
        String b = "abedfhr";
        int n = a.length();
        int m = b.length();

        for (int i = 0; i < 102; i++) {
            for (int j = 0; j < 1002; j++) {
                t[i][j] = -1;
            }
        }

        // System.out.println(lcsRecursive(a, b, n, m));
        System.out.println(lcsMemo(a, b, n, m));
        // System.out.println(lcsDp(a, b, n, m));

    }
}
