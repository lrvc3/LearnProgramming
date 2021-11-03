/*
 * @lc app=leetcode id=33 lang=java
 *
 * [33] Search in Rotated Sorted Array
 */

// @lc code=start
class Solution {
    public int search(int[] arr, int target) {
        int low = 0, high = arr.length - 1;

        while(low <= high){
            int mid = (low + high)/2;

            if(arr[mid] == target){
                return mid;
                // Assuming the array is sorted in the left half
            }else if(arr[low] <= arr[mid]){
                // now we need to confirm whether it lies in the sorted section or not
                if( target >= arr[low] && target <= arr[mid]){
                    high = mid - 1;
                }else{
                    low = mid + 1;
                }
            }else{
                // Assuming the array is sorted in the right half
                if( target >= arr[mid] && target <= arr[high]){
                    low = mid + 1;
                }else{
                    high = mid - 1;
                }
            }

        }

        return -1;
    }
}
// @lc code=end

