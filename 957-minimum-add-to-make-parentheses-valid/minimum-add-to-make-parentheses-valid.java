class Solution {
    public int minAddToMakeValid(String s) {
        if(s.isEmpty()){
            return 0;
        }

        Stack<Character> stack = new Stack<>();
        int count = 0;

        for(char ch: s.toCharArray()){
            if(ch == '('){
                stack.push(ch);
            }
            if(ch == ')'){
                if(stack.isEmpty()){
                    count++;
                    continue;
                }
                if(stack.peek() == '('){
                    stack.pop();
                }
                else{
                    stack.push(ch);
                }
            }
        }
        return count+stack.size();
    }
}