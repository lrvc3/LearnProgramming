import java.util.Arrays;
import java.util.Collections;

/*
 * @lc app=leetcode id=1283 lang=java
 *
 * [1283] Find the Smallest Divisor Given a Threshold
 */

// @lc code=start
class Solution {
    // Binary Search Based on Ans

    public int findSumAfterDividing(int [] nums, int div){
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += (nums[i]/div);
            // We are taking the ceil value
            if(nums[i] % div != 0){
                sum++;
            }
        }
        return sum;
    }

    public int smallestDivisor(int[] nums, int threshold) {
        int low = 1;
        int high = nums[0];

        /**
         * We know that the smallest divisor is 1
         * the largest divisor is max of the num
         * 
         * Using the max divisor will give us the least sum.
         * 
         * now we need to figure out is there any other element 
         * less than the high which will give us the sum after division
         * <= threshold
         * 
         * So we do a binarysearch - 1 to high(max of arr)
         */
        for (int i = 0; i < nums.length; i++) {
            if(high < nums[i]){
                high = nums[i];
            }
        }

        // As ans is guaranteed we know for sure that high could be one ans
        int ans = high;
        while(low <= high){

            int mid = low + (high - low)/2;

            if(findSumAfterDividing(nums, mid) <= threshold){
                ans = mid;
                high = mid - 1;
            }else{
                low = mid + 1;
            }

        }
        return ans;
    }
}
// @lc code=end

