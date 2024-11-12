class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        //Arrays.sort(candidates);
        backtracking(list, new ArrayList<>(),candidates,target,0);
        return list;
    }

    private void backtracking(List<List<Integer>> list, List<Integer> tempList, int[] arr, int remaining, int start){
        if(remaining < 0) return;
        else if(remaining == 0){
            list.add(new ArrayList<>(tempList));
        }else{
            for(int i = start; i < arr.length ; i++){
                tempList.add(arr[i]);
                backtracking(list,tempList,arr,remaining - arr[i],i); //repeating allowed
                tempList.remove(tempList.size()-1);
            }
        }

    }
}