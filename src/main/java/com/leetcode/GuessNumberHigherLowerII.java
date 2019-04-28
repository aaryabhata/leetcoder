package com.leetcode;

public class GuessNumberHigherLowerII {
    public int getMoneyAmount(int n) {
        int[][] table = new int[n + 1][n + 1];
        return helper(table, 1, n);
    }

    int helper(int[][] t, int s, int e) {
        if (s >= e) return 0;
        if (t[s][e] != 0) return t[s][e];
        int res = Integer.MAX_VALUE;
        for (int x = s; x <= e; x++) {
            int tmp = x + Math.max(helper(t, s, x - 1), helper(t, x + 1, e));
            res = Math.min(res, tmp);
        }
        t[s][e] = res;
        return res;
    }

    public int getMoneyAmountIterative(int n) {
        int[][] table = new int[n+1][n+1];
        for(int j=2; j<=n; j++){
            for(int i=j-1; i>0; i--){
                int globalMin = Integer.MAX_VALUE;
                for(int k=i+1; k<j; k++){
                    int localMax = k + Math.max(table[i][k-1], table[k+1][j]);
                    globalMin = Math.min(globalMin, localMax);
                }
                table[i][j] = i+1==j?i:globalMin;
            }
        }
        return table[1][n];
    }

    public static void main(String[] args) {
        GuessNumberHigherLowerII guessNumberHigherLowerII = new GuessNumberHigherLowerII();
        System.out.println(guessNumberHigherLowerII.getMoneyAmount(10));
    }
}
