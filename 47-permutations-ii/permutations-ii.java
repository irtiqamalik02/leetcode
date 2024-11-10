class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        
        Arrays.sort(nums); // Sort to handle duplicates
        boolean[] used = new boolean[nums.length]; // Track usage of each element
       return permuteHelper(nums, new ArrayList<>(), used);
        //return results;
    }

    private  List<List<Integer>>  permuteHelper(int[] nums, List<Integer> current, boolean[] used) {
        List<List<Integer>> results = new ArrayList<>();
        if (current.size() == nums.length) {
            results.add(new ArrayList<>(current));
            return results;
        }

        for (int i = 0; i < nums.length; i++) {
            // Skip this element if it is a duplicate of the previous element and the previous element hasn't been used in the current recursive path
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }
            if (!used[i]) {
                // Choose
                used[i] = true;
                current.add(nums[i]);
                
                // Explore
                results.addAll(permuteHelper(nums, current, used));
                
                // Un-choose (backtrack)
                used[i] = false;
                current.remove(current.size() - 1);
            }
        }

        return results;
    }
}