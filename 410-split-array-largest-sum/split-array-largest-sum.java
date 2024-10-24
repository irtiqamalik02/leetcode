class Solution {
    public int splitArray(int[] nums, int k) {
        int start = 0;
        int end = 0;
        //find sum of array and max element in array
        for(int i=0; i<nums.length; i++){
           start = Math.max(start,nums[i]);
           end += nums[i];
        }

        while(start<end){
            //try mid as potential minimised max sum
            int mid = start + (end-start)/2;

            //find how many pieces are possible with above mid
            int pieces = 1;
            int sum = 0;

            for(int num: nums){
                //start forming partitions 
                if(num + sum > mid){
                    // you can't add this to sub array so make new subarray
                    pieces++;  //make first partitiom
                    //say you add this num in new sub array then sum = num
                    sum = num;
                }
                else{
                    sum += num;
                }
            }

            // compare pieces to k and check feasibility
            if(pieces > k){
                //means partition sum needs to increase
                start = mid+1;
            }else{
                end = mid;
            }
            
        }
        return start; //or end
    }
    
}