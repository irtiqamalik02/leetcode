class Solution {
    public int numberOfSteps(int num) {
       return helperFunction(num,0);
    }

    private int helperFunction(int num, int count){
        if(num==0){
            return count;
        }
        if(num%2==0){
            //even num
            return helperFunction(num/2,count+1);
        }
        return helperFunction(num-1,count+1);

    }
}