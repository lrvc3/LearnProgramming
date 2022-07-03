package Topics.DynamicProgramming.MatrixChainMultiplication;

public class EggDropping {

    public static int solve(int e, int f) {
        if (f == 0 || f == 1)
            return f;

        if (e == 1)
            return f;

        int mn = Integer.MAX_VALUE;
        for (int k = 1; k <= f; k++) {
            // 1 we are adding for the attempt
            // Max we are taking because we are asked in the worst case whats the min
            int tempAns = 1 + Math.max(solve(e - 1, k - 1), solve(e, f - k));
            mn = Math.min(tempAns, mn);
        }
        return mn;
    }

    public static int[][] t = new int[100][1001];

    public static int solveMemo(int e, int f) {
        if (f == 0 || f == 1) {
            t[e][f] = f;
            return f;
        }
        
        if (e == 1) {
            t[e][f] = f;
            return f;
        }

        if (t[e][f] != -1) {
            return t[e][f];
        }

        int mn = Integer.MAX_VALUE;
        for (int k = 1; k <= f; k++) {
            // 1 we are adding for the attempt
            // Max we are taking because we are asked in the worst case whats the min
            int tempAns = 1 + Math.max(solveMemo(e - 1, k - 1), solveMemo(e, f - k));
            mn = Math.min(tempAns, mn);
        }
        return t[e][f] = mn;
    }

    public static void main(String[] args) {
        int e = 2;
        int f = 4;
        // System.out.println(solve(e, f));
        System.out.println(solveMemo(e, f));

    }
}
