class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;
        int[] dp= new int[n];
        Arrays.sort(nums);
        Arrays.fill(dp, 1);
        int[] track = new int[n];
        int maxi = 1;
        int lastindex = 0;
        for(int ind=0; ind<=n-1; ind++){
            track[ind]=ind;
            for(int prev=0; prev<ind; prev++){
                if(nums[ind] % nums[prev] == 0 && 1 + dp[prev] > dp[ind]){
                    dp[ind] = 1 + dp[prev];
                    track[ind] = prev;
                }
                if( maxi < dp[ind]){
                    maxi = Math.max(maxi, dp[ind]);
                    lastindex = ind;
                }
            }
        }
        ArrayList<Integer> lst = new ArrayList<>();
        int ind = lastindex;

        while( track[ind] != ind ){
            lst.add(nums[ind]);
            ind = track[ind];
        }
        lst.add(nums[ind]);
        Collections.reverse(lst);
        return lst;
    }
}