class Solution {
    public int climbStairs(int n) {
        // TC -> O(n) ; SC -> O(n)
        if (n == 1)
            return 1;
        int prev1 = 1, prev2 = 1, curr = 0;
        for (int idx = 2; idx <= n; idx++) {
            curr = prev1 + prev2;
            prev2 = prev1;
            prev1 = curr;
        }

        return curr;
    }

    int f(int idx, int[] dp) {
        if (idx == 0)
            return 1;
        if (idx == 1)
            return 1;
        if (dp[idx] != -1)
            return dp[idx];
        int ans = 0;
        // one jump
        int oneJump = f(idx - 1, dp);
        // two jump
        int twoJump = f(idx - 2, dp);

        ans = oneJump + twoJump;
        dp[idx] = ans;
        return ans;
    }
}
