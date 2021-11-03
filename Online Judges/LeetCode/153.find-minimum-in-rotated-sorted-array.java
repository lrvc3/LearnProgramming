/*
 * @lc app=leetcode id=153 lang=java
 *
 * [153] Find Minimum in Rotated Sorted Array
 */

// @lc code=start
class Solution {
    public int binarySearch(int[] nums){

        int low = 0, mid = 0;
        int high = nums.length - 1;
        int n = nums.length;
        while(low <= high){

            if(low == high){
                return nums[low];
            }else if(low == high - 1){
                return nums[low] <= nums[high] ? nums[low] : nums[high];
            }else{
                if(nums[low] < nums[high]){
                    return nums[low];
                }
                mid = low + (high - low)/2;
                int next = (mid + 1) % n;
                int prev = (mid - 1 + n) % n;
                if(nums[mid] <= nums[next] && nums[mid] <= nums[prev]) 
                    return nums[mid];

                if(nums[low] < nums[mid]){
                    low = mid + 1;
                }

                if(nums[high] >= nums[mid]){
                    high = mid - 1;
                }  
            }

            
        }
        return nums[mid];

    }

    public int bSShorter(int[] nums){
        if(nums.length == 0)
            return 0;

        int low = 0;
        int high = nums.length -1;
        while(low < high){
            int mid = (low + high)/2;
            if(nums[mid] > nums[high]){
                low = mid + 1;
            }else{
                high = mid;
            }
        }
        return nums[low];
    }

    public int findMin(int[] nums) {
        // return binarySearch(nums);
        return bSShorter(nums);
    }
}
// @lc code=end

