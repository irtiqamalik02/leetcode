class Solution {
    public int[] searchRange(int[] arr, int target) {
        int min = search(arr,target,true);
        int max= search(arr,target,false);
        return new int[] {min,max};
    }
    private int search(int [] arr, int target, boolean isFirst){
        int ans = -1;
        int start = 0;
        int end = arr.length -1;
        while(start<=end){
            int mid = start+ (end-start)/2;
            if(arr[mid] > target){
                end = mid-1;
            }
            else if(arr[mid] < target){
                start= mid+1;
            }
            else {
                ans=mid; //potential ans
                //don't return ans here, divide the space further
                if(isFirst){
                    end = mid-1;

                }else{
                    start=mid+1;
                }

            }
        }
        return ans;
    }

}
