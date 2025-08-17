// https://leetcode.com/problems/longest-palindromic-substring/

class Solution {
    public String longestPalindrome(final String s) {
        final int sLength = s.length();
        final boolean isPalindrome[][] = new boolean[sLength][sLength];
        int lowestIndex = 0;
        int highestIndex = 0;
        int longestLength = 1;

        for (int i=0; i < sLength; i++) {
            // Every character on its own is palindrome
            isPalindrome[i][i] = true;

            if (i + 1 < sLength) {
                // Check if each 2 consecutive characters are palindrome
                if(s.charAt(i) == s.charAt(i+1)) {
                    isPalindrome[i][i+1] = true;
                    longestLength = 2;
                    lowestIndex = i;
                    highestIndex = i+1;
                }
            }
        }

        for (int k=2; k < sLength; k++) {
            for (int i=0, j=k; j < sLength; i++, j++) {
                isPalindrome[i][j] = s.charAt(i) == s.charAt(j) && isPalindrome[i+1][j-1];
                if (isPalindrome[i][j]) {
                    final int candidateForLongestLength = j - i + 1;
                    if (candidateForLongestLength > longestLength) {
                        longestLength = candidateForLongestLength;
                        lowestIndex = i;
                        highestIndex = j;
                    }
                }
            }
        }

        return s.substring(lowestIndex, highestIndex + 1);
    }
}