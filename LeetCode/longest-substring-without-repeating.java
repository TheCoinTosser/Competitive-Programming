// https://leetcode.com/problems/longest-substring-without-repeating-characters/

class Solution {
    public int lengthOfLongestSubstring(final String s) {
        final int n = s.length();
        if (n == 0) return 0;
        if (n == 1) return 1;

        int leftIndex = 0;
        int rightIndex = 0;
        int longestSubstringLen = 0;
        final Set<Character> charsAlreadySeen = new HashSet<>();

        while (rightIndex < n) {
            final char character = s.charAt(rightIndex);
            if (!charsAlreadySeen.contains(character)) {
                charsAlreadySeen.add(character);
                rightIndex++;
                longestSubstringLen = Math.max(longestSubstringLen, rightIndex - leftIndex);
            } else {
                charsAlreadySeen.remove(s.charAt(leftIndex));
                leftIndex++;
            }
        }

        return longestSubstringLen;
    }
}