class Solution {
    public int singleNonDuplicate(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            // check if target
            if( (mid< end && arr[mid]!= arr[mid+1]) && (mid>start && arr[mid] !=
            arr[mid-1]) ){
            //if (arr[mid] != arr[mid + 1] && arr[mid] != arr[mid - 1]) {

                return arr[mid];
            }

            if (mid < end && arr[mid] == arr[mid + 1]) {
                // i.e. mid is first pos of duplicates
                // check index is even or odd
                if (mid % 2 == 0) {// checking first position of duplicate
                    // single element will lie on rhs as mid is first element
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            } else {
                if (mid % 2 == 0) {// checking second postion of duplicate
                    // single element will lie on lhs as mid is 2nd element
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }

            }
        }
        return arr[start];
    }
}