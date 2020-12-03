package com.takovh.myAlgorithm.examination.day2;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int num = s.nextInt();
        System.out.println(getSum(num-1));
    }
    public static int getSum(int num){
        if (num<3) return 0;
        if (num==3) return 3;
        if (num%3==0||num%5==0){
            return num + getSum(num-1);
        }else{
            return getSum(num-1);
        }
    }
}
