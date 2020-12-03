package com.takovh.myAlgorithm.c01_dataStructure.binaryTree;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeTools {
    /**
     * 检查是否有叶子节点到根节点的val之和等于sum
     * 不考虑负数，可以提前结束判断
     * @param root
     * @param sum
     * @return
     */
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root==null){
            return false;
        }
        if(root.left==null&&root.right==null){
            return root.val==sum;
        }
        List<String> list = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        int curSum = 0;
        getAllPath(root, stack, curSum,sum,list);
        boolean result = false;
        //通过list中是否有值来判断是否存在
        if(list.size()>0){
            for (String s : list) System.out.println(s);
            result = true;
        }
        return result;
    }

    public void getAllPath(TreeNode rootNode, Stack<TreeNode> stack, int curSum, int expectedSum, List<String> list){
        stack.push(rootNode);
        curSum+=rootNode.val;

        boolean isLeaf = rootNode.left==null&&rootNode.right==null;
        if(isLeaf && curSum==expectedSum){
            //把栈中的元素拿出来，组成数字
            Iterator<TreeNode> iterator = stack.iterator();
            String path = "[";
            while(iterator.hasNext()){
                path += iterator.next().val+", ";
            }
            path = path.substring(0, path.length()-2) + "]";
            list.add(path);
        }

        if(rootNode.left!=null){
            getAllPath(rootNode.left, stack, curSum,expectedSum,list);
        }
        if(rootNode.right!=null){
            getAllPath(rootNode.right, stack,curSum,expectedSum,list);
        }
        //返回父节点之前要先弹出
        stack.pop();
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree(new int[]{1,2,3,5,6,4,7,3});
        BinaryTreeTools binaryTreeTools = new BinaryTreeTools();
        binaryTreeTools.hasPathSum(tree.root, 11);
    }
}
