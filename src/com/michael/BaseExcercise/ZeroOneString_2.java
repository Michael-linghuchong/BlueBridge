package com.michael.BaseExcercise;

/*
时间限制：1.0s   内存限制：256.0MB
问题描述
对于长度为5位的一个01串，每一位都可能是0或1，一共有32种可能。它们的前几个是：
00000
00001
00010
00011
00100
请按从小到大的顺序输出这32种01串。
输入格式
本试题没有输入。
输出格式
输出32行，按从小到大的顺序每行一个长度为5的01串。
样例输出
00000
00001
00010
00011
<以下部分省略>
 */
/*
二进制中的原码、反码、补码
      对于有符号数而言：

      (1)二进制的最高位是符号位：0表示正数，1表示负数
      (2)正数的原码、反码、补码都一样；

      (3)负数的反码 =  它的原码符号位不变，其他位取反（0 ->1 ; 1->0 ）；

      (4)负数的补码 = 它的反码 +1；

      (5)0的反码、补码都是0；

      (6)在计算机运算的时候，都是以补码的方式来运算的；
 */
public class ZeroOneString_2 {
	public static void main(String[] args) {
		String str="";
		for(int i=0;i<32;i++){
			str=Integer.toBinaryString(i);
			switch(str.length()){
			case 1:
				System.out.println("0000"+str);
				break;
			case 2:
				System.out.println("000"+str);
				break;
			case 3:
				System.out.println("00"+str);
				break;
			case 4:
				System.out.println("0"+str);
				break;
			default:
				System.out.println(str);
				break;
			}
		}
	}
}























