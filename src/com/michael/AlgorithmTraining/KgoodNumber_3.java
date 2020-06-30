package com.michael.AlgorithmTraining;

import java.util.Scanner;

/*
试题 算法训练 K好数
     
资源限制
时间限制：1.0s   内存限制：256.0MB
问题描述
如果一个自然数N的K进制表示中任意的相邻的两位都不是相邻的数字，那么我们就说这个数是K好数。
求L位K进制数中K好数的数目。例如K = 4，L = 2的时候，所有K好数为11、13、20、22、30、31、33 共7个。
由于这个数目很大，请你输出它对1000000007取模后的值。

输入格式
输入包含两个正整数，K和L。

输出格式
输出一个整数，表示答案对1000000007取模后的值。
样例输入
4 2
样例输出
7
数据规模与约定
对于30%的数据，KL <= 106；

对于50%的数据，K <= 16， L <= 10；

对于100%的数据，1 <= K,L <= 100。
 */

/*
解释下 对于 4进制的两位数有：1 2 3 (11 12 13 20 21 22 23 30 31 32 33) 100 ....
11 其中1和1不是相邻的
13 其中1和3不是相邻的

https://blog.csdn.net/myszpl/article/details/104099991


 */
public class KgoodNumber_3 {
	public static void main(String[] args) {
		int k,L,i,j,a,count=0;
		Scanner reader=new Scanner(System.in);
		k=reader.nextInt();//k进制的L位数
		L=reader.nextInt();	
		reader.close();
		int arr[][]=new int[L+1][k];// L就是 1 2 3 ....L(忽略0)  k就是：0 1 2....(k-1)
		
		for(j=0;j<k;j++){
			arr[1][j]=1;  
		}
			
		for(i=2;i<=L;i++) {
			for(j=0;j<k;j++) {
				for(a=0;a<k;a++) {
					if(a!=j-1 && a!=j+1) {
						arr[i][j]+=arr[i-1][a];
						arr[i][j]%=1000000007;
					}
						
				}
			}
		}
		
		for(i=1;i<k;i++) {
			count+=arr[L][i];
			count%=1000000007;
		}
			
		System.out.print(count);
	}
}



















