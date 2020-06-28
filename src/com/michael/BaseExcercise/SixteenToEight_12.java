package com.michael.BaseExcercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
资源限制
时间限制：1.0s   内存限制：512.0MB
问题描述
　　给定n个十六进制正整数，输出它们对应的八进制数。

输入格式
　　输入的第一行为一个正整数n （1<=n<=10）。
　　接下来n行，每行一个由0~9、大写字母A~F组成的字符串，表示要转换的十六进制正整数，每个十六进制数长度不超过100000。

输出格式
　　输出n行，每行为输入对应的八进制正整数。

　　【注意】
　　输入的十六进制数不会有前导0，比如012A。
　　输出的八进制数也不能有前导0。

样例输入
　　2
　　39
　　123ABC

样例输出
　　71
　　4435274

　　【提示】
　　先将十六进制数转换成某进制数，再由某进制数转换成八进制。
 */
public class SixteenToEight_12 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String[] s = new String[n];
		for (int i = 0; i < n; i++) {
			s[i] = sc.next();
		}
		sc.close();

		
		//用来保存每个二进制字符串
		List<String> list = new ArrayList<String>();

		// 1、16进制的字符串--->字符数组--->每个字符转为int--->在转为2进制
		for (int i = 0; i < n; i++) {
			char[] ch = s[i].toCharArray();
			StringBuffer sb = new StringBuffer();
			for (int j = 0; j < ch.length; j++) {
				Character c = ch[j];
				int num = Integer.parseInt(c.toString(), 16);
				String temp = Integer.toBinaryString(num);
				if (temp.length() != 4) {
					if (temp.length() == 3) {
						temp = "0" + temp;
					} else if (temp.length() == 2) {
						temp = "00" + temp;
					} else if (temp.length() == 1) {
						temp = "000" + temp;
					}
				}
				sb.append(temp);
			}

			list.add(sb.toString());
		}

		//遍历list中的每个二进制的字符串
		for (String dest : list) {
			StringBuffer sb2 = new StringBuffer();
			int len = dest.length();
			// 不足的前面添加0
			if ((len % 3) == 2) {
				dest = "0" + dest;
			} else if (len % 3 == 1) {
				dest = "00" + dest;
			}

			// 二进制转为8进制
			for (int i = 0; i < dest.length(); i += 3) {
				int num2 = Integer.parseInt(dest.substring(i, i + 3), 2);
				sb2.append(Integer.toOctalString(num2));
			}
			
			//去掉前面的0
			if(sb2.toString().charAt(0)=='0'){
				System.out.println(sb2.toString().substring(1));
			}else{
				System.out.println(sb2.toString());
			}
			
		}

	}

}
