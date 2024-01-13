// Approach 1 using HashTable

class Solution {

    private static void calculateFequency(HashMap<Character, Integer> freqMap, String s, int len1){
        for(int idx=0; idx<len1; idx++){
            char ch = s.charAt(idx);
            freqMap.put(ch, freqMap.getOrDefault(ch, 0)+1);
        }
    }

    private static int requiredMinSteps(HashMap<Character, Integer> freqMap, String t, int len2){
        int minSteps = 0;
        for(int idx=0; idx<len2; idx++){
            char ch = t.charAt(idx);
            if(freqMap.containsKey(ch)){
                freqMap.put(ch, freqMap.get(ch)-1);
                if(freqMap.get(ch) == 0) freqMap.remove(ch);
            }else{
                minSteps++;
            }
        }
        return minSteps;
    }

    public int minSteps(String s, String t) {

        // Time Complexity -> O(len1)
        // Space Complexity -> O(n)
        HashMap<Character, Integer> freqMap = new HashMap<>();
        int len1 = s.length();
        int len2 = t.length();
        if(len1 != len2) return 0;
        calculateFequency(freqMap);
        int minSteps = requiredMinSteps(freqMap, t, len2);;
        return minSteps;
    }
}


// Approach 2 using freq array

public class Solution {
    public int minSteps(String s, String t) {

        // Time Complexity -> O(len1)
        // Space Complexity -> O(n)
        if (s.length() != t.length()) {
            return 0; 
        }

        int[] freqS = new int[26];
        int[] freqT = new int[26];

        
        for (char ch : s.toCharArray()) {
            freqS[ch - 'a']++;
        }

        
        for (char ch : t.toCharArray()) {
            freqT[ch - 'a']++;
        }

        
        int minSteps = 0;
        for (int i = 0; i < 26; i++) {
            minSteps += Math.abs(freqS[i] - freqT[i]);
        }

        // Return the minimum steps.
        return minSteps / 2; // Each difference represents two steps (remove from one and 
    }
}
