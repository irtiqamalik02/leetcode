class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int start = 0;
        int end = arr.length-1;
        while(start<end){
            int mid = start+(end-start)/2;
            if(arr[mid]>arr[mid+1]){ 
                // you're in decreasing part of array, check in lhs with mid also possible value
                end=mid;
            }
           else{
            // you're in asc part, possible ans can lie in rhs
                start=mid+1;
            }
        }
        return start; //can return end as well
    }
}