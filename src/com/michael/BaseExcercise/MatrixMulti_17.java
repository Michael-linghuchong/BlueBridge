package com.michael.BaseExcercise;

import java.util.Scanner;

/*
试题 基础练习 矩阵乘法  
资源限制
时间限制：1.0s   内存限制：512.0MB
问题描述
　　给定一个N阶矩阵A，输出A的M次幂（M是非负整数）
　　例如：
　　A =
　　1 2
　　3 4
　　A的2次幂
　　7 10
　　15 22
输入格式
　　第一行是一个正整数N、M（1<=N<=30, 0<=M<=5），表示矩阵A的阶数和要求的幂数
　　接下来N行，每行N个绝对值不超过10的非负整数，描述矩阵A的值
输出格式
　　输出共N行，每行N个整数，表示A的M次幂所对应的矩阵。相邻的数之间用一个空格隔开
样例输入
2 2
1 2
3 4
样例输出
7 10
15 22
 */
/*
注意：矩阵的0次方
 */

public class MatrixMulti_17 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int m=sc.nextInt();
		int[][] arr=new int[n][n];
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				arr[i][j]=sc.nextInt();
			}
		}
		sc.close();
		int[][] temp=arr;
		
		if(m>0){
			for(int i=1;i<m;i++){
				temp=multi(temp,arr);
			}
		}else{
			for(int i=0;i<n;i++){
				for(int j=0;j<n;j++){
					if(i==j){
						temp[i][j]=1;
					}else{
						temp[i][j]=0;
					}
				}
			}
		}
		print(temp);
	}
	static int[][] multi(int[][] arr,int[][] arr2){
		int m=arr[0].length;
		int[][] temp=new int[m][m];
		for(int i=0;i<m;i++){
			for(int k=0;k<m;k++){
				for(int j=0;j<m;j++){
					temp[i][k]+=arr[i][j]*arr2[j][k];
				}	
			}
		}
		return temp;	
	}
	
	static void print(int[][] arr){
		int len=arr[0].length;
		for(int i=0;i<len;i++){
			for(int j=0;j<len;j++){
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
	}
}




















