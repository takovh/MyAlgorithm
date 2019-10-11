package LongestCommonSubsequence;

import java.util.Scanner;

/**
 * 求最长公共子序列算法
 * @author tako_
 * @param b[][] 记录输出公共子串时的搜索方向
 * 				b[i][j]=1 ：向对角线方向
 * 				b[i][j]=2 ：向上
 * 				b[i][j]=3 ：向左
 * @param c[][] 记录最长公共子序列的长度
 */
public class LCS {
	private static String str1, str2;
	private static int length1,length2,len;
	private static int[][] b;
	private static int[][] c;
	

	/**
	 * 
	 * @return 最长公共子序列的长度
	 */
	private static void LCSLength() {
		for(int i = 0; i < length1+1; i++) c[i][0]=0;  //第0列都初始化为0
		for(int j = 0; j < length2+1; j++) c[0][j]=0;  //第0行都初始化为0
		for(int i = 1; i < length1+1; i++){
			for(int j = 1; j < length2+1; j++){
				//双层循环完成b[][]、c[][]的赋值
				if(str1.charAt(i-1)==str2.charAt(j-1)) {//由于c[][]的0行0列没有使用，c[][]的第i行元素对应str1的第i-1个元素				
					c[i][j]=c[i-1][j-1]+1;
					b[i][j]=1;  //输出公共子串时的搜索方向：对角线
				}
				else if(c[i-1][j]>c[i][j-1]||c[i-1][j]==c[i][j-1]){
					c[i][j]=c[i-1][j];
					b[i][j]=2;  //输出公共子串时的搜索方向：向上
				}
				else{
					c[i][j]=c[i][j-1];
					b[i][j]=3;  //输出公共子串时的搜索方向：向左
				}
			}
		}
		len = c[length1][length2];
	}
	
	/**
	 * 递归打印最长公共子序列
	 * @param i
	 * @param j
	 */
	private static void PrintLCS(int i, int j) {
		if(i==0 || j==0) return ;
		if(b[i][j]==1){
			PrintLCS(i-1, j-1);//从后面开始递归，所以要先递归到子串的前面，然后从前往后开始输出子串
			System.out.print(str1.charAt(i-1));
		}
		else if(b[i][j]==2)	PrintLCS(i-1, j);
		else if(b[i][j]==3) PrintLCS(i, j-1);
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.print("请输入第一个字符串：");
		str1 = in.nextLine();
		System.out.print("请输入第二个字符串：");
		str2 = in.nextLine();
		in.close();
		length1 = str1.length();
		length2 = str2.length();
		b = new int[length1+1][length2+1];
		c = new int[length1+1][length2+1];
		LCSLength();
		
		System.out.println("最长公共子序列的长度为："+len);
		System.out.print("最长公共子序列为：");
		PrintLCS(length1,length2);
	}		
}
