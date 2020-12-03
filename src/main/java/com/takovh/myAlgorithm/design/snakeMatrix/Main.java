package com.takovh.myAlgorithm.design.snakeMatrix;

import java.util.Scanner;

public class Main {

    final private int N;

    final private int[][] matrix;

    public Main(int n) {
        this.N = n;
        this.matrix = new int[N][N];
        int value = 1;
        int center = 0;
        if (N%2 == 0) center = N/2-1;
        else center = (N-1)/2;
        boolean flag = true;//顺时针
        for (int i = 0; i<center+1; i++){
            if (flag){
                //顺时针
                for (int j = i; j< N-i; j++){
                    matrix[j][i] = value;
                    value++;
                    if(value == N*N+1) break;
                }
                if(value == N*N+1) break;
                for (int j = i+1; j<N-i; j++){
                    matrix[N-i-1][j] = value;
                    value++;
                    if(value == N*N+1) break;
                }
                if(value == N*N+1) break;
                for (int j =N-i-2; j>i-1; j--){
                    matrix[j][N-i-1] = value;
                    value++;
                    if(value == N*N+1) break;
                }
                if(value == N*N+1) break;
                for (int j =N-i-2; j>i; j--){
                    matrix[i][j] = value;
                    value++;
                    if(value == N*N+1) break;
                }
                if(value == N*N+1) break;
            } else {
                //逆时针
                for (int j = i; j< N-i; j++){
                    matrix[i][j] = value;
                    value++;
                    if(value == N*N+1) break;
                }
                if(value == N*N+1) break;
                for (int j = i+1; j<N-i; j++){
                    matrix[j][N-i-1] = value;
                    value++;
                    if(value == N*N+1) break;
                }
                if(value == N*N+1) break;
                for (int j =N-i-2; j>i-1; j--){
                    matrix[N-i-1][j] = value;
                    value++;
                    if(value == N*N+1) break;
                }
                if(value == N*N+1) break;
                for (int j =N-i-2; j>i; j--){
                    matrix[j][i] = value;
                    value++;
                    if(value == N*N+1) break;
                }
                if(value == N*N+1) break;
            }
            flag = !flag;
            if(value == N*N+1) break;
        }
    }

    public int getN() {
        return N;
    }

    public int[][] getMatrix() {
        return matrix;
    }

    public void print(){
        for (int i = 0; i<this.N; i++){
            for (int j = 0; j<N; j++){
                System.out.print(this.matrix[j][i] + "\t");
            }
            System.out.println("");
        }
    }

    /**
     * 测试用例：
     * 1        代表只有1组数据
     * 7 3      代表N=7的二维数组，需要查3个坐标的数据
     * 1 1      代表第1组坐标
     * 2 2      代表第2组坐标
     * 3 3      代表第3组坐标
     *
     * 输出：
     * 25
     * 41
     * 49
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int groupMemberNum = Integer.valueOf(in.nextLine());

        for (int i = 0; i<groupMemberNum; i++){
            String s1 = in.nextLine();
            int N = Integer.valueOf(s1.split(" ")[0]);
            Main test = new Main(N);
            int querys = Integer.valueOf(s1.split(" ")[1]);
            for (int j = 0; j<querys; j++){
                String s2 = in.nextLine();
                int x = Integer.valueOf(s2.split(" ")[0]);
                int y = Integer.valueOf(s2.split(" ")[1]);
                System.out.println(test.matrix[x][y]);
            }
        }
        in.close();
    }
}
