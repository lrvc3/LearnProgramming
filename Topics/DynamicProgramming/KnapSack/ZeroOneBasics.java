package Topics.DynamicProgramming.KnapSack;

import java.util.*;
public class ZeroOneBasics {

    // Recursive Code
    public static int knapsack(int[] wt, int[] val, int W, int n) {

        // If there are no items or the capacity of bag is 0
        // Max Profit would be 0
        if (n == 0 || W == 0) {
            return 0;
        }

        if (wt[n - 1] <= W) {
            return Math.max(val[n - 1] + knapsack(wt, val, W - wt[n - 1], n - 1), knapsack(wt, val, W, n - 1));
        } else {
            return knapsack(wt, val, W, n - 1);
        }
    }

    public static int[][] t = new int[102][1002];

    // Recursive Code - Memo
    public static int knapsackMemo(int[] wt, int[] val, int W, int n) {

        // If there are no items or the capacity of bag is 0
        // Max Profit would be 0
        if (n == 0 || W == 0) {
            return 0;
        }

        if (t[n][W] != -1) {
            return t[n][W];
        }

        if (wt[n - 1] <= W) {
            return t[n][W] = Math.max(val[n - 1] + knapsackMemo(wt, val, W - wt[n - 1], n - 1),
                    knapsackMemo(wt, val, W, n - 1));
        } else {
            return t[n][W] = knapsackMemo(wt, val, W, n - 1);
        }
    }

    // DP Code - Tabulation
    public static int knapsackTabulation(int[] wt, int[] val, int W, int n) {
        int[][] dp = new int[n + 1][W + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= W; j++) {
                if (i == 0 || j == 0) // base case // filling 1st row and 1st column of the matrix with zero as per
                                      // the base condition of the recursive solution
                    dp[i][j] = 0;
                else if (wt[i - 1] <= j) { // current wt can fit in bag // this is for the choice diagram of the
                                           // recursive solution
                    int val1 = val[i - 1] + dp[i - 1][j - wt[i - 1]]; // take current wt // and after taking weight
                                                                      // substract the inserted weight from the final
                                                                      // weight
                    int val2 = dp[i - 1][j]; // skip current wt
                    dp[i][j] = Math.max(val1, val2);
                } else if (wt[i - 1] > j) // current wt doesn't fit in bag
                    dp[i][j] = dp[i - 1][j]; // move to next
            }
        }
        return dp[n][W];
    }

    public static void main(String[] args) {
        int[] wt = { 41, 50, 49, 59, 55, 57, 60 };
        int[] val = { 442, 525, 511, 593, 546, 564, 617 };
        int W = 170;
        int n = wt.length;

        for (int i = 0; i < 102; i++) {
            for (int j = 0; j < 1002; j++) {
                t[i][j] = -1;
            }
        }
        // System.out.println(knapsack(wt, val, W, n));
        // System.out.println(knapsackMemo(wt, val, W, n));
        System.out.println(knapsackTabulation(wt, val, W, n));
    }

    // test0 = {
    //     'input': {
    //         'capacity': 165,
    //         'weights': [23, 31, 29, 44, 53, 38, 63, 85, 89, 82],
    //         'profits': [92, 57, 49, 68, 60, 43, 67, 84, 87, 72]
    //     },
    //     'output': 309
    // }
    
    // test1 = {
    //     'input': {
    //         'capacity': 3,
    //         'weights': [4, 5, 6],
    //         'profits': [1, 2, 3]
    //     },
    //     'output': 0
    // }
    
    // test2 = {
    //     'input': {
    //         'capacity': 4,
    //         'weights': [4, 5, 1],
    //         'profits': [1, 2, 3]
    //     },
    //     'output': 3
    // }
    
    // test3 = {
    //     'input': {
    //         'capacity': 170,
    //         'weights': [41, 50, 49, 59, 55, 57, 60],
    //         'profits': [442, 525, 511, 593, 546, 564, 617]
    //     },
    //     'output': 1735
    // }
    
    // test4 = {
    //     'input': {
    //         'capacity': 15,
    //         'weights': [4, 5, 6],
    //         'profits': [1, 2, 3]
    //     },
    //     'output': 6
    // }
    
    // test5 = {
    //     'input': {
    //         'capacity': 15,
    //         'weights': [4, 5, 1, 3, 2, 5],
    //         'profits': [2, 3, 1, 5, 4, 7]
    //     },
    //     'output': 19
    // }
    
}
