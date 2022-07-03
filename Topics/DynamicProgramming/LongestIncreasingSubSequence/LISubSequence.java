package Topics.DynamicProgramming.LongestIncreasingSubSequence;
import java.util.*;


public class LISubSequence {

// Memoization
    private static int getLongestIncreasingSubsequence(int ind, int prev_ind, int[] nums, int[][] t){
        if(ind == nums.length){
            return 0;
        }

        if(t[ind][prev_ind + 1] != -1){
            return t[ind][prev_ind+1];
        }

        int left = 0 + getLongestIncreasingSubsequence(ind+1, prev_ind, nums, t);

        if(prev_ind == -1 || nums[ind] > nums[prev_ind]){
            left = Math.max(left, 1 + getLongestIncreasingSubsequence(ind+1, ind, nums, t));
        }

        return t[ind][prev_ind + 1] = left;
    }

    // BinarySearch
    public static int lengthOfLIS(int[] nums) {
        int[] tails = new int[nums.length];
        int size = 0;
        for (int x : nums) {
            int i = 0, j = size;
            while (i != j) {
                int m = (i + j) / 2;
                if (tails[m] < x)
                    i = m + 1;
                else
                    j = m;
            }
            tails[i] = x;
            if (i == size) ++size;
        }
        return size;
    }

    // Tabulation Approach
    public static int tabulation(int[] nums){
        int[] t = new int[nums.length];
        Arrays.fill(t, 1);
        int maxi = 1;
        for(int i = 0; i < nums.length; i++){
            for(int prev = 0; prev < i; prev++){
                if(nums[prev] < nums[i] && 1 + t[prev] > t[i]){
                    t[i] = 1 + t[prev];
                }
            }
            if(t[i] > maxi){
                maxi = t[i];
            }
        }
        return maxi;
    }

    // Printing LIS
    public static int printLIS(int[] nums){
        int[] t = new int[nums.length];
        int[] hash = new int[nums.length];
        Arrays.fill(t, 1);
        int lastNode = 0;
        int maxi = 1;
        for(int i = 0; i < nums.length; i++){
            hash[i] = i;
            for(int prev = 0; prev < i; prev++){
                if(nums[prev] < nums[i] && 1 + t[prev] > t[i]){
                    t[i] = 1 + t[prev];
                    hash[i] = prev;
                }
            }
            if(t[i] > maxi){
                maxi = t[i];
                lastNode = i;
            }
        }
        ArrayList<Integer> lis = new ArrayList<>();
        lis.add(nums[lastNode]);
        while(hash[lastNode] != lastNode){
            lastNode = hash[lastNode];
            lis.add(nums[lastNode]);
        }
        Collections.reverse(lis);
        for(Integer num: lis){
            System.out.print(num + " ");
        }
        System.out.println();
        return maxi;
    }

    public static void main(String[] args) {
    
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        int n = nums.length;
        int[][] t = new int[n][n+1];

        for (int i = 0; i < t.length; i++) {
            for (int j = 0; j < t.length; j++) {
                t[i][j] = -1;
            }
        }
        // System.out.println(getLongestIncreasingSubsequence(0, -1, nums, t));
        System.out.println(
            tabulation(nums)
        );
    }
}
