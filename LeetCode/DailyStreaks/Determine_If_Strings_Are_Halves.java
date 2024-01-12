class Solution {
    // Time Complexity -> O(n)
    // Space Complexity -> O(1)
public boolean halvesAreAlike(String s) {
    
    int len = s.length();
    int midLength = len / 2;
    String s1 = s.substring(0, midLength);
    String s2 = s.substring(midLength, len);
    
    int cnt1 = checkNumberOfVowels(s1);
    int cnt2 = checkNumberOfVowels(s2);
    
    return (cnt1 == cnt2);
    
}

private int checkNumberOfVowels(String s) {
    int len = s.length();
    int numberOfVowels = 0;
    for (int idx = 0; idx < len; idx++) {
        char ch = s.charAt(idx);
        if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' || ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U') {
            numberOfVowels++;
        }
    }
    return numberOfVowels;
}
}
