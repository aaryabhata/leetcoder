package com.leetcode;

public class SpiralMatrixII {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];

        int top = 0;
        int bottom = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;
        int counter = 1;
        while (true) {
            // top left to top right
            for (int i = left; i <= right; i++) matrix[top][i] = counter++;
            // top increment
            top++;
            // check condition
            if (top > bottom) break;

            // top right to bottom right
            for (int i = top; i <= bottom; i++) matrix[i][right] = counter++;
            right--;
            if (left > right) break;

            // bottom right to bottom left
            for (int i = right; i >= left; i--) matrix[bottom][i] = counter++;
            bottom--;
            if (top > bottom) break;

            // bottom left to top left
            for (int i = bottom; i >= top; i--) matrix[i][left] = counter++;
            left++;
            if (left > right) break;
        }

        return matrix;
    }

    public static void main(String[] args) {
        SpiralMatrixII spiralMatrixII = new SpiralMatrixII();
        int n = 5;
        int[][] res = spiralMatrixII.generateMatrix(n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(res[i][j] + "   ");
            }
            System.out.println();
        }
    }
}
