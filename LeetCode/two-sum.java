// https://leetcode.com/problems/two-sum/description/

class Solution {
    
    private final Map<Integer, Integer> mapNumberToIndex = new HashMap<>();
    
    public int[] twoSum(int[] nums, int target) {
        for(int i=0; i<nums.length; i++){
            final int number = nums[i];
            final int complement = target - number;
            
            if(mapNumberToIndex.containsKey(complement)) {
                final int[] indexes = new int[2];
                final int complementIndex = mapNumberToIndex.get(complement);
                return new int[] { complementIndex, i };
            }
            
            mapNumberToIndex.put(number, i);
        }
        return null;
    }
}