// https://leetcode.com/problems/container-with-most-water/
class Solution {
    public int maxArea(final int[] height) {
        int maxArea = 0;
        for (int i=0, j=height.length - 1; (i<j && i<height.length);) {
            final int distance = j - i;
            final int localArea = Math.min(height[i], height[j]) * distance;
            maxArea = Math.max(localArea, maxArea);

            if (height[i] < height[j]) {
                i++;
            } else {
                j--;
            }
        }
        return maxArea;
    }
}