/**
 * https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
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
    final List<List<Integer>> solutions = new ArrayList<>();
    final Queue<TreeNode> queue = new LinkedList<>();

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) return solutions;

        queue.add(root);
        BFS(true);

        return solutions;
    }

    private void BFS(final boolean isFowardPass) {
        final List<Integer> oneSolution = new ArrayList<>();
        final int queueSize = queue.size();
        for (int i=0; i<queueSize; i++) {
            final TreeNode nodeFromQueue = queue.poll();
            oneSolution.add(nodeFromQueue.val);
            if (nodeFromQueue.left != null) queue.add(nodeFromQueue.left);
            if (nodeFromQueue.right != null) queue.add(nodeFromQueue.right);
        }
        if (oneSolution.size() >= 1) {
            if (!isFowardPass) {
                Collections.reverse(oneSolution);
            }
            solutions.add(oneSolution);
            BFS(!isFowardPass);
        }
    }

}