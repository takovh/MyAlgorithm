package com.takovh.myAlgorithm.c01_dataStructure.binaryTree;

import java.util.ArrayList;
import java.util.List;

public interface Traversal {
    /**
     * 给定一个二叉树，返回该二叉树层序遍历的结果，（从左到右，一层一层地遍历）
     * 例如：给定的二叉树是{3,9,20,#,#,15,7},
     * 该二叉树层序遍历的结果是[[3],[9,20],[15,7]]
     * @param root TreeNode类
     * @return int整型ArrayList<ArrayList<>>
     */
    ArrayList<ArrayList<Integer>> levelOrderTraversal (TreeNode root);

    /**
     * 中序遍历
     */
    List<Integer> orderTraversal (TreeNode root);

    /**
     * 后序遍历
     */
    List<Integer> postorderTraversal (TreeNode root);

    /**
     * 先序遍历
     */
    List<Integer> preorderTraversal (TreeNode root);
}
