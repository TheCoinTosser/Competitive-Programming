// https://leetcode.com/problems/reverse-integer/

class Solution {
    public int reverse(int x) {
        // This is the trick case for this problem. If you multiply Integer.MIN_VALUE by -1 you get Integer.MIN_VALUE back! (hence breaking the do/while loop logic)
        if (x == Integer.MIN_VALUE) return 0;

        final boolean wasNegative = x < 0;
        if (wasNegative) x *= -1;

        // There is another solution that does "reversed = reversed * 10 + lastDigit" (along with some checks for overflow and underflow). I find it more cumbersome than just using a StringBuilder and Integer.parseInt to detect overflows though.
        final StringBuilder sb = new StringBuilder();
        do {
            final int lastDigit = x % 10;
            sb.append(lastDigit);
            x /= 10;
        } while(x > 0);

        try {
            final int reversedInt = Integer.parseInt(sb.toString());
            return wasNegative ? -reversedInt : reversedInt;
        } catch (NumberFormatException  e) {
            return 0;
        }
    }
}