package com.michael.BaseExcercise;

import java.util.Scanner;

/**
时间限制：1.0s   内存限制：256.0MB
问题描述
利用字母可以组成一些美丽的图形，下面给出了一个例子：
ABCDEFG
BABCDEF
CBABCDE
DCBABCD
EDCBABC
这是一个5行7列的图形，请找出这个图形的规律，并输出一个n行m列的图形。
输入格式
输入一行，包含两个整数n和m，分别表示你要输出的图形的行数的列数。
输出格式
输出n行，每个m个字符，为你的图形。
样例输入
5 7
样例输出
ABCDEFG
BABCDEF
CBABCDE
DCBABCD
EDCBABC
数据规模与约定
1 <= n, m <= 26
 * @author Michael
 *
 */
/*
解题：规律是第i行就是从第i个字母开始  
并且从i减到0之后就是 从0开始取数 
 */
public class AlphabetFigure_3 {
	public static void main(String[] args) {
		char[] alpha=new char[]{'A','B','C','D','E','F','G','H','I','J','K','L','M','N'
				,'O','P','Q','R','S','T','U','V','W','X','Y','Z'};
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();//行数
		int m=sc.nextInt();//列数
		sc.close();
		

		char[][] res=new char[n][m];
		
		
		for(int i=0;i<n;i++){  
			int w=0;
			for(int k=i,count=0;k>0;k--,count++){  //取每行前面的倒着排的数
				if(count>=m){ //不能大于列数
					break;
				}
				res[i][w]=alpha[k];
				w++;
			}
			for(int d=0;d<m-i;d++){ //从A顺序取的
				res[i][w]=alpha[d];
				w++;
			}
					
		}
		
		for(int i=0;i<n;i++){//打印结果
			for(int j=0;j<m;j++){
				System.out.print(res[i][j]);
			}
			System.out.println();
		}
		
	}
}












