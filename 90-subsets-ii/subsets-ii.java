class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        backtracking(list, new ArrayList<>(), nums,0);
        return list;
        
    }

    private void backtracking(List<List<Integer>> list, List<Integer> tempList, int[] arr, int start){
        list.add(new ArrayList<>(tempList));

        for(int i = start; i < arr.length; i++){
            if( i > start && arr[i] == arr[i-1]) continue; //skip duplicates
                tempList.add(arr[i]);
                backtracking(list,tempList,arr,i+1);
                tempList.remove(tempList.size()-1);
        }
    }
}