// https://leetcode.com/problems/palindrome-number/
class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) return false;

        int[] digits = new int[10];

        int i = 0;
        while (x >= 10) {
            final int rest = x % 10;
            digits[i++] = rest;
            x /= 10;
        }
        digits[i] = x;

        for (int j=0; j<i; j++, i--) {
            if (digits[j] != digits[i]) {
                return false;
            }
        }
        return true;
    }
}