class Solution {
    public int missingNumber(int[] arr) {
        int i = 0;
        while(i<arr.length){
            int index = arr[i];
            if( arr[i] < arr.length && arr[index] != arr[i]){
                int temp = arr[i];
                arr[i]= arr[index];
                arr[index]=temp;
            }
            else{
                i++;
            }
        }
        //now we have a srted array sio check for index value match
        for(int j=0; j<arr.length; j++){
            if(arr[j] != j){
                return j;
            }
            
        }
         return arr.length;
    }
}