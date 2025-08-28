// https://leetcode.com/problems/3sum/description/
class Solution {

    public List<List<Integer>> threeSum(int[] nums) {
        final Set<List<Integer>> solutions = new HashSet<>();

        // We need to find num[i] + num[j] = -num[k]
        // O(n^2) complexity as we only need to loop through pairs (num[i], num[j]), not (num[i], num[j], num[k]), which would be O(n^3)

        // Pre-processing that stores the negatives and
        Map<Integer, List<Integer>> negatives = new HashMap<>();
        for (int i=0; i<nums.length; i++) {
            final int negative = -nums[i];
            if (negatives.containsKey(negative)) {
                List<Integer> indexes = negatives.get(negative);
                indexes.add(i);
                negatives.put(negative, indexes);
            } else {
                negatives.put(negative, new ArrayList<>(Arrays.asList(i)));
            }
        }

        for (int i=0; i<nums.length; i++) {
            for (int j=i+1; j<nums.length; j++) {
                final int sum = nums[i] + nums[j];
                if (negatives.containsKey(sum)) {
                    boolean foundDifferentIndexes = false;
                    final List<Integer> indexesArray = negatives.get(sum);
                    for (int k=0; k < indexesArray.size(); k++) {
                        final int lastIndex = indexesArray.get(k);
                        if (lastIndex != i && lastIndex != j) {
                            foundDifferentIndexes = true;
                            break;
                        }
                    }
                    if (foundDifferentIndexes) {
                        // Found a solution! (could still be repeated though, so we need to sort it to make sure duplicates are removed)
                        final List<Integer> oneSolution = Arrays.asList(nums[i], nums[j], -sum);
                        Collections.sort(oneSolution);

                        solutions.add(oneSolution);
                    }
                }
            }
        }

        return new ArrayList<>(solutions);
    }
}