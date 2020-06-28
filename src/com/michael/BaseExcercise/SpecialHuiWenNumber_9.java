package com.michael.BaseExcercise;

import java.util.Scanner;

/*
资源限制
时间限制：1.0s   内存限制：512.0MB
问题描述
　　123321是一个非常特殊的数，它从左边读和从右边读是一样的。
　　输入一个正整数n， 编程求所有这样的五位和六位十进制数，满足各位数字之和等于n 。
输入格式
　　输入一行，包含一个正整数n。
输出格式
　　按从小到大的顺序输出满足条件的整数，每个整数占一行。
样例输入
52
样例输出
899998
989989
998899
数据规模和约定
　　1<=n<=54。
 */
public class SpecialHuiWenNumber_9 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		sc.close();
		int[] arr;
		for(int i=10000;i<1000000;i++){
			arr=toArray(i);
			if(arr.length==5){
				if(arr[0]==arr[4]&&arr[1]==arr[3]){
					if(arraySum(arr)==n){
						System.out.println(i);
					}
				}
			}
			if(arr.length==6){
				if(arr[0]==arr[5] && arr[1]==arr[4] && arr[2]==arr[3]){
					if(arraySum(arr)==n){
						System.out.println(i);
					}
				}
			}			
		}
	}
	static int[] toArray(int num){
		String str=Integer.toString(num);
		int len=str.length();
		int[] arr=new int[len];
		for(int i=0;i<len;i++){
			Character ch=str.charAt(i);
			arr[i]=Integer.parseInt(ch.toString());
		}
		return arr;
	}
	
	static int arraySum(int[] a){
		int sum=0;
		for(int i=0;i<a.length;i++){
			sum+=a[i];
		}
		return sum;
	}
	
}











