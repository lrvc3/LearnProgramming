package Topics.DynamicProgramming.KnapSack.UnboundedKnapsack;

public class RodCutting {
    public static int rodCutting(int length[], int price[], int n, int L) {
        int[][] t = new int[n + 1][L + 1];
        for (int i = 0; i <= n; i++)
            for (int j = 0; j <= L; j++)
                if (j == 0 || i == 0)
                    t[i][j] = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= L; j++) {
                if (length[i - 1] <= j) {
                    t[i][j] = Math.max(t[i - 1][j], price[i - 1] + t[i][j - length[i - 1]]);
                } else
                    t[i][j] = t[i - 1][j];
            }
        }

        return t[n][L];
    }

    public static void main(String[] args) {
        int[] val = { 1, 5, 8, 9, 10, 17, 17, 20 };
        int n = val.length;
        int[] length = new int[n];
        for (int i = 0; i < val.length; i++) {
            length[i] = i + 1;
        }
        System.out.println(rodCutting(length, val, n, n));
    }
}

/**
 * int[] val = { 1, 5, 8, 9, 10, 17, 17, 20 };, ans: 22
 * 
 */
