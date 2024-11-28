class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0]; // Base case: only one house
        if (n == 2) return Math.max(nums[0], nums[1]); // Base case: two houses
        
        // Two cases: exclude the first house or the last house
        int[] dp1 = new int[n]; // DP array for range [0, n-2]
        int[] dp2 = new int[n]; // DP array for range [1, n-1]
        Arrays.fill(dp1, -1);
        Arrays.fill(dp2, -1);
        
        return Math.max(
            robHelper(n - 2, nums, 0, n - 2, dp1),
            robHelper(n - 1, nums, 1, n - 1, dp2)
        );
    }

    private int robHelper(int index, int[] nums, int start, int end, int[] dp) {
        if (index < start) return 0; // Base case: out of bounds
        if (index == start) return nums[start]; // Base case: only one house

        if (dp[index] != -1) return dp[index];

        // Option 1: Rob current house and skip one
        int rob = nums[index] + robHelper(index - 2, nums, start, end, dp);

        // Option 2: Skip current house
        int skip = robHelper(index - 1, nums, start, end, dp);

        dp[index] = Math.max(rob, skip); // Take the maximum of the two options
        return dp[index];
    }
}
