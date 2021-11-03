/*
 * @lc app=leetcode id=410 lang=java
 *
 * [410] Split Array Largest Sum
 */

// @lc code=start
class Solution {

    /**
     * Concept for finding the min from max
     * Min(max)
     * 
     */

    public boolean numberOfSubArraysByKeepingLimit(int[] arr, int limit, int m){
        int cnt = 1;
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            /**
             * If the current element is greater than limit
             * Then we can add it to any sub-array.
             */
            if(arr[i] > limit) return false;

            if(sum + arr[i] > limit){
                cnt++;
                sum = arr[i];
            }else{
                sum += arr[i];
            }
        }
        return cnt <= m; 
    }

    /**
     * 
     * Complexity:
     * BlackBox (numberofsubarraysbykeepingmaxsumlimit) = n
     * Driver = log(sum - max + 1)
     * Search space is from the max element till the sum of
     * array
     * 
     * @param nums: given array
     * @param m: no of subarrays
     * @return min(largest sum of the subarray)
     */

    public int splitArray(int[] nums, int m) {
        // Binary Search based on ans

        int low = nums[0];
        int high = 0;
        for (int i = 0; i < nums.length; i++) {
            if(low < nums[i]){
                low = nums[i];
            }
            high += nums[i];
        }
        int ans = high;

        while(low <= high){
            int mid = low + (high - low)/2;

            if(!numberOfSubArraysByKeepingLimit(nums, mid, m)){
                low = mid + 1;
            }else{
                ans = mid;
                high = mid - 1;
            }
        }
        return ans;
    }
}
// @lc code=end

