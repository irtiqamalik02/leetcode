class Solution {
    public int firstMissingPositive(int[] arr) {

        int i = 0;
        while (i < arr.length) {
            int index = arr[i]-1;
            if (arr[i]> 0 && arr[i] <= arr.length && arr[index] != arr[i]) {
                int temp = arr[i];
                arr[i] = arr[index];
                arr[index] = temp;
            } else {
                i++;
            }
        }
        // now we have a sorted array so check for index value match
        for (int j = 0; j < arr.length; j++) {
            if (arr[j] != j+1) {
                return j+1;
            }

        }
        return arr.length+1;
    }
}