package com.takovh.myAlgorithm.c01_dataStructure.binaryTree;

import java.util.*;

public class BinaryTreeTraversal implements Traversal {
    /**
     * 给定一个二叉树，返回该二叉树层序遍历的结果，（从左到右，一层一层地遍历）
     * 例如：给定的二叉树是{3,9,20,#,#,15,7},
     * 该二叉树层序遍历的结果是[[3],[9,20],[15,7]]
     * @param root TreeNode类
     * @return int整型ArrayList<ArrayList<>>
     */
    @Override
    public ArrayList<ArrayList<Integer>> levelOrderTraversal (TreeNode root) {
        // write code here
        if(root == null) return new ArrayList<ArrayList<Integer>>();
        Queue<TreeNode> q1 = new LinkedList<>();
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        q1.offer(root);
        while(true){
            ArrayList<Integer> list = new ArrayList<>();
            Queue<TreeNode> q2 = new LinkedList<>();
            while(!q1.isEmpty()){
                TreeNode node = q1.poll();
                list.add(node.val);
                if(node.left!=null) q2.offer(node.left);
                if(node.right!=null) q2.offer(node.right);
            }
            result.add(list);
            q1 = q2;
            if(q1.isEmpty()) break;
        }
        return result;
    }

    /**
     * 用非递归的方法进行中序遍历
     */
    @Override
    public List<Integer> orderTraversal (TreeNode root) {
        List<Integer> orderTraversalData = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode treeNode = root;
        while (treeNode != null || !stack.isEmpty()) {
            while (treeNode != null) {
                stack.push(treeNode);
                treeNode = treeNode.left;
            }
            if (!stack.isEmpty()) {
                treeNode = stack.pop();
                orderTraversalData.add(treeNode.val);
                treeNode = treeNode.right;
            }
        }
        return orderTraversalData;
    }

    /**
     * 用非递归的方法进行先序遍历
     */
    @Override
    public List<Integer> preorderTraversal (TreeNode root) {
        List<Integer> preorderTraversalData = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode node = root;

        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                preorderTraversalData.add(node.val);
                stack.push(node);
                node = node.left;
            }
            if(!stack.isEmpty()){
                node = stack.pop();
                node = node.right;
            }
        }
        return preorderTraversalData;
    }

    /**
     * 用非递归的方法进行后序遍历
     */
    @Override
    public List<Integer> postorderTraversal (TreeNode root) {
        List<Integer> postorderTraversalData = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode treeNode = root;
        while (treeNode != null || !stack.isEmpty()) {
            while (treeNode != null) {
                stack.push(treeNode);
                treeNode = treeNode.left;
            }
            boolean tag = true;
            TreeNode preNode = null;  // 前驱节点
            while (!stack.isEmpty() && tag == true) {
                treeNode = stack.peek();
                if (treeNode.right == preNode) { // 之前访问的为空节点或是栈顶节点的右子节点
                    treeNode = stack.pop();
                    postorderTraversalData.add(treeNode.val);
                    if (stack.isEmpty()) {
                        return postorderTraversalData;
                    } else {
                        preNode = treeNode;
                    }
                } else {
                    treeNode = treeNode.right;
                    tag = false;
                }
            }
        }
        return postorderTraversalData;
    }

}
