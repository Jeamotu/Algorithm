package leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class LeetCode_00938_RangeSumBST {

    // 深度优先搜索
    public int rangeSumBST1(TreeNode root, int low, int high) {
        if (root == null) {
            return 0;
        }
        if (root.val > high) {
            return rangeSumBST1(root.left, low, high);
        }
        if (root.val < low) {
            return rangeSumBST1(root.right, low, high);
        }

        return root.val + rangeSumBST1(root.left, low, high) + rangeSumBST1(root.right, low, high);
    }

    // 广优先搜索
    public int rangeSumBST2(TreeNode root, int low, int high) {
        int sum = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null) {
                continue;
            }
            if (node.val > high) {
                queue.offer(node.left);
            } else if (node.val < low) {
                queue.offer(node.right);
            } else {
                sum = sum + node.val;
                queue.offer(node.left);
                queue.offer(node.right);
            }
        }
        return sum;
    }


    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
