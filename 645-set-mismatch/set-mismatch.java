class Solution {
    public int[] findErrorNums(int[] arr) {
        int i = 0;
        while(i<arr.length){
            int index = arr[i]-1;
            if(arr[i] != arr[index]){
                int temp = arr[i];
                arr[i] = arr[index];
                arr[index]=temp;
            }
            else{
                i++;
            }
        }

        int[] mismatchSet = new int[2];

        for(int j=0; j< arr.length; j++){
            if(arr[j]!= j+1){
                mismatchSet[0]= arr[j];
                mismatchSet[1]= j+1;
            }
        }

        return mismatchSet;
    }
}