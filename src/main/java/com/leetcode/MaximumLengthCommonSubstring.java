package com.leetcode;

public class MaximumLengthCommonSubstring {
    public int findLength(int[] A, int[] B) {

        int[][] dp = new int[A.length+1][B.length+1];
        int max = 0;
        for (int i = 0; i < A.length + 1; i++) {
            for (int j = 0; j < B.length + 1; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                    continue;
                }
                if (A[i-1] == B[j-1]) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                    max = Math.max(dp[i][j], max);
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        MaximumLengthCommonSubstring maximumLengthCommonSubstring = new MaximumLengthCommonSubstring();
        System.out.println(maximumLengthCommonSubstring.findLength(new int[]{1,3,5}, new int[]{1,3}));
    }
}
