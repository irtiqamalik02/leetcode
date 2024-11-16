class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        int max = 0;

        for (int i = 1; i < heights.length; i++) {
            while (!stack.isEmpty() && heights[i] < heights[stack.peek()]) {
                max = getMax(heights, max, i, stack);
            }
            stack.push(i);
        }

        int i = heights.length;
        while (!stack.isEmpty()) {
            max = getMax(heights, max, i, stack);
        }
        return max;
    }

    private int getMax(int[] heights, int max, int i, Stack<Integer> stack) {
        int area;
        int popped = stack.pop();
        if (stack.isEmpty()) {
            area = heights[popped] * i;
        } else {
            area = heights[popped] * (i - 1 - stack.peek());
        }

        return Math.max(max, area);
    }
}