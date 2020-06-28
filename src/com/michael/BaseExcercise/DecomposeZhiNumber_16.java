package com.michael.BaseExcercise;

import java.util.ArrayList;
import java.util.Scanner;

/*
试题 基础练习 分解质因数
问题描述
　　求出区间[a,b]中所有整数的质因数分解。
输入格式
　　输入两个整数a，b。
输出格式
　　每行输出一个数的分解，形如k=a1*a2*a3...(a1<=a2<=a3...，k也是从小到大的)(具体可看样例)
样例输入
3 10
样例输出
3=3
4=2*2
5=5
6=2*3
7=7
8=2*2*2
9=3*3
10=2*5
提示
　　先筛出所有素数，然后再分解。
数据规模和约定
　　2<=a<=b<=10000
 */

/*
使用回溯的方法
 */

public class DecomposeZhiNumber_16 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		sc.close();
		boolean flag = true;
		ArrayList<Integer> list = new ArrayList<Integer>();

		// 找到[2,b]之间的素数
		for (int i = 2; i <= b; i++) {
			for (int j = 2; j < i; j++) {
				if (i % j == 0) {
					flag = false;
					break;
				}
			}
			if (flag) {
				list.add(i);
			}
			flag = true;
		}

		// 把素数放到数组中
		int[] arr = new int[list.size()];
		for (int i = 0; i < list.size(); i++) {
			arr[i] = list.get(i);
		}

		for (int i = a; i <= b; i++) {
			int temp = i;
			System.out.print(i + "=");
			// 第二层循环,计数器自增放在循环体内，原因见思路
			for (int j = 0; j < arr.length;) {
				if (temp % arr[j] == 0) {
					temp /= arr[j];
					System.out.print(arr[j]);
					// 判断是否是最后一个素数因子
					if (temp != 1) {
						System.out.print("*");
					}else if(temp==1){
						break;
					}
				} else {
					j++;
				}
			}
			System.out.println();
		}
	}

}
