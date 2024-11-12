class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        backtracking(list, new ArrayList<>(), nums,new boolean[nums.length]);
        return list;
        
    }

    private void backtracking(List<List<Integer>> list, List<Integer> tempList, int[] arr,
            boolean[] used) {
                if(tempList.size() == arr.length){
                    list.add(new ArrayList<>(tempList));
                }else{
                    for(int i = 0; i < arr.length; i++){
                        if(used[i] || i > 0 && arr[i] == arr[i-1] && !used[i - 1]) continue;
                        used[i] = true;
                        tempList.add(arr[i]);
                        backtracking(list,tempList,arr,used);
                        used[i]= false;
                        tempList.remove(tempList.size()-1);
                    }
                }

    }
}