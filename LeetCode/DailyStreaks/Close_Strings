class Solution {
    public boolean closeStrings(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();
        if(len1 != len2) return false;
        int[] map1 = new int[26];
        int[] map2 = new int[26];
        for(int idx = 0; idx < len1; idx++){
            char ch1 = word1.charAt(idx);
            char ch2 = word2.charAt(idx);
            map1[ch1 - 'a']++;
            map2[ch2 - 'a']++;
        }
        for(int i=0;i<26;i++){
            if((map1[i]==0 && map2[i]!=0) || (map2[i]==0 && map1[i]!=0)){
                return false;
            }
        }
        Arrays.sort(map1);
        Arrays.sort(map2);
        for(int idx=0; idx<26; idx++){
            if(map1[idx] != map2[idx]) return false;
        }
        return true;
        
    }
}