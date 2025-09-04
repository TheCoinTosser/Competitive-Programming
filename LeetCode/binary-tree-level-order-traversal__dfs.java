/**
 * https://leetcode.com/problems/binary-tree-level-order-traversal/
 *
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    final List<List<Integer>> solution = new ArrayList<>();

    final Map<Integer /* level */, List<Integer> /* node values */> mapFromLevelToValues = new HashMap<>();

    public List<List<Integer>> levelOrder(TreeNode root) {
        traverse(root, 1);

        for(final Integer level : mapFromLevelToValues.keySet()) {
            solution.add(mapFromLevelToValues.get(level));
        }

        return solution;
    }

    private void traverse(TreeNode node, final int level) {
        if (node == null) return;

        if (mapFromLevelToValues.get(level) == null) {
            mapFromLevelToValues.put(level, new ArrayList<>(List.of(node.val)));
        } else {
            mapFromLevelToValues.get(level).add(node.val);
        }
        traverse(node.left, level + 1);
        traverse(node.right, level + 1);
    }
}