package com.takovh.myAlgorithm.c01_dataStructure.binaryTree;

import java.util.*;

public class BinaryTree {
    public TreeNode root;
    private Traversal traversal = new BinaryTreeTraversal();

    public BinaryTree(int[] vals){
        List<TreeNode> nodes = new ArrayList<TreeNode>();
        for(int v : vals) nodes.add(new TreeNode(v));
        // 第一个数为根节点
        root = nodes.get(0);
        // 建立二叉树
        for (int i = 0; i <vals.length/2; i++) {
            // 左孩子
            nodes.get(i).left = nodes.get(i*2+1);
            // 右孩子
            if(i*2+2<nodes.size()){//避免偶数的时候 下标越界
                nodes.get(i).right = nodes.get(i*2+2);
            }
        }
    }

    public void setTraversal(Traversal traversal) {
        this.traversal = traversal;
    }

    /**
     * 层序遍历
     */
    public ArrayList<ArrayList<Integer>> levelOrderTraversal (){
        return traversal.levelOrderTraversal(this.root);
    }

    /**
     * 中序遍历
     */
    public List<Integer> orderTraversal (){
        return traversal.orderTraversal(this.root);
    }

    /**
     * 后序遍历
     */
    public List<Integer> postorderTraversal (){
        return traversal.postorderTraversal(this.root);
    }

    /**
     * 先序遍历
     */
    public List<Integer> preorderTraversal (){
        return traversal.preorderTraversal(this.root);
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree(new int[]{1,2,3,5,6,4,7,3});
        System.out.println("levelOrderTraversal\t= " + tree.levelOrderTraversal());
        System.out.println("preorderTraversal\t= " + tree.preorderTraversal());
        System.out.println("orderTraversal\t\t= " + tree.orderTraversal());
        System.out.println("postorderTraversal\t= " + tree.postorderTraversal());

        tree.setTraversal(new BinaryTreeTraversalByRecursive());
        System.out.println("递归遍历");
        System.out.println("levelOrderTraversal\t= " + tree.levelOrderTraversal());
        System.out.println("preorderTraversal\t= " + tree.preorderTraversal());
        System.out.println("orderTraversal\t\t= " + tree.orderTraversal());
        System.out.println("postorderTraversal\t= " + tree.postorderTraversal());
    }

}
