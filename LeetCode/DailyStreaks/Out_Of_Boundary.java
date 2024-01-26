class Solution {
    private static final int MOD = 1000000007;
    // TC -> O(m*n*N)
    // SC -> O(m*n*N)
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        long[][][] dp = new long[m][n][maxMove + 1];
        for (long[][] it : dp)
            for (long[] inner : it)
                Arrays.fill(inner, -1);

        long ans = helper(m, n, maxMove, startRow, startColumn, dp) % MOD;
        return (int) ans;
    }

    private long helper(int m, int n, int maxMove, int row, int col, long[][][] dp) {
        if (row < 0 || row >= m || col < 0 || col >= n) return 1;
        if (maxMove <= 0) return 0;
        if (dp[row][col][maxMove] != -1) return dp[row][col][maxMove];

        long possible = 0;
        possible += helper(m, n, maxMove - 1, row - 1, col, dp) % MOD;
        possible += helper(m, n, maxMove - 1, row, col - 1, dp) % MOD;
        possible += helper(m, n, maxMove - 1, row + 1, col, dp) % MOD;
        possible += helper(m, n, maxMove - 1, row, col + 1, dp) % MOD;

        dp[row][col][maxMove] = possible % MOD;
        return possible % MOD;
    }
}
