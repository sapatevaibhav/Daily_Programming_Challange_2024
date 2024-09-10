//  Find the Missing Number
/*
You are given an array arr containing n-1 distinct integers. The array consists of integers taken from the range 1 to n, meaning one integer is missing from this sequence. Your task is to find the missing integer.

Input:
An integer array arr of size n-1 where the elements are distinct and taken from the range 1 to n.
Example : arr = [1, 2, 4, 5]

Output:
Return the missing integer from the array.
Example: Missing number: 3

Constraints:
The array contains exactly n-1 distinct integers, and all integers are in the range [1, n].
You must solve the problem with a time complexity of O(n).
The space complexity should be O(1) (constant space).
1 ≤ n ≤ 10^6

Test Cases:
Test Case 1
Input: [1, 2, 4, 5]
Output: 3
Test Case 2:
Input: [2, 3, 4, 5]
Output: 1
Test Case 3:
Input: [1, 2, 3, 4]
Output: 5
Test Case 4:
Input: [1]
Output: 2
Test Case 5:
Input: [1, 2, 3, ..., 999999]
Output: 1000000

Edge Cases:
The smallest possible array where n = 2. The missing number can only be 1 or 2.
The largest possible array where n = 10^6.
*/

public class Day2 {
    public static void main(String[] args) {
        System.out.println(missingNumber(new int[]{1, 2, 4, 5})); 
        System.out.println(missingNumber(new int[]{2, 3, 4, 5}));
        System.out.println(missingNumber(new int[]{1, 2, 3, 4})); 
        System.out.println(missingNumber(new int[]{1}));          
    }

    public static int missingNumber(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            int correctPos = nums[i] - 1; 
            if (nums[i] > 0 && nums[i] <= nums.length && nums[i] != nums[correctPos]) {
                swap(nums, i, correctPos);
            } else {
                i++;
            }
        }
        
        for (i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                return i + 1; 
            }
        }
        
        return nums.length + 1;
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
