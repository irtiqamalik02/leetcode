class Solution {
    public int search(int[] nums, int target) {
        // find peak -- num is max in range n-1 and n+1
        // do bs in both sides
        // it'll be asc till peak and then second half also asc

        int pivot = findPivot(nums);
        if (pivot == -1) {
            // do normal BS as array is not pivoted
            return binarySearch(nums, 0, nums.length - 1, target);
        }

        // if pivot is found then we have 2 asc arrays

        if (nums[pivot] == target) {
            return pivot;
        }
        if (target >= nums[0]) {
            return binarySearch(nums, 0, pivot - 1, target);
        }

        return binarySearch(nums, pivot + 1, nums.length - 1, target);
    }

    private int findPivot(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (mid < end && arr[mid] > arr[mid + 1]) {
                return mid;
            }
            if (mid > start && arr[mid] < arr[mid - 1]) {
                return mid - 1;
            }
            if (arr[start] >= arr[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }

    private int binarySearch(int[] arr, int start, int end, int target) {
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == target) {
                return mid;
            }
            if (arr[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }
}