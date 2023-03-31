package ru.butov.tasks.path_in_matrics_whose_sum_Is_divisible_by_k;

class PathsInMatrixWhoseSumIsDivisibleByK {
    int MOD = 1_000_000_000 + 7;
    
    public int numberOfPaths(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;
        int[][][] dp = new int[m][n][k + 1];
        
        // base case
        int lastCellRemainder = grid[m-1][n-1] % k;
        dp[m-1][n-1][lastCellRemainder] = 1;
		
        int lastRemainder = lastCellRemainder;
        // last row base case
        for (int c = n-2; c >= 0; c--) {
            int cellRemainder = grid[m-1][c] % k;
            dp[m-1][c][(lastRemainder + cellRemainder) % k] = 1;
            lastRemainder = (lastRemainder + cellRemainder) % k;
        }
        
        lastRemainder = lastCellRemainder;
        // last col base case
        for (int r = m-2; r >= 0; r--) {
            int cellRemainder = grid[r][n-1] % k;
            dp[r][n-1][(lastRemainder + cellRemainder) % k] = 1;
            lastRemainder = (lastRemainder + cellRemainder) % k;
        }
        
        // Recurrence relation
        for (int r = m-2; r >= 0; r--) {
            for (int c = n-2; c >= 0; c--) {
                int cellRemainder = grid[r][c] % k;
                
                for (int rem = 0; rem <= k; rem++) {
                    dp[r][c][(cellRemainder + rem) % k] = (dp[r][c][(cellRemainder + rem) % k] + dp[r][c+1][rem]) % MOD;
                    dp[r][c][(cellRemainder + rem) % k] = (dp[r][c][(cellRemainder + rem) % k] + dp[r+1][c][rem]) % MOD;
                }
            }
        }
        
        return dp[0][0][0];
    }
}
