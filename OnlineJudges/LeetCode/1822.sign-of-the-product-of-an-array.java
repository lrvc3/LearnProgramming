/*
 * @lc app=leetcode id=1822 lang=java
 *
 * [1822] Sign of the Product of an Array
 */

// @lc code=start
class Solution {
    /**
     * Test Case:
     * [1,5,0,2,-3] 
     * [9,72,34,29,-49,-22,-77,-17,-66,-75,-44,-30,-24]
     * [51,38,73,21,27,55,18,15,79,29,13,45,8,-73,-92,-20,-50,-60,-70]
     * @param nums
     * @return 
     * 1 if ans is positive. 
     * -1 if ans is negative.
     * 0 if ans is equal to 0.
     * 
     * 
     * Naive Approach is to calculate the product:
     * Code:
     * 
     * 
     * 
     * 
     * 
     * Better Solution:
     * You don't have to do the product because that's not what it has been asked for. 
     * All we should care about is the result's sign (-ve, +ve or 0)
     * While looping through the array, if you hit a 0 => no need to multiply further => the product will be zero => return 0
     * If no zero, calculate the net negative 
     * => the product could be negative only when there are negative numbers odd in total count 
     * => in that case, return -1.
     * You can do that easily with a boolean such as netNegative (initially set to false) [or integer sign variable above]
     * Whenever you hit a negative number => you flip it's boolean value. (false to true or true to false)
     * It is guaranteed that if you have odd total count of negative numbers, netNegative value will be true. 
     * (you can try it yourself with several examples)
     * If none of the above meets the criteria => return 1.
     * 
     * 
     */

    public int arraySign(int[] nums) {
        int sign = 1;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 0){
                return 0;
            }else if(nums[i] < 0){
                sign = -sign;
            }            
        }
        return sign;
    }
}
// @lc code=end

