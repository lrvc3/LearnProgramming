package Topics.DynamicProgramming.KnapSack.UnboundedKnapsack;

/**
 * https://leetcode.com/problems/coin-change/
 */
public class CoinChangeII {
    public static int getMinNoOfCoinsToObtainKSum(int[] coins, int target){
        int n = coins.length;
        int[][] t = new int[n+1][target+1];
        

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= target; j++) {
                if(i==0){
                    t[i][j] = Integer.MAX_VALUE - 1;
                }
                if(j==0){
                    t[i][j] = 0;
                }
                if (i == 1) {
                    if (j % coins[i - 1] == 0)
                        t[i][j] = j / coins[i - 1];
                    else
                        t[i][j] = Integer.MAX_VALUE - 1;
                }
            }
        }
        t[0][0] = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= target; j++) {
                if(coins[i-1] <= j){
                    t[i][j] = Math.min(1 + t[i][j - coins[i-1]], t[i-1][j]);
                }else{
                    t[i][j] = t[i-1][j];
                }
            }
        }

        return t[n][target];
    }
    public static void main(String[] args) {
        int[] coins = {1,2,5};
        int amount = 11;
        int ans = getMinNoOfCoinsToObtainKSum(coins, amount); 
        if (ans == Integer.MAX_VALUE - 1) {
            System.out.println(-1);;
        } else {
            System.out.println(ans);
        }
    }
}
/**
 * coins: [1,2,5]
 * amount: 11
 * Expected: 3
 */
