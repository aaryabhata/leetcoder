package com.leetcode;

public class ValidMountainArray {
    public boolean validMountainArray(int[] A) {
        // find peak
        int peakFromLeft = -1, peakFromRight = -1;
        for (int i = 1; i <= A.length - 1; i++) {
            if (A[i - 1] < A[i]) {
                peakFromLeft = i;
            } else {
                break;
            }
        }
        for (int i = A.length - 1; i > 0; i--) {
            if (A[i - 1] > A[i]) {
                peakFromRight = i - 1;
            } else {
                break;
            }
        }
        return peakFromLeft > 0 && peakFromLeft < A.length - 1 && peakFromLeft == peakFromRight;
    }
}
