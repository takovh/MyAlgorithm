package com.takovh.myAlgorithm;

import java.util.*;


public class Solution {
    /**
     *
     * @param inputArray string字符串一维数组 
     * @return string字符串一维数组
     */
    public String[] countString (String[] inputArray) {
        // write code here
        Map<String, Integer> map = new HashMap<>();
        List<String> list = new ArrayList<>();
        for (String s : inputArray){
            if (map.get(s)!=null){
                map.put(s, map.get(s) + 1);
            } else {
                map.put(s, 1);
            }
        }
        for (Map.Entry<String, Integer> e : map.entrySet()){
            if(e.getValue()>1) list.add(e.getKey());
        }
        String[]  result = new String[list.size()];
        for (int i=0;i<list.size();i++){
            result[i] = list.get(i);
        }
        return result;
    }

    /**
     *
     * @param n int整型
     * @return int整型
     */
    public int getPayCount (int n) {
        // write code here
        return getDivideWays(n, new int[]{1,2,5,10});
    }

    /**
     * 2、组合元素一般化：将total元兑换为large元、middle元、small元的零钱，请问有多少种兑换方法？
     *
     * @param total
     * @param large
     * @param middle
     * @param small
     * @return
     * @author chenchanghan
     */
    public static int getDivideWays(int total, int large, int middle, int small) {
        if (total > 0 && small > 0 && middle > small && large > middle) {
            int count = 0;
            int LCM = getLeastCommonMutiple(middle, small);
            int substituteUnit = LCM / middle;
            for (int i = 0, size = total / large; i <= size; i++) {
                int restTotal = total - i * large;
                if (restTotal > 0) {
                    // actualMaxMiddleNum>=0,表示restTotal正好可以有x个middle和y个small拼凑起来（x、y是大于等于0的整数）
                    int actualMaxMiddleNum = getActualMaxMiddleNum(restTotal, middle, small);
                    if (actualMaxMiddleNum >= substituteUnit) {
                        // actualMaxMiddleNum >=substituteUnit,表示可以将substituteUnit个middle替换成LCM/small个small
                        // 可以换多少次呢？显然可以换0、1...actualMaxMiddleNum/substituteUnit,即：actualMaxMiddleNum/substituteUnit+1
                        count += actualMaxMiddleNum / substituteUnit + 1;
                    } else if (actualMaxMiddleNum >= 0) {
                        // 0<=actualMaxMiddleNum<substituteUnit,表示正好可以勉强匹配
                        // 因为<substituteUnit，所以无法找到一个活动的最小公倍数，来实施middle和small的互换。
                        count++;
                    }
                } else {
                    // 正好被large完美匹配了
                    count++;
                }
            }
            return count;
        } else {
            throw new IllegalArgumentException();
        }
    }

    /**
     * 获得方程：x*middle + y*small = restTotal 中x最大的取值。
     *
     * @param restTotal
     * @param middle
     * @param small
     * @return
     * @author chenchanghan
     */
    private static int getActualMaxMiddleNum(int restTotal, int middle, int small) {
        int modMiddle = restTotal % middle;
        int maxMiddleNum = restTotal / middle;
        int actualMaxMiddleNum = -1;
        if (modMiddle == 0 || modMiddle == small) {
            actualMaxMiddleNum = maxMiddleNum;
        } else {
            // 无法使用最大数量（即：maxMiddleNum）的middle和small组合成restTotal,
            // 则需要逐步减少middle的个数，进而增加small的个数，来尝试组合成restTotal。
            int minusMiddleNum = getMinusMiddleNum(middle, small, modMiddle, maxMiddleNum);
            if (minusMiddleNum > 0) {
                // 表示可以形成一个拥有最大middle数的组合，即： (maxMiddleNum - minusMiddleNum)*middle + y*small = restTotal ;
                actualMaxMiddleNum = maxMiddleNum - minusMiddleNum;
            } else {
                // middle和small无论怎么组合都无法拼凑成restTotal，即：x*middle + y*small = restTotal 的整数解不存在
                actualMaxMiddleNum = -1;
            }
        }
        return actualMaxMiddleNum;
    }

    /**
     *
     * @param middle
     * @param small
     * @param modMiddle
     * @param maxMiddleNum
     * @return
     * @author chenchanghan
     */
    private static int getMinusMiddleNum(int middle, int small, int modMiddle, int maxMiddleNum) {
        int minusMiddleNum = -1;
        for (int i = 1; i <= maxMiddleNum; i++) {
            if ((middle * i + modMiddle) % small == 0) {
                minusMiddleNum = i;
                break;
            }
        }
        return minusMiddleNum;
    }

    /**
     * 求两个数的最小公倍数。
     *
     * @param m
     * @param n
     * @return
     * @author chenchanghan
     */
    private static int getLeastCommonMutiple(int m, int n) {
        return m * n / getGreatestDivisor(m, n);
    }

    /**
     * 求两个数的最大公约数。
     *
     * @param m
     * @param n
     * @return
     * @author chenchanghan
     */
    private static int getGreatestDivisor(int m, int n) {
        int tmp = 0;
        if (m < n) {
            tmp = m;
            m = n;
            n = tmp;
        }
        while ((tmp = m % n) != 0) {
            m = n;
            n = tmp;
        }
        return n;
    }



        /**
         * 3、元素个数一般化：将total元兑换为a元、b元、c元、....的零钱，请问有多少种兑换方法？
         *
         * @param total
         * @param elements
         * @return
         * @author chenchanghan
         */
    public static int getDivideWays(int total,int[] elements) {
        if (elements != null && elements.length >= 3) {
            int count = 0;
            if (elements.length == 3) {
                count += getDivideWays(total, elements[0], elements[1], elements[2]);
            } else {
                int large = elements[0];
                int[] subElements = new int[elements.length - 1];
                System.arraycopy(elements, 1, subElements, 0, subElements.length);
                for (int i = 0, size = total / large; i <= size; i++) {
                    int restTotal = total - i * large;
                    if (restTotal != 0) {
                        count += getDivideWays(restTotal, subElements);
                    } else {
                        count++;
                    }
                }
            }
            return count;
        } else {
            throw new IllegalArgumentException();
        }
    }





        public List<Long> postorderTraversalData = new ArrayList<>();
    /**
     *
     * @param preorderData long长整型一维数组
     * @param inorderData long长整型一维数组
     * @return long长整型一维数组
     */
    public long[] buildPostOrder (long[] preorderData, long[] inorderData) {
        // write code here
        TreeNode root = buildTreeByPreAndIn(preorderData, 0, preorderData.length - 1, inorderData, 0, inorderData.length - 1);
        postorderRecursive(root);
        int len = postorderTraversalData.size();
        long postorderData[] = new long[len];
        for (int i=0; i<len; i++){
            postorderData[i] = postorderTraversalData.get(i);
        }
        return postorderData;
    }

    public TreeNode buildTreeByPreAndIn(long[] pre, int startPre, int endPre, long[] in, int startIn, int endIn){
        if (startPre > endPre || startIn > endIn) {
            return null;
        }
        TreeNode root = new TreeNode(pre[startPre]);
        for (int i = startIn; i <= endIn; i++)
            if (in[i] == pre[startPre]) {
                root.left = buildTreeByPreAndIn(pre, startPre + 1, startPre + i - startIn, in, startIn, i - 1);
                root.right = buildTreeByPreAndIn(pre, i - startIn + startPre + 1, endPre, in, i + 1, endIn);
                break;
            }
        return root;
    }

    public List<Long> postorderRecursive(TreeNode root){
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

    class TreeNode{
        TreeNode left;
        TreeNode right;
        long val;

        public TreeNode(long val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }
}