package com.leetcode;

public class DeleteColumnsToMakeSorted {
    public int minDeletionSize(String[] A) {
        int strLength = A[0].length();
        // find number of unsorted columns
        int ans = 0;
        for (int col = 0; col < strLength; col++) {
            for (int row = 0; row < A.length - 1; row++) {
                if (A[row].charAt(col) > A[row + 1].charAt(col)) {
                    ans++;
                    break;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        DeleteColumnsToMakeSorted d = new DeleteColumnsToMakeSorted();
        System.out.println(d.minDeletionSize(new String[]{"cba", "daf", "ghi"}));
    }
}
