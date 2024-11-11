class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> outer = new ArrayList<>();
        outer.add(new ArrayList<>());

        for(int num : nums){
            List<List<Integer>> newSubsets = new ArrayList<>(); // Temporary list to store new subsets
            for(List<Integer> subset : outer){
                List<Integer> newSubset = new ArrayList<>(subset);
                newSubset.add(num);
                newSubsets.add(newSubset); // Add to temporary list
            }
            outer.addAll(newSubsets); // Add all new subsets to outer at once
        }

        return outer;
    }
}
