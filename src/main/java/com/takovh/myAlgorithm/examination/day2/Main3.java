package com.takovh.myAlgorithm.examination.day2;

import java.util.ArrayList;
import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Integer[] a = getInput();
        System.out.println(getSum(a));
    }

    /**
     * 获取最大的字串和
     * @param nums
     * @return
     */
    public static int getSum(Integer[] nums){
        int len = nums.length;
        if (len==0) return 0;
        int currentSum = nums[0];
        int biggestSum = currentSum;
        for (int i = 1; i < len; i++) {
            if (currentSum>0){
                currentSum += nums[i];
            }else{
                currentSum = nums[i];
            }
            if (currentSum>biggestSum) biggestSum=currentSum;
        }
        return biggestSum;
    }

    public static Integer[] getInput(){
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();
        while (scanner.hasNext()){
            list.add(scanner.nextInt());
        }
        return list.toArray(new Integer[list.size()]);
    }
}
