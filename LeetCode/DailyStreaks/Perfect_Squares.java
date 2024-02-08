class Solution {
    public int numSquares(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        return f(1, n, dp);
    }

    int f(int idx, int n, int[] dp) {
        if (n == 0) return 0;
        if( n < 0 ) return (int)(1e9);
        if(idx*idx > n) return (int)(1e9);
        if(dp[n] != -1) return dp[n];
        int mini = Integer.MAX_VALUE;
        int take =0,notTake=0;
        if( n - idx*idx >= 0 ){
            take = 1 + f(idx, n-(idx*idx), dp);
            notTake = f(idx+1, n, dp);
        }
        mini = Math.min(take, notTake);
        dp[n]=mini;
        return dp[n];
    }
}