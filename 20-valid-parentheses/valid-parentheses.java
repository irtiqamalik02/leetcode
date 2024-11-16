class Solution {
    public boolean isValid(String s) {
        if (s.isEmpty()) {
            return true;
        }

        Stack<Character> stack = new Stack<>();

        for (char ch : s.toCharArray()) {
            if (ch == '{' || ch == '[' || ch == '(') {
                stack.push(ch);
            } else if (ch == '}' || ch == ']' || ch == ')') {
                if (stack.isEmpty()) {
                    return false;
                }
                if (stack.peek() == '[' && ch == ']' ||
                    stack.peek() == '(' && ch == ')' ||
                    stack.peek() == '{' && ch == '}') {
                    stack.pop();
                } else {
                    return false; // Mismatched brackets
                }
            }
        }

        return stack.isEmpty();
    }
}
