package com.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class LargestRectangleInHistogram {
    //We traverse all bars from left to right, maintain a stack of bars.
    //Every bar is pushed to stack once. A bar is popped from stack when a bar of smaller height is seen.
    //When a bar is popped, we calculate the area with the popped bar as smallest bar. How do we get left
    //and right indexes of the popped bar – the current index tells us the ‘right index’ and index of
    //previous item in stack is the ‘left index’.
    public int largestRectangleArea(int[] heights) {
        Deque<Integer> stack = new ArrayDeque<>();
        int maxAreaSoFar = 0, areaWithThisBar = 0, pos = 0;
        while (pos < heights.length) {
            // top bar > new bar pop the top bar and the get the area with top bar as the smallest
            if (stack.isEmpty() || heights[stack.peekLast()] <= heights[pos]) {
                stack.addLast(pos++);
            } else {
                int top = stack.pollLast();
                areaWithThisBar = heights[top] * (stack.isEmpty() ? pos : pos - stack.peekLast() - 1);
                if (areaWithThisBar > maxAreaSoFar) {
                    maxAreaSoFar = areaWithThisBar;
                }
            }
        }
        // pop the remaining bars and update maxArea
        while (!stack.isEmpty()) {
            int top = stack.pollLast();
            areaWithThisBar = heights[top] * (stack.isEmpty() ? pos : pos - stack.peekLast() - 1);
            if (areaWithThisBar > maxAreaSoFar) {
                maxAreaSoFar = areaWithThisBar;
            }
        }
        return maxAreaSoFar;
    }
}
