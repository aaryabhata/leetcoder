package com.leetcode;

public class WordSearch {
    int[] dx = new int[]{0, 1, 0, -1};
    int[] dy = new int[]{1, 0, -1, 0};

    public boolean exist(char[][] board, String word) {
        if (board.length == 0) return false;
        boolean[][] v = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; ++i) {
            for (int j = 0; j < board[0].length; ++j) {
                if (existHelper(board, v, i, j, word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean existHelper(char[][] board, boolean[][] v, int x, int y, String word, int index) {
        if (word.charAt(index) != board[x][y]) {
            return false;
        }
        if (index == word.length() - 1) {
            return true;
        }
        v[x][y] = true;
        // visit all children
        for (int i = 0; i < 4; ++i) {
            // validate indexes and already visited
            if (x + dx[i] < 0 || x + dx[i] > board.length - 1 || y + dy[i] < 0
                    || y + dy[i] > board[0].length - 1 || v[x + dx[i]][y + dy[i]]) continue;
            if (existHelper(board, v, x + dx[i], y + dy[i], word, index + 1)) {
                return true;
            }

        }
        v[x][y] = false;
        return false;
    }
}
