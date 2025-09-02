// https://leetcode.com/problems/trapping-rain-water/
class Solution {
    public int trap(final int[] height) {
        final int lastIndex = height.length - 1;
        int maxHeightToTheLeft[] = new int[height.length];
        int maxHeightToTheRight[] = new int[height.length];

        int maxHeightSoFar = 0;
        for (int i=0; i < height.length; i++) {
            maxHeightToTheLeft[i] = maxHeightSoFar;
            maxHeightSoFar = Math.max(maxHeightSoFar, height[i]);
        }

        maxHeightSoFar = 0;
        for (int j = lastIndex; j >= 0; j--) {
            maxHeightToTheRight[j] = maxHeightSoFar;
            maxHeightSoFar = Math.max(maxHeightSoFar, height[j]);
        }

        int maxWaterTrapped = 0;
        for (int i=1; i < height.length - 1; i++) {
            final int subWaterTrapped = Math.min(maxHeightToTheLeft[i], maxHeightToTheRight[i]) - height[i];
            if (subWaterTrapped > 0) {
                maxWaterTrapped += subWaterTrapped;
            }
        }

        return maxWaterTrapped;
    }
}