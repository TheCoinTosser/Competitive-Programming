class Solution {
    public String longestCommonPrefix(final String[] strs) {
        int smallestStringSize = Integer.MAX_VALUE;
        final StringBuilder sb = new StringBuilder();

        for (int i=0; i<strs.length; i++) {
            smallestStringSize = Math.min(smallestStringSize, strs[i].length());
        }
        for (int j=0; j<smallestStringSize; j++) {
            final char currentChar = strs[0].charAt(j);
            boolean shouldBreakOutterFor = false;
            for (int i=1; i<strs.length; i++) {
                if (currentChar != strs[i].charAt(j)) {
                    shouldBreakOutterFor = true;
                    break;
                }
            }
            if (shouldBreakOutterFor) break;
            sb.append(currentChar);
        }
        return sb.toString();
    }
}