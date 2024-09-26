class Solution {
    public int maximumWealth(int[][] accounts) {
        int value =0;
        int maxWealth = accounts[0][0];
        for(int[] i: accounts){
            int wealth = calculateWealth(i);
            if(wealth>maxWealth){
                maxWealth=wealth;
            }
        }
        return maxWealth;
    }
    int calculateWealth(int[] arr){
        int wealth =0;
        for(int i: arr){
            wealth += i;
        }
        return wealth;
    }
}