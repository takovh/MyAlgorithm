package com.takovh.myAlgorithm.c03_dynamicProgramming.LongestCommonSubsequence;

import java.util.Scanner;

/**
 * 求最长公共子序列算法
 * @author tako_
 */
public class LCSAll {
	/**
	 * str1：第一个字符串
	 * str2：第二个字符串
	 * length1：第一个字符串的长度
	 * length2：第二个字符串的长度
	 * len：最长公共子序列的长度
	 */
	private static String str1, str2;
	private static int length1,length2,len;
	/**
	 * b[][] 记录输出公共子串时的搜索方向
	 * b[i][j]=1 ：向对角线方向
	 * b[i][j]=2 ：向上
	 * b[i][j]=3 ：向左
	 * b[i][j]=8 ：向左或上
	 */
	private static int[][] b;
	/**
	 * c[][] 记录最长公共子序列的长度
	 */
	private static int[][] c;
			
	/**
	 * 
	 * @return 最长公共子序列的长度
	 */
	private static int LCSLength() {
		for(int i = 0; i < length1+1; i++) c[i][0]=0;  //第0列都初始化为0
		for(int j = 0; j < length2+1; j++) c[0][j]=0;  //第0行都初始化为0
		for(int i = 1; i < length1+1; i++){
			for(int j = 1; j < length2+1; j++){
				//双层循环完成b[][]、c[][]的赋值
				if(str1.charAt(i-1)==str2.charAt(j-1)) {//由于c[][]的0行0列没有使用，c[][]的第i行元素对应str1的第i-1个元素				
					c[i][j]=c[i-1][j-1]+1;
					b[i][j]=1;  //输出公共子串时的搜索方向：对角线
				}
				else if(c[i-1][j]>c[i][j-1]){
					c[i][j]=c[i-1][j];
					b[i][j]=2;  //输出公共子串时的搜索方向：向上
				}
				else if(c[i-1][j]==c[i][j-1]){
					c[i][j]=c[i-1][j];
					b[i][j]=8;  //输出公共子串时的搜索方向：向上或向左
				}
				else if(c[i-1][j]<c[i][j-1]){
					c[i][j]=c[i][j-1];
					b[i][j]=3;  //输出公共子串时的搜索方向：向左
				}
			}
		}
		return c[length1][length2];
	}
	
	
	/**
	 * 递归打印最长公共子序列
	 * @param i
	 * @param j
	 */
	private static void printAllLcs(String lcs, int i, int j) {
		if (i == 0 || j == 0) {
            StringBuilder sb = new StringBuilder(lcs);
            lcs = sb.reverse().toString();
//          if (lcs.length() == len) System.out.println(lcs);  //不需要判断？
            System.out.println(lcs);
            return;
        }
        switch (b[i][j]) {
        case 1:// 代表向左上
            lcs +=  str1.charAt(i-1);
            printAllLcs(lcs,i-1,j-1);// 向左上    
            break;
        case 2:// 代表向上
            printAllLcs(lcs,i-1,j);// 向上    
            break;     
        case 3:// 代表向左
            printAllLcs(lcs,i,j-1);// 向左
            break;
        case 8:// 代表向上 或 代表向左           
            printAllLcs(lcs,i-1,j);// 向上            
            printAllLcs(lcs,i,j-1);// 向左
            break;
        }
	}
	
	public static void main(String[] args) {
		String lcs = new String();
		Scanner in = new Scanner(System.in);
	    //str1 = "BDCABA";str2 = "ABCBDAB";
		//BCBA BCAB BDAB
		//str1 = "AABA";
		//str2 = "CACA";
		System.out.print("请输入第一个字符串：");
		str1 = in.nextLine();
		System.out.print("请输入第二个字符串：");
		str2 = in.nextLine();
		in.close();
		length1 = str1.length();
		length2 = str2.length();
		b = new int[length1+1][length2+1];
		c = new int[length1+1][length2+1];
		len = LCSLength();
		
		System.out.println("最长公共子序列的长度为："+len);
		System.out.println("最长公共子序列为：");
		printAllLcs(lcs,length1,length2);	
	}		
}
