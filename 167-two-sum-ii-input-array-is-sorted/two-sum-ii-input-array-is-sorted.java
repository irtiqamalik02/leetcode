class Solution {
    public int[] twoSum(int[] arr, int target) {

        // take first element and find difference with target
        // using the difference as key do BS in remaining array

        // int difference = 0;
        // for (int i = 0; i < arr.length; i++) {
        //     difference = target - arr[i];
        //     int potentialAns = binarySearch(i + 1, arr.length - 1, arr, difference);
        //     if (potentialAns != -1) {
        //         return new int[] { i + 1, potentialAns + 1 };
        //     }

        // }
        // return new int[] { -1, -1 };

        // two pointer approach
        int start = 0;
        int end = arr.length-1;
        
        while(start<end){
            if(arr[start]+ arr[end] == target){
                return new int[]{start+1,end+1};
            }
            else if(arr[start]+ arr[end] > target){
                end--;
            }else{
                start++;
            }
        }
        return new int[] { -1, -1 };
    }

    // private int binarySearch(int start, int end, int[] arr, int target) {
    //     while (start <= end) {
    //         int mid = start + (end - start) / 2;
    //         if (arr[mid] == target) {
    //             return mid;
    //         }
    //         if (arr[mid] > target) {
    //             end = mid - 1;
    //         } else {
    //             start = mid + 1;
    //         }
    //     }
    //     return -1;
    // }
}