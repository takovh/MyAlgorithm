package com.takovh.myAlgorithm.design.LRU;

import java.util.*;

/**
 * 题目描述
 * 设计LRU缓存结构，该结构在构造时确定大小，假设大小为K，并有如下两个功能
 * set(key, value)：将记录(key, value)插入该结构
 * get(key)：返回key对应的value值
 *
 * [要求]
 * 1、set和get方法的时间复杂度为O(1)
 * 2、某个key的set或get操作一旦发生，认为这个key的记录成了最常使用的。
 * 3、当缓存的大小超过K时，移除最不经常使用的记录，即set或get最久远的。
 *
 * 若opt=1，接下来两个整数x, y，表示set(x, y)
 * 若opt=2，接下来一个整数x，表示get(x)，若x未出现过或已被移除，则返回-1
 * 对于每个操作2，输出一个答案
 *
 * 示例1
 * 输入
 * [[1,1,1],[1,2,2],[1,3,2],[2,1],[1,4,4],[2,2]],3
 * 输出
 * [1,-1]
 *
 * 说明
 * 第一次操作后：最常使用的记录为("1", 1)
 * 第二次操作后：最常使用的记录为("2", 2)，("1", 1)变为最不常用的
 * 第三次操作后：最常使用的记录为("3", 2)，("1", 1)还是最不常用的
 * 第四次操作后：最常用的记录为("1", 1)，("2", 2)变为最不常用的
 * 第五次操作后：大小超过了3，所以移除此时最不常使用的记录("2", 2)，加入记录("4", 4)，并且为最常使用的记录，然后("3", 2)变为最不常使用的记录
 */
public class LRUTest {
    class KVSet{
        int key;
        int value;

        public KVSet(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
    class LRUCache{
        KVSet[] array;
        final int size;

        public LRUCache(int size) {
            this.size = size;
            array = new KVSet[size];
        }

        public void set(KVSet kv){
            KVSet s = null;
            for (int i = 0; i < size; i++){
                //有空位
                if(array[i] == null){
                    array[i] = kv;
                    s = array[i];
                    moveToTop(i);
                    break;
                }
                //覆盖旧的
                if(array[i].key == kv.key){
                    s = array[i];
                    moveToTop(i);
                    break;
                }
            }
            //新增缓存
            if(s == null){
                array[size-1] = kv;
                moveToTop(size-1);
            }
        }
        public int get(int key){
            KVSet s = null;
            for (int i = 0; i < size; i++){
                if(array[i].key == key){
                    s = array[i];
                    moveToTop(i);
                }
            }
            if (s != null) return s.value;
            else return -1;
        }
        public void moveToTop(int index){

            while (index - 1 > -1){
                KVSet s = array[index];
                array[index] = array[index-1];
                array[index-1] = s;
                index--;
            }
        }
    }



    /**
     * lru com.takovh.myAlgorithm.design
     * @param operators int整型二维数组 the ops
     * @param k int整型 the k
     * @return int整型一维数组
     */
    public int[] LRU (int[][] operators, int k) {
//        // write code here
//        LRUCache cache = new LRUCache(k);
//        List<Integer> result = new ArrayList();
//        for(int i = 0; i < operators.length; i++){
//            int[] op = operators[i];
//            switch (op[0]){
//                case 1: cache.set(new KVSet(op[1], op[2])); break;
//                case 2: {
//                    int v = cache.get(op[1]);
//                    result.add(v);
//                } break;
//                default:break;
//            }
//        }
//        if(result.size()!=0){
//            int[] arr = new int[result.size()];
//            int index = 0;
//            for (int item : result){
//                arr[index] = item;
//                index++;
//            }
//            return arr;
//        }else{
//            return new int[]{};
//        }
        int resultLength = 0;
        for (int[] operator : operators) {
            if (operator[0] == 2) {
                resultLength++;
            }
        }
        int[] results = new int[resultLength];
        int index = 0;

        LRUCache cache = new LRUCache(k);
        List<Integer> resultList = new LinkedList<>();
        for (int[] operator : operators) {
            switch (operator[0]) {
                case 1:
                    cache.set(new KVSet(operator[1], operator[2]));
                    break;
                case 2:
                    Integer value = cache.get(operator[1]);
                    results[index++] = value;
            }
        }
        return results;
    }

    public static void main(String[] args) {
        LRUTest test = new LRUTest();
        int[][] operators = new int[][]{{1,1,1},{1,2,2},{1,3,2},{2,1},{1,4,4},{2,2}};
        int[] result = test.LRU(operators,3);
        System.out.println(result);
    }

}
