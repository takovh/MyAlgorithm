package dataStructure.binaryTree;

import java.util.LinkedList;
import java.util.List;

public class BinaryTreeTraversalByRecursive extends BinaryTreeTraversal {
    public List<Integer> preorderTraversalData = new LinkedList<>();
    public List<Integer> orderTraversalData = new LinkedList<>();
    public List<Integer> postorderTraversalData = new LinkedList<>();

    /**
     * 递归中序遍历（左->根->右）
     */
    @Override
    public List<Integer> orderTraversal(TreeNode root) {
        orderTraversalData.clear();
        order(root);
        return orderTraversalData;
    }
    private void order(TreeNode node){
        if(node!=null){
            order(node.left);
            orderTraversalData.add(node.val);
            order(node.right);
        }
    }

    /**
     * 递归后序遍历（左->右->根）
     */
    @Override
    public List<Integer> postorderTraversal(TreeNode root) {
        postorderTraversalData.clear();
        post(root);
        return postorderTraversalData;
    }
    private void post(TreeNode node){
        if(node!=null){
            post(node.left);
            post(node.right);
            postorderTraversalData.add(node.val);
        }
    }

    /**
     * 递归先序遍历（根->左->右）
     */
    @Override
    public List<Integer> preorderTraversal(TreeNode root) {
        preorderTraversalData.clear();
        pre(root);
        return preorderTraversalData;
    }
    private void pre(TreeNode node){
        if(node!=null){
            preorderTraversalData.add(node.val);
            pre(node.left);
            pre(node.right);
        }
    }
}
