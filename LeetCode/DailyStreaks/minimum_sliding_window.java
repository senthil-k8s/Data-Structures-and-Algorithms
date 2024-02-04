class Solution {
    public static String minWindow(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<>();
        int tLen = t.length();
        int sLen = s.length();
        for (int idx = 0; idx < tLen; idx++) {
            char ch = t.charAt(idx);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        int left = 0, right = 0, end = sLen, len =0;
        int minLength = Integer.MAX_VALUE;
        int minStart = -1, minEnd = -1;
        while (right < end) {
                char ch = s.charAt(right);
                if (map.containsKey(ch)) {
                    int freq = map.get(ch);
                    if(freq > 0){
                        len++;
                    }
                    map.put(ch, map.get(ch) - 1);
                }
                right++;
            while (len == tLen) {
                if (minLength > right - left) {
                    minLength = right - left;
                    minStart = left;
                    minEnd = right;
                }
                ch = s.charAt(left);
                if (map.containsKey(ch)) {
                    int freq = map.get(ch);
                    if(freq == 0){
                        len--;
                    }
                    map.put(ch, map.get(ch)+1);
                }
                left++;
            }
        }

        return (minStart == -1) ? "" : s.substring(minStart, minEnd);
    }
}