package com.takovh.myAlgorithm.DP01;

import java.util.Scanner;

public class Package01 {
	private static int W;//背包的容量
	private static int n;//物品的数量
	private static int v[];//物品的重量
	private static int w[];//物品的价值
	private static int p[][];//用于递归的数组
	private static int x[];//解向量
	
	private static int max(int i, int j) {return i > j ? i : j;	}
	private static int min(int i, int j) {return i < j ? i : j;	}
	//形参c是背包的容量W，n是物品的数量
	private static void knapsack(int c) { 
		//计算递推边界
		int jMax=min(w[n]-1,c); //分界点
		for( int j=0; j<=jMax; j++) p[n][j]=0; 
		for( int j=w[n]; j<=c; j++) p[n][j]=v[n];
		//计算递推式
		for( int i=n-1; i>1; i--) { 
			jMax=min(w[i]-1,c); 
			for( int j=0; j<=jMax; j++) p[i][j]=p[i+1][j]; 
			for(int j=w[i]; j<=c; j++) p[i][j]=max(p[i+1][j], p[i+1][j-w[i]]+v[i]); 
		} 
		p[1][c]=p[2][c]; //计算最优值
		if (c>=w[1]) p[1][c]=max(p[1][c], p[2][c-w[1]]+v[1]); 
	}
	private static void traceback(int c) { 
		for(int i=1; i<n; i++) {
			if (p[i][c]==p[i+1][c]) x[i]=0; 
			else { 
				x[i]=1; 
				c-=w[i]; 
			} 
		}
		x[n]=(p[n][c]>0)? 1:0; 
		System.out.println("装入的物品编号：" );
		for (int i=1; i<=n; i++)
			if (x[i]==1) System.out.print(i + " ");
	} 
	private static void input() {
		Scanner in = new Scanner(System.in);
		System.out.print("请输入背包的容量：");
		W = in.nextInt();
		System.out.print("请输入物品的数量：");
		n = in.nextInt();
		v = new int[n+1];
		w = new int[n+1];
		p = new int[n+1][W+1];
		x = new int[n+1];
		System.out.print("请输入物品的重量：");
		for(int i=1;i<=n;i++) w[i]=in.nextInt();
		System.out.print("请输入物品的价值：");
		for(int i=1;i<=n;i++) v[i]=in.nextInt();
		in.close();
	}
	public static void main(String[] args) {
		input();
		knapsack(W);
		System.out.println("装入的价值：" + p[1][W]);
		traceback(W);
	}
}
