class Solution {
    public List<List<Integer>> permute(int[] nums) {
        return permuteHelper(new ArrayList<>(),nums);
    }

    private List<List<Integer>> permuteHelper(List<Integer> processed, int[] unprocessed) {
        List<List<Integer>> results = new ArrayList<>();

        // Base case: if processed list has the same length as nums, we have a complete
        // permutation
        if (processed.size() == unprocessed.length) {
            results.add(new ArrayList<>(processed)); // Add a copy of processed list to results
            return results;
        }

        // Recursively insert the next unprocessed element at each position in processed
        for (int i = 0; i < unprocessed.length; i++) {
            if (processed.contains(unprocessed[i]))
                continue; // Skip if element is already in processed

            // Choose: add unprocessed[i] to the processed list at the next available
            // position
            processed.add(unprocessed[i]);

            // Explore: call permuteHelper with updated processed list
            results.addAll(permuteHelper(processed, unprocessed));

            // Un-choose (backtrack): remove the last added element for the next iteration
            processed.remove(processed.size() - 1);
        }

        return results;
    }
}