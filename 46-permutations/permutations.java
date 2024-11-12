class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        backtracking(list, new ArrayList<>(), nums);
        return list;
    }

    private void backtracking (List<List<Integer>> list, List<Integer> tempList, int[] arr){
        if(tempList.size() == arr.length){
            list.add(new ArrayList<>(tempList));
        }else{
            for(int i = 0; i < arr.length; i++){
                if(tempList.contains(arr[i])) continue;
                tempList.add(arr[i]);
                backtracking(list,tempList,arr);
                tempList.remove(tempList.size()-1);
            }
        }
    }
}