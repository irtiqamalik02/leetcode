class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        if (n == 1) return nums[0];
        
        int prev2 = nums[0]; // Represents dp[i-1]
        int prev = Math.max(nums[0], nums[1]); // Represents dp[i-2]
        
        for (int i = 2; i < n; i++) {
            int current = Math.max(prev, nums[i] + prev2);
            prev2 = prev;
            prev = current;
        }
        
        return prev; // The final result
    }
}
