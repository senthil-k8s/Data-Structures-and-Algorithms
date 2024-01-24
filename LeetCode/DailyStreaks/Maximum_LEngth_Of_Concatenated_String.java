class Solution {
    private int maxLength(int ind, List<String> arr, int[] hash) {
        if(ind == arr.size()) {
            return 0;
        }
        int take = 0;
        int notTake = 0 + maxLength(ind + 1, arr, hash);
        for(int i=0;i<arr.get(ind).length();i++) {
            hash[arr.get(ind).charAt(i) - 97]++;
        }
        int flag = 0;
        for(int i=0;i<26;i++) {
            if(hash[i] > 1) {
                flag = 1;
                break;
            }
        }
        if(flag == 0) {
            take = arr.get(ind).length() + maxLength(ind+1, arr, hash);
        }
        for(int i=0;i<arr.get(ind).length();i++) {
            hash[arr.get(ind).charAt(i) - 97]--;
        }
        return Integer.max(take, notTake);
    }
    public int maxLength(List<String> arr) {
        int[] hash = new int[26];
        return maxLength(0, arr, hash);
    }
}