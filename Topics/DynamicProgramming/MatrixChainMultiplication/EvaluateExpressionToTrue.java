package Topics.DynamicProgramming.MatrixChainMultiplication;

import java.util.*;

public class EvaluateExpressionToTrue {

    public static int solve(String a, int i, int j, boolean isTrue) {
        if (i >= j) {
            if (isTrue)
                return a.charAt(i) == 'T' ? 1 : 0;
            else
                return a.charAt(i) == 'F' ? 1 : 0;
        }

        int ans = 0;
        for (int k = i + 1; k < j; k += 2) {
            int l_T = solve(a, i, k - 1, true);
            int l_F = solve(a, i, k - 1, false);
            int r_T = solve(a, k + 1, j, true);
            int r_F = solve(a, k + 1, j, false);

            if (a.charAt(k) == '|') {
                if (isTrue)
                    ans += l_T * r_T + l_T * r_F + l_F * r_T;
                else
                    ans += l_F * r_F;
            } else if (a.charAt(k) == '&') {
                if (isTrue == true)
                    ans += l_T * r_T;
                else
                    ans += l_T * r_F + l_F * r_T + l_F * r_F;
            } else if (a.charAt(k) == '^') {
                if (isTrue == true)
                    ans += l_T * r_F + l_F * r_T;
                else
                    ans += l_T * r_T + l_F * r_F;
            }

        }

        return ans;
    }

    public static Map<String, Integer> hm = new HashMap<>();

    public static int solveMemo(String a, int i, int j, boolean isTrue) {
        String key = i + " " + j + " " + isTrue;

        if (hm.containsKey(key)) {
            return hm.get(key);
        }

        if (i >= j) {
            if (isTrue) {
                int val = a.charAt(i) == 'T' ? 1 : 0;
                hm.put(key, val); 
                return val;
            } else {
                int val = a.charAt(i) == 'F' ? 1 : 0;
                hm.put(key, val); 
                return val;
            }
        }

        int ans = 0;
        for (int k = i + 1; k < j; k += 2) {
            int l_T = solveMemo(a, i, k - 1, true);
            int l_F = solveMemo(a, i, k - 1, false);
            int r_T = solveMemo(a, k + 1, j, true);
            int r_F = solveMemo(a, k + 1, j, false);

            if (a.charAt(k) == '|') {
                if (isTrue)
                    ans += l_T * r_T + l_T * r_F + l_F * r_T;
                else
                    ans += l_F * r_F;
            } else if (a.charAt(k) == '&') {
                if (isTrue == true)
                    ans += l_T * r_T;
                else
                    ans += l_T * r_F + l_F * r_T + l_F * r_F;
            } else if (a.charAt(k) == '^') {
                if (isTrue == true)
                    ans += l_T * r_F + l_F * r_T;
                else
                    ans += l_T * r_T + l_F * r_F;
            }

        }

        hm.put(key, ans);
        return ans;
    }


    // GFG solution
    public static int countWays(int N, String S){
        int i = 0;
        int j = S.length() - 1;
        int isTrue = 1;
        
        int[][][] dp = new int[S.length() + 1][S.length() + 1][2];
        
        for(int[][] row: dp){
            for(int[] col: row){
                Arrays.fill(col, -1);
            }
        }
        
        int ways = solveMatrix(S, i, j, isTrue, dp);
        return ways;
    }
    
    public static int solveMatrix(String s, int i, int j, int isTrue, int[][][] dp){
        
        if(i > j){
            return 0;
        }
        
        if(i == j){
            if(isTrue == 1){
                return s.charAt(i) == 'T' ? 1 : 0;
            } else {
                return s.charAt(i) == 'F' ? 1 : 0;
            }
        }
        
        if(dp[i][j][isTrue] != -1){
            return dp[i][j][isTrue];
        }

        int ans = 0;
        
        for(int k = i + 1; k < j; k = k + 2){
            
            int leftTrue = solveMatrix(s, i, k - 1, 1, dp);
            int leftFalse = solveMatrix(s, i, k - 1, 0, dp);
            int rightTrue = solveMatrix(s, k + 1, j, 1, dp);
            int rightFalse = solveMatrix(s, k + 1, j, 0, dp);

            if(s.charAt(k) == '^'){
                if(isTrue == 1){
                    ans = ans + (leftTrue * rightFalse) + (leftFalse * rightTrue);
                } else {
                    ans = ans + (leftTrue * rightTrue) + (leftFalse * rightFalse);
                }
            } else if (s.charAt(k) == '&'){
                if(isTrue == 1){
                    ans = ans + (leftTrue * rightTrue);
                } else {
                    ans = ans + (leftTrue * rightFalse) + (leftFalse * rightTrue) + (leftFalse * rightFalse);
                }
            } else if (s.charAt(k) == '|'){
                if(isTrue == 1){
                    ans = ans + (leftTrue * rightFalse) + (leftFalse * rightTrue) + (leftTrue * rightTrue);
                } else {
                    ans = ans + (leftFalse * rightFalse);
                }
            }
        }
        
        return dp[i][j][isTrue] = ans % 1003; // % 1003 is mentioned in problem description in GFG
    }




    public static void main(String[] args) {
        String a = "T|F&T^F";
        hm.clear();
        // int ans = solve(a, 0, a.length() - 1, true);
        int ans = solveMemo(a, 0, a.length() - 1, true);
        System.out.println(ans);
    }
}
