package com.michael.BaseExcercise;

import java.util.Scanner;

/*
试题 基础练习 Sine之舞
提交此题   评测记录  
资源限制
时间限制：1.0s   内存限制：512.0MB
问题描述
　　最近FJ为他的奶牛们开设了数学分析课，FJ知道若要学好这门课，必须有一个好的三角函数基本功。所以他准备和奶牛们做一个“Sine之舞”的游戏，寓教于乐，提高奶牛们的计算能力。
　　不妨设
　　An=sin(1–sin(2+sin(3–sin(4+...sin(n))...)
　　Sn=(...(A1+n)A2+n-1)A3+...+2)An+1
　　FJ想让奶牛们计算Sn的值，请你帮助FJ打印出Sn的完整表达式，以方便奶牛们做题。
输入格式
　　仅有一个数：N<201。
输出格式
　　请输出相应的表达式Sn，以一个换行符结束。输出中不得含有多余的空格或换行、回车符。
样例输入
3
样例输出
((sin(1)+3)sin(1–sin(2))+2)sin(1–sin(2+sin(3)))+1
 */
public class SineDance_21 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.close();
		String[] str = new String[n];
		StringBuffer sb;
		for (int i = 1; i <= n; i++) {
			sb = new StringBuffer();
			for (int j = 1; j <= i; j++) {
				sb.append("sin("+j);
				if(j!=i){
					if (j % 2 != 0) {// 奇数3次
						sb.append("-");
					} else {// 偶数次
						sb.append("+");
					}
				}
				
			}
			for(int k=1;k<=i;k++){//An后面就有n个括号
				sb.append(")");
			}
			str[i-1]=sb.toString();		
		}
		
//		for(String temp:str){
//			System.out.println(temp);
//		}
		sb=new StringBuffer();
		
		for(int i=1;i<=n-1;i++){
			sb.append("(");
		}
		for(int i=0;i<n;i++){
			sb.append(str[i]+"+"+(n-i));
			if(i!=(n-1)){
				sb.append(")");
			}
		}
		System.out.println(sb.toString());
	}
}










