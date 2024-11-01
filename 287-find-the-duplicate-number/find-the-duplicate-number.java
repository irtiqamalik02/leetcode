class Solution {
    public int findDuplicate(int[] arr) {
        // TODO: solve using flyod and linked list

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
        for (int j = 0; j < arr.length; j++) {
            if (arr[j] != j + 1) {
                return arr[j];
            }
        }
        return -1;
    }
}