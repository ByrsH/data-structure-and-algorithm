package com.coding.basic.leetcode.binaryTree;

import java.util.LinkedList;
import java.util.Queue;

/***
 * @description: 226. 翻转二叉树  https://leetcode.cn/problems/invert-binary-tree/submissions/
 * @author: ByrsH
 * @create: 2023/3/4 11:59 AM
 **/
public class InvertTree {

    /**
     * 前序遍历
     * @param root
     * @return
     */
    public TreeNode invertTree1(TreeNode root) {
        if (root == null) return root;

        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;

        invertTree1(root.left);
        invertTree1(root.right);

        return root;
    }

    /**
     * 后序遍历
     * @param root
     * @return
     */
    public TreeNode invertTree2(TreeNode root) {
        if (root == null) return root;

        invertTree2(root.left);
        invertTree2(root.right);

        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;

        return root;
    }

    /**
     * 中序遍历
     * @param root
     * @return
     */
    public TreeNode invertTree3(TreeNode root) {
        if (root == null) return root;

        invertTree3(root.left);

        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;

        // 注意此时由于左子节点已经变为右子节点，因此这时应该是 left
        invertTree3(root.left);

        return root;
    }

    /**
     * 使用队列迭代的方式
     * @param root
     * @return
     */
    public TreeNode invertTree4(TreeNode root) {
        if (root == null) return root;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            TreeNode tmp = node.left;
            node.left = node.right;
            node.right = tmp;

            if (node.left != null) queue.add(node.left);
            if (node.right != null) queue.add(node.right);
        }
        return root;
    }

}
