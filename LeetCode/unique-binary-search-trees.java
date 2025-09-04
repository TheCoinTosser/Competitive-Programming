// https://leetcode.com/problems/unique-binary-search-trees/
class Solution {
    public int numTrees(final int n) {
       return numTrees(1, n); // [1,n]
    }

    // [1,2,3,4,5,6,7]
    private int numTrees(final int startIndex, final int endIndex) {
        final int n = endIndex - startIndex + 1;
        if (n == 1) return 1;
        if (n == 2) return 2;

        int total = 0;
        for (int head=startIndex; head <= endIndex; head++) {
            if (head == startIndex) {
                // All remaining nodes should be on the right of the head (since they are all larger than the head)
                total += numTrees(startIndex + 1, endIndex);
            }
            else if (head == endIndex) {
                // All remaining nodes should be on the left of the head (since they are all smaller than the head)
                total += numTrees(startIndex, endIndex - 1);
            }
            else {
                // I had made a mistake initially of summing the left and right totals instead of multiplying them!
                total += numTrees(startIndex, head - 1) * numTrees(head + 1, endIndex);
            }
        }
        return total;
    }
}