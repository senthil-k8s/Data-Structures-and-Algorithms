class Solution {
    public int[][] divideArray(int[] nums, int k) {
        // TC -> O(NlogN + N)
        // sSC -> O(N)
        Arrays.sort(nums);
        int len = nums.length;
        int[][] result = new int[len/3][3];
        int ind = 0;
        int length = 0;
        int[] temp = new int[3];
        for(int idx = 0; idx <= len; idx++){
            if(length % 3 == 0 && length != 0){
                if( temp[2] - temp[0] <= k ){
                    result[ind++] = temp;
                    temp = new int[3];
                }else{
                    return new int[0][];
                }
            }
            if(idx < len)temp[idx%3] = nums[idx];
            length++;
        }
        return result;
    }
}