package com.takovh.myAlgorithm.c03_dynamicProgramming.MatrixChain;
/**
 * .矩阵连乘积问题
 * @author tako_
 *
 */
public class MC {
	private static int NUM;
	private static int[] p;
	private static int[][] m;
	private static int[][] s;
	
	private static void Input() {
		NUM = 7;
		p = new int[NUM];
		p[0] = 50; p[1] = 10; p[2] = 40; p[3] = 30; p[4] = 5; p[5] = 20; p[6] = 15;
		m = new int[NUM][NUM];
		s = new int[NUM][NUM];
	}
	private static void MatrixChain(int n){ 
		for(int i=1; i<=n; i++) m[i][i] = 0; 
		for(int r=2; r<=n; r++) 
			for(int i=1; i<=n-r+1; i++){
				int j=i+r-1;
				//计算初值，从i处断开 　　
				m[i][j] = m[i][i] + m[i+1][j]+p[i-1]*p[i]*p[j];
				s[i][j] = i;
				for(int k=i+1; k<j; k++){
					int t = m[i][k]+m[k+1][j]+p[i-1]*p[k]*p[j]; 
					if(t < m[i][j]){
						m[i][j] = t; 
						s[i][j] = k;
					}
				} 
			} 
	}
	private static void TraceBack(int i, int j) { 
		if(i==j) System.out.print("A" + i);
		else { 
			System.out.print("(");
			TraceBack(i,s[i][j]); 
			TraceBack(s[i][j]+1,j); 
			System.out.print(")");
		} 
	} 

	public static void main(String[] args) {
		Input();
		MatrixChain(NUM-1);
		TraceBack(1,NUM-1);
	}
}
