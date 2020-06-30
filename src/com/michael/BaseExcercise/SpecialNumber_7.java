package com.michael.BaseExcercise;

import java.util.ArrayList;
import java.util.List;

/**
资源限制
时间限制：1.0s   内存限制：512.0MB
问题描述
　　153是一个非常特殊的数，它等于它的每位数字的立方和，即153=1*1*1+5*5*5+3*3*3。编程求所有满足这种条件的三位十进制数。
输出格式
　　按从小到大的顺序输出满足条件的三位十进制数，每个数占一行。
 * @author Michael
 *
 */
public class SpecialNumber_7 {

	public static void main(String[] args) {
		List<Integer> list=new ArrayList<>();
		int g,s,b,res;
		for(int i=100;i<1000;i++){
			b=i/100;
			s=(i-b*100)/10;
			g=i-b*100-s*10;
			res=b*b*b+s*s*s+g*g*g;
			if(res==i){
				list.add(i);
			}
		}
		for(int tmp:list){
			System.out.println(tmp);
		}
	}

}
