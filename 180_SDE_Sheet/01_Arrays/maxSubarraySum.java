// package 180_SDE_Sheet.01_Arrays;
public class maxSubarraySum {
    // ==========================================
    // 1. BRUTE FORCE APPROACH
    // Concept: Check all possible subarrays explicitly.
    // Time Complexity: O(N^3) - Three nested loops.
    // Space Complexity: O(1)
    // ==========================================
    public  static  int maxSubArrayBrute(int []nums, int maxSum){
    
        for (int i = 0; i < nums.length; i++) {
           
            for (int j = 0; j < nums.length; j++) {
                int currSum=0;
                for (int k = i; k < j; k++) {
                    currSum+=nums[k];
                }
                maxSum=Math.max(maxSum, currSum);
            }
        }
        return  maxSum;
    }
// ==========================================
    // 2. BETTER APPROACH
    // Concept: Remove the inner loop by taking prefix sum.
    // Time Complexity: O(N^2) - Two nested loops.
    // Space Complexity: O(1)
    // ==========================================

    public  static  int maxSubArrayBtter(int[] nums,int maxSum){
        int n=nums.length;
        for (int i = 0; i < n; i++) {
            int currSum=0;
            for (int j = 0; j < n; j++) {
                currSum+=nums[j];
                maxSum=Math.max(currSum,maxSum);
            }
        }
        return  maxSum;
    }
    // ==========================================
    // 3. OPTIMAL APPROACH (Kadane's Algorithm)
    // Concept: Carry a running sum; discard it if it drops below zero.
    // Time Complexity: O(N) - Single pass.
    // Space Complexity: O(1)
    // ==========================================

    public  static  int maxSubArrayOptimal(int[] nums,int maxSum){
        for (int i = 0; i < nums.length; i++) {
            int currSum=nums[i];
            maxSum=Math.max(maxSum, currSum);
            if(currSum<0){
                currSum=0;
            }
        }
        return  maxSum;
    }
    public static void main(String[] args) {
        int maxSum=Integer.MIN_VALUE;
        int[] nums ={-2, -3, -7, -2, -10, -4};
    //    int sum= maxSubArrayBrute(nums,maxSum);
    int sum=maxSubArrayBtter(nums, maxSum);
       System.out.println(sum);
    }
}
