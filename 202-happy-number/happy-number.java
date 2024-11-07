class Solution {
    public boolean isHappy(int n) {
      int fp = n;
      int sp = n;

      do{
        sp = sumOfDigits(sp);
        fp = sumOfDigits(sumOfDigits(fp));

      }while(fp != sp);

      if(sp == 1){
        return true;
      }

      return false;

    }

    private int sumOfDigits(int n){
        if(n % 10 == n){
            return n * n;
        }
        int remainder = n%10;
        return (int) (Math.pow(remainder,2)) + sumOfDigits(n/10);
    }
}