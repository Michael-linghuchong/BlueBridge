package com.michael.AlgorithmTraining;

import java.util.Arrays;
import java.util.Scanner;

/*
试题 算法训练 区间k大数查询
     
资源限制
时间限制：1.0s   内存限制：256.0MB
问题描述
给定一个序列，每次询问序列中第l个数到第r个数中第K大的数是哪个。

输入格式
第一行包含一个数n，表示序列长度。

第二行包含n个正整数，表示给定的序列。

第三个包含一个正整数m，表示询问个数。

接下来m行，每行三个数l,r,K，表示询问序列从左往右第l个数到第r个数中，从大往小第K大的数是哪个。序列元素从1开始标号。

输出格式
总共输出m行，每行一个数，表示询问的答案。
样例输入
5
1 2 3 4 5
2
1 5 2
2 3 2
样例输出
4
2
数据规模与约定
对于30%的数据，n,m<=100；

对于100%的数据，n,m<=1000；

保证k<=(r-l+1)，序列中的数<=106。
 */
public class IntervalBigNumberQuery_1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] origin = new int[n];
		for (int i = 0; i < n; i++) {
			origin[i]=sc.nextInt();
		}
		int m=sc.nextInt();
		int[][] find=new int[m][3];
		for(int i=0;i<m;i++){
			for(int j=0;j<3;j++){
				find[i][j]=sc.nextInt();
			}
		}
		sc.close();
		
		for(int i=0;i<m;i++){
			toQuery(find[i], origin);
		}
		
		
	}
	
	static void toQuery(int[] find,int[] origin){
		int left=find[0];
		int right=find[1];
		int aim=find[2];
		int[] temp=Arrays.copyOfRange(origin, left-1, right);// [from,to)  比如 1 5  对用数组 [0,4]
		Arrays.sort(temp);
		System.out.println(temp[temp.length-aim]);// temp.length-aim 比如  第2大 就是  5-2=3  temp[3]		
	}

}




















