/**
 * https://leetcode.com/problems/validate-binary-search-tree
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

/**
 * The idea is that we traverse the tree in-order.
 * When you traverse in order, you should get a strictly increasing sequence of vals, so we only need to keep track of the last known val
 * and compare its value against the current node being visited
 */
class Solution {

    Integer lastKnownVal = null;

    public boolean isValidBST(final TreeNode root) {
        if (root == null) return true;
        return inOrder(root);
    }

    private boolean inOrder(TreeNode node) {
        boolean leftOk = true;
        boolean rightOk = true;
        if (node.left != null) {
            leftOk = inOrder(node.left);
        }

        final boolean valConstraintOk = lastKnownVal == null || (node.val > lastKnownVal);
        lastKnownVal = node.val;

        if (node.right != null) {
            rightOk = inOrder(node.right);
        }
        
        return leftOk && rightOk && valConstraintOk;
    }
}