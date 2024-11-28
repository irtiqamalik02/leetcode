class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp,-1);

        
        return robHelper(n-1, nums, dp);
    }

    private int robHelper(int index, int[] nums, int[] dp) {
        if (index == 0) return nums[index];  // Base case: no houses left to rob
        if(index < 0) return 0;
        if (dp[index] != -1) return dp[index];  // Return previously computed value

        // Option 1: Skip the current house
        int skip = robHelper(index - 1, nums, dp);

        // Option 2: Rob the current house and skip the next one
        int rob = nums[index] + robHelper(index - 2, nums, dp);

        dp[index] = Math.max(skip, rob);  // Store the maximum of the two options
        return dp[index];
    }
}
