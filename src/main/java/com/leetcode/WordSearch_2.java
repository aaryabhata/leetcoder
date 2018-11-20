package com.leetcode;

public class WordSearch_2 {
    private int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public boolean exist(char[][] board, String word) {
        // sanity check
        if (board == null || word == null || word.length() == 0) return false;
        int n = board.length;
        int m = board[0].length;
        boolean[][] visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (dfs(i, j, board, word, 0, n, m, visited)) return true;
            }
        }
        return false;
    }

    private boolean dfs(int i, int j, char[][] board, String word, int start, int n, int m, boolean[][] visited) {
        if (board[i][j] != word.charAt(start)) return false;
        if (start + 1 == word.length()) return true;

        visited[i][j] = true;
        for (int[] dir : dirs) {
            int x = i + dir[0];
            int y = j + dir[1];
            // check boundary
            if (x < 0 || y < 0 || x >= n || y >= m || visited[x][y]) continue;
            if (dfs(x, y, board, word, start + 1, n, m, visited)) return true;
        }
        visited[i][j] = false;
        return false;

    }
}
