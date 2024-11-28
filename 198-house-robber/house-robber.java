class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        if (n == 1) return nums[0];
        
        int[] dp = new int[n];
        dp[0] = nums[0]; // Base case: only one house to rob
        dp[1] = Math.max(nums[0], nums[1]); // Base case: rob either house 0 or house 1
        
        for (int i = 2; i < n; i++) {
            // Either rob the current house and add the result of (i-2) or skip the current house
            dp[i] = Math.max(dp[i - 1], nums[i] + dp[i - 2]);
        }
        
        return dp[n - 1]; // Return the result for the last house
    }
}
