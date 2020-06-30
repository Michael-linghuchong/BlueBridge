package com.michael.BaseExcercise;

import java.util.Scanner;

/*
试题 基础练习 阶乘计算
提交此题   评测记录  
资源限制
时间限制：1.0s   内存限制：512.0MB
问题描述
　　输入一个正整数n，输出n!的值。
　　其中n!=1*2*3*…*n。
算法描述
　　n!可能很大，而计算机能表示的整数范围有限，需要使用高精度计算的方法。使用一个数组A来表示一个大整数a，A[0]表示a的个位，A[1]表示a的十位，依次类推。
　　将a乘以一个整数k变为将数组A的每一个元素都乘以k，请注意处理相应的进位。
　　首先将a设为1，然后乘2，乘3，当乘到n时，即得到了n!的值。
输入格式
　　输入包含一个正整数n，n<=1000。
输出格式
　　输出n!的准确值。
样例输入
10
样例输出
3628800
 */
public class FactorialComputing_30 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		sc.close();
		int a[]= new int[4000];
		a[0]=1;
		int r1=0;//考虑进位情况
		for(int i=2;i<=n;i++) {
			for(int j=0;j<4000;j++) {
				r1=a[j]*i+r1;
				a[j]=r1%10;  //如果发生进位将个位赋给当前位置，十位或者和百位一起加到下一次数组乘法
				r1=r1/10;   //依次类推
			}
		}
		int s=0;
		for(int i=3999;i>=0;i--) {
			if(a[i]!=0) {
				System.out.print(a[i]);  //从后往前倒排，然后判断首位不为空则输出
				s=i;   //同时记录下标
				break;
			}
		}
		for(int i=s-1;i>=0;i--) {
			System.out.print(a[i]);   //倒着输出
		}
		

	}
	
}
























