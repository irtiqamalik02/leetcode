class Solution {
    public int findNumbers(int[] nums) {
        int count =0;
        for(int num: nums){
            int digits = findDigitsUsingLog(num);
            if(digits % 2 == 0){
                count++;
            }
            
        }
        return count;
    }

    int findDigitsUsingLog(int num){
        if(num==0){
            return 1;
        }
        if(num < 0){
            num *= -1;
        }
        return (int) Math.log10(num) + 1;

    }
}