package com.michael.BaseExcercise;

import java.util.Scanner;

/*
 时间转换
资源限制
时间限制：1.0s   内存限制：512.0MB
问题描述
　　给定一个以秒为单位的时间t，要求用“<H>:<M>:<S>”的格式来表示这个时间。<H>表示时间，<M>表示分钟，而<S>表示秒，它们都是整数且没有前导的“0”。例如，若t=0，则应输出是“0:0:0”；若t=3661，则输出“1:1:1”。
输入格式
　　输入只有一行，是一个整数t（0<=t<=86399）。
输出格式
　　输出只有一行，是以“<H>:<M>:<S>”的格式所表示的时间，不包括引号。
样例输入
0
样例输出
0:0:0
样例输入
5436
样例输出
1:30:36
 */
public class TimeConversion_14 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		sc.close();
		int h=n/3600;
		int m=(n-h*3600)/60;
		int s=n-3600*h-60*m;
		System.out.println(h+":"+m+":"+s);
	}
}
