package com.leetcode;

public class NumberOfIslands {
    private void dfs(int sx, int sy, char[][] grid) {
        grid[sx][sy] = '0';
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};

        for (int i = 0; i < 4; i++) {
            if (sx + dx[i] < 0 || sx + dx[i] >= grid.length
                    || sy + dy[i] < 0 || sy + dy[i] >= grid[0].length) continue;
            if (grid[sx + dx[i]][sy + dy[i]] == '1') {
                dfs(sx + dx[i], sy + dy[i], grid);
            }
        }

    }

    public int numIslands(char[][] grid) {
        int rows = grid.length;
        if (rows == 0) return 0;
        int cols = grid[0].length;
        int count = 0;
        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < cols; ++j) {
                if (grid[i][j] == '1') {
                    dfs(i, j, grid);
                    count++;
                }
            }
        }
        return count;
    }
}
