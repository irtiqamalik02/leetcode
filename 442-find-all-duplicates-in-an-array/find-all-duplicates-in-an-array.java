class Solution {
    public List<Integer> findDuplicates(int[] arr) {
        int i = 0;
        while (i < arr.length) {
            int index = arr[i] - 1;
            if (arr[index] != arr[i]) {
                int temp = arr[i];
                arr[i] = arr[index];
                arr[index] = temp;
            } else {
                i++;
            }
        }

        List<Integer> duplicates = new ArrayList<Integer>();
        for (int j = 0; j < arr.length; j++) {
            if (arr[j] != j + 1) {
                duplicates.add(arr[j]);
            }
        }

        return duplicates;

    }
}