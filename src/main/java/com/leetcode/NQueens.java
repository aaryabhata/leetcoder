package com.leetcode;

/*
* The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.
* Given an integer n, return all distinct solutions to the n-queens puzzle.

*Each solution contains a distinct board configuration of the n-queens' placement,
*where 'Q' and '.' both indicate a queen and an empty space respectively.
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueens {
     public List<List<String>> nQueens(int n) {
         List<List<String>> ret = new ArrayList<>();
         List<String> currSolution = new ArrayList<>();
         nQueens(n, ret, currSolution);
         return ret;
     }

    private void nQueens(int n, List<List<String>> ret, List<String> currSolution) {
        if (currSolution.size() == n) {
            ret.add(currSolution);
            return;
        }
        for (int i = 0; i < n; i++) {
            if (isOk(currSolution, i)) {
                char[] chars = new char[n];
                Arrays.fill(chars, '.');
                chars[i] = 'Q';
                String s = new String(chars);
                currSolution.add(s);
                nQueens(n, ret, currSolution);
                currSolution.remove(currSolution.size()-1);
            }

        }
    }

    private boolean isOk(List<String> currSolution, int pos) {
        for (int i = 0; i < currSolution.size(); i++) {
            if (currSolution.get(i).charAt(pos) == 'Q') {
                return false;
            }
            // depth = currSolution.size() - i, width = pos
            if (pos + currSolution.size() -i >= 0 &&
                    pos + currSolution.size() -i < currSolution.get(i).length() &&
                    currSolution.get(i).charAt(pos + currSolution.size() - i) == 'Q') {
                return false;
            }
            if (pos - currSolution.size() + i >= 0 &&
                    pos - currSolution.size() + i < currSolution.get(i).length() &&
                    currSolution.get(i).charAt(pos - currSolution.size() + i) == 'Q') {
                return false;
            }
        }
        return true;
    }
}
