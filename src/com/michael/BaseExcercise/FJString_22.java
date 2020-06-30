package com.michael.BaseExcercise;

import java.util.Scanner;

/*
试题 基础练习 FJ的字符串
提交此题   评测记录  
资源限制
时间限制：1.0s   内存限制：512.0MB
问题描述
　　FJ在沙盘上写了这样一些字符串：
　　A1 = “A”                      
　　A2 = “ABA”				    
　　A3 = “ABACABA”
　　A4 = “ABACABADABACABA”
　　… …
　　你能找出其中的规律并写所有的数列AN吗？
输入格式
　　仅有一个数：N ≤ 26。
输出格式
　　请输出相应的字符串AN，以一个换行符结束。输出中不得含有多余的空格或换行、回车符。
样例输入
3
样例输出
ABACABA
 */
/*
　　A1 = “1”                      
　　A2 = “121”				    
　　A3 = “1213121”
　　A4 = “121312141213121”
 */

public class FJString_22 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		sc.close();
		String[] str=new String[]{"","A","B","C","D","E","F","G","H","I","J","K","L","M","N",
				"O","P","Q","R","S","T","U","V","W","X","Y","Z"};
		String[] s=new String[n+1];
		for(int i=1;i<=n;i++){
			if(i==1){
				s[i]=str[1];
			}else{
				s[i]=s[i-1]+str[i]+s[i-1];
			}
		}
		System.out.println(s[n]);		
	}
}




















