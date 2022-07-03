package Topics.DynamicProgramming.MatrixChainMultiplication;

public class MinPalindromePartition {

    public static boolean isPalindrome(String a, int i, int j) {
        if (a.isEmpty()) {
            return true;
        }

        while (i <= j) {
            if (a.charAt(i) == a.charAt(j)) {
                i++;
                j--;
            } else {
                return false;
            }
        }
        return true;
    }

    public static int partitionsRecursive(String a, int i, int j) {
        if (i >= j || isPalindrome(a, i, j)) {
            return 0;
        }

        int ans = Integer.MAX_VALUE;
        for (int k = i; k < j; k++) {
            int temp = partitionsRecursive(a, i, k) + partitionsRecursive(a, k + 1, j) + 1;
            ans = Math.min(ans, temp);
        }
        return ans;
    }

    public static int[][] t = new int[101][1001];

    public static int partitionsMemo(String a, int i, int j) {
        if (i >= j || isPalindrome(a, i, j)) {
            return 0;
        }

        if (t[i][j] != -1) {
            return t[i][j];
        }
        int ans = Integer.MAX_VALUE;
        for (int k = i; k < j; k++) {
            int temp = partitionsMemo(a, i, k) + partitionsMemo(a, k + 1, j) + 1;
            ans = Math.min(ans, temp);
        }
        return t[i][j] = ans;
    }

    public static int partitionsMemoOptimized(String a, int i, int j) {
        if (i >= j || isPalindrome(a, i, j)) {
            return 0;
        }

        if (t[i][j] != -1) {
            return t[i][j];
        }
        int ans = Integer.MAX_VALUE;
        for (int k = i; k < j; k++) {
            int left, right;
            if (t[i][k] == -1)
                left = partitionsMemoOptimized(a, i, k);
            else
                left = t[i][k];

            if (t[k + 1][j] == -1)
                right = partitionsMemoOptimized(a, k + 1, j);
            else
                right = t[k + 1][j];

            int temp_ans = left + right + 1;
            ans = Math.min(ans, temp_ans);
        }
        return t[i][j] = ans;
    }

    public static void main(String[] args) {
        String a = "nitik";
        int l = a.length();
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 1001; j++) {
                t[i][j] = -1;
            }
        }
        // System.out.println(partitionsRecursive(a, 0, l-1));
        // System.out.println(partitionsMemo(a, 0, l - 1));
        System.out.println(partitionsMemoOptimized(a, 0, l - 1));
    }
}
