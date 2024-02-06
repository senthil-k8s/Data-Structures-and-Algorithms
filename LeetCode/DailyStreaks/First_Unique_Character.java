class Solution {
    public int firstUniqChar(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int len = s.length();
        for(int idx=0; idx<len; idx++){
            char currentCharacter = s.charAt(idx);
            map.put(currentCharacter, map.getOrDefault(currentCharacter, 0) + 1);
        }
        for(int idx=0; idx<len; idx++){
            char currentCharacter = s.charAt(idx);
            if(map.get(currentCharacter) == 1) return idx;
        }
        return -1;
    }
}