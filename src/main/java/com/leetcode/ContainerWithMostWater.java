package com.leetcode;

public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int maxArea = 0;
        while (left < right) {
            maxArea = Math.max(Math.min(height[left], height[right]) * (right-left), maxArea);
            if (height[left] < height[right]) left++;
            else right--;

        }
        return maxArea;
    }
}
