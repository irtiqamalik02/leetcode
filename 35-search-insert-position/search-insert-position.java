class Solution {
    public int searchInsert(int[] arr, int target) {
        // find for target and returb index if found
        //else as soon as element found > target do one compariosn to prev element if it lies between them then insert st that position

        int start =0;
        int end = arr.length -1;
        while(start<=end){
            int mid = start + (end-start)/2;
            if(arr[mid]== target){
                return mid;
            }
            if(arr[mid]<target){
                start = mid+1;
            }
            else{
                //do compare with prev to check if it can lie there or not
                if(mid> start && target> arr[mid-1] && target< arr[mid]){
                    return mid;
                }
                end = mid-1;
            }
        }
        return start;
    }
}