package dataStructure.binaryTree;

import java.util.*;

public class BinaryTree {
    public TreeNode root;
    public List<TreeNode> nodes;

    public List<Integer> preorderTraversalData = new LinkedList<>();
    public List<Integer> orderTraversalData = new LinkedList<>();
    public List<Integer> postorderTraversalData = new LinkedList<>();


    public BinaryTree(int[] vals){
        nodes=new ArrayList<TreeNode>();
        for(int v : vals){
            nodes.add(new TreeNode(v));
        }
        // 第一个数为根节点
        root=nodes.get(0);
        // 建立二叉树
        for (int i = 0; i <vals.length/2; i++) {
            // 左孩子
             nodes.get(i).left=nodes.get(i*2+1);
            // 右孩子
            if(i*2+2<nodes.size()){//避免偶数的时候 下标越界
                nodes.get(i).right=nodes.get(i*2+2);
            }
        }
    }

    /**
     * 递归先序遍历（根->左->右）
     */
    public synchronized List<Integer> preorderRecursive(){
        preorderTraversalData.clear();
        pre(this.root);
        System.out.println("递归先序:" + preorderTraversalData);
        return preorderTraversalData;
    }
    private void pre(TreeNode node){
        if(node!=null){
            preorderTraversalData.add(node.val);
            pre(node.left);
            pre(node.right);
        }
    }

    /**
     * 用非递归的方法进行先序遍历
     */
    public void preorderStack() {
        preorderTraversalData.clear();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode node = this.root;

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
        System.out.println("堆栈先序:" + preorderTraversalData);
    }

    /**
     * 检查是否有叶子节点到根节点的val之和等于sum
     * 不考虑负数，可以提前结束判断
     * @param sum
     * @return
     */
    public boolean hasPathSum(int sum){
        return hasPathSum(this.root, sum);
    }

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
            return true;
        }
        return result;
    }

    public void getAllPath(TreeNode rootNode,Stack<TreeNode> stack,int curSum, int expectedSum,List<String> list){
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



    /**
     * 递归中序遍历（左->根->右）
     */
    public synchronized List<Integer> orderRecursive(){
        orderTraversalData.clear();
        order(this.root);
        System.out.println("递归中序:" + orderTraversalData);
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
     * 用非递归的方法进行中序遍历
     */
    public void orderStack() {
        orderTraversalData.clear();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode treeNode = this.root;
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
        System.out.println("堆栈中序:" + preorderTraversalData);
    }



    /**
     * 递归后序遍历（左->右->根）
     */
    public synchronized List<Integer> postorderRecursive(){
        postorderTraversalData.clear();
        post(root);
        System.out.println("递归后序:" + postorderTraversalData);
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
     * 用非递归的方法进行后序遍历
     */
    public void postorderStack() {
        postorderTraversalData.clear();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode treeNode = this.root;
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
                        System.out.println("堆栈后序:" + postorderTraversalData);
                        return;
                    } else {
                        preNode = treeNode;
                    }
                } else {
                    treeNode = treeNode.right;
                    tag = false;
                }
            }
        }
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree(new int[]{1,2,3,5,6,4,7,3});
        tree.preorderRecursive();
        tree.preorderStack();
        tree.orderRecursive();
        tree.orderStack();
        tree.postorderRecursive();
        tree.postorderStack();
        tree.hasPathSum(11);
    }


}
