/*
problem link: https://leetcode.com/problems/two-sum/
solution (o(n))
1. Two Sum
Solved
Easy
Topics
Companies
Hint
Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

You can return the answer in any order.

 

Example 1:

Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
Example 2:

Input: nums = [3,2,4], target = 6
Output: [1,2]
Example 3:

Input: nums = [3,3], target = 6
Output: [0,1]
 

Constraints:

2 <= nums.length <= 104
-109 <= nums[i] <= 109
-109 <= target <= 109
Only one valid answer exists.
*/



class Solution {
    public int[] twoSum(int[] nums, int target) {
        int verifierNumber;
        int[] newArray = new int[2];
        boolean checkIfIndexIsTheSame = false;
        boolean checkIfAlreadyFilledTheArray = false;
        if(target == 0){
            for (int i = 0;i<newArray.length;i++){
                for (int e = 0;e < nums.length;e++){
                    if(nums[e] == 0){
                        newArray[i] = e;
                    }
                }
            }
        }
        for(int i = 0;i < nums.length;i++){
            verifierNumber = target - nums[i];
            for(int e = i + 1;e < nums.length;e++){
                if(nums[e] == verifierNumber){
                    if(checkIfAlreadyFilledTheArray == false){
                        checkIfAlreadyFilledTheArray = true;
                        newArray[0] = i;
                    }
                    if (target == nums[i] && checkIfIndexIsTheSame == false){
                        checkIfIndexIsTheSame = true;
                        continue;
                    }
                    newArray[1] = e;
                }
            }
        }
        return newArray;
        
    }
}
