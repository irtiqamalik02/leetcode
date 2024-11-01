class Solution {
    public List<Integer> findDisappearedNumbers(int[] arr) {
        int i = 0;
        List<Integer> disappearedNums = new ArrayList<Integer>();
        while(i < arr.length){
            int index = arr[i]-1;
            if(index < arr.length && arr[index]!= arr[i]){
                int temp = arr[index];
                arr[index] = arr[i];
                arr[i]=temp;
            }else{
                i++;
            }
        }
        for(int j= 0; j<arr.length; j++){
            if(arr[j]!=j+1){
                disappearedNums.add(j+1);
            }
        }
        return disappearedNums;
    }
}