// https://leetcode.com/problems/frog-jump/
class Solution {
    Map<Pair<Integer, Integer>, Boolean> solution = new HashMap<>();
    Set<Integer> stoneIndexes = new HashSet<>();

    public boolean canCross(final int[] stones) {
        for (int i=0; i < stones.length; i++) {
            stoneIndexes.add(stones[i]);
        }
        return canCross(stones, 1, 1);
    }

    private boolean canCross(final int[] stones, final int index, final int prevJump) {
        final int lastStonePosition = stones[stones.length - 1];
        if (index == lastStonePosition) {
            // Frog arrived on the last stone!
            return true;
        }
        if (index < 0 || index > lastStonePosition || !stoneIndexes.contains(index)) {
            // Frog stepped outside boundaries or into the water
            return false;
        }

        if (solution.get(new Pair(index, prevJump)) != null) {
            // Already calculate this before
            return solution.get(new Pair(index, prevJump));
        }

        // New case (and frog is on a stone)

        // Next jumps
        int nextJumpA = prevJump - 1;
        int nextJumpB = prevJump;
        int nextJumpC = prevJump + 1;

        // Calculate steps k - 1, k and k + 1
        // The condition "index + nextJumpA > index" is because the frog is only supposed to jump forward
        final boolean result1 = index + nextJumpA > index ? canCross(stones, index + nextJumpA, nextJumpA) : false;
        final boolean result2 = index + nextJumpB > index ? canCross(stones, index + nextJumpB, nextJumpB) : false;
        final boolean result3 = index + nextJumpC > index ? canCross(stones, index + nextJumpC, nextJumpC) : false;
        final boolean wasFrogAbleToFinish = result1 || result2 || result3;
        solution.put(new Pair(index, prevJump), wasFrogAbleToFinish);

        return wasFrogAbleToFinish;
    }
}