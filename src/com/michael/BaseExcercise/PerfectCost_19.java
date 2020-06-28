package com.michael.BaseExcercise;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/*
试题 基础练习 完美的代价
     
资源限制
时间限制：1.0s   内存限制：512.0MB
问题描述
　　回文串，是一种特殊的字符串，它从左往右读和从右往左读是一样的。小龙龙认为回文串才是完美的。现在给你一个串，它不一定是回文的，请你计算最少的交换次数使得该串变成一个完美的回文串。
　　（*）交换的定义是：交换两个相邻的字符（*）
　　例如mamad
　　第一次交换 ad : mamda
　　第二次交换 md : madma
　　第三次交换 ma : madam (回文！完美！)
输入格式
　　第一行是一个整数N，表示接下来的字符串的长度(N <= 8000)
　　第二行是一个字符串，长度为N.只包含小写字母
输出格式
　　如果可能，输出最少的交换次数。
　　否则输出Impossible
样例输入
5
mamad
样例输出
3
 */
/*
https://blog.csdn.net/qq_40605470/article/details/79268979
https://blog.csdn.net/u011506951/article/details/26382569
首先先明确Impossible的情况：
一：长度为奇数的情况，如果字符串中存在不止一个字符的出现次数为1
二：长度为偶数的情况，如果字符串中存在出现次数为一次的字符
要知道这道题要求的只是最少的交换次数，而不是求出交换后的回文串，所以我们可以模拟交换的过程。
假设第一个字符是正确的，那么从后往前找与这个字符一致的，将它交换至尾部，此时n–1 (因为接下来的判断已经不涉及最后一个字符了)
以此类推。
比如：mamad
第一次：maadm 找到与m相同的放在最后面   2次交换  长度减1，此时的最后是d
第二次：madam 找到与a相同的放在最后面   1次交换

总共3次

*/

public class PerfectCost_19 {
	
	private static int count=0;
	private static char[] ch;
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		ch=new char[n];
		String str=sc.next();
		ch=str.toCharArray();
		sc.close();
		
		//1、首先先明确Impossible的情况
		HashMap<Character, Integer> m=new HashMap<>();
		
		for (int i = 0; i < n; i++) {
			Integer temp = m.get(ch[i]);
			if (temp == null) {
				m.put(ch[i], 1);
			} else {
				m.put(ch[i], temp+1);
			}
		}
		
		int len=0;
		for(Map.Entry<Character, Integer> entry:m.entrySet()){
			if(entry.getValue()==1){
				len++;
			}
		}
		
		if (n % 2 != 0) {
			if(len>1){
				System.out.println("Impossible");
				return;
			}
		} else {
			if(len>0){
				System.out.println("Impossible");
				return;
			}
		}
		
		//2、假设第一个字符是正确的，那么从后往前找与这个字符一致的，将它交换至尾部，此时n–1 (因为接下来的判断已经不涉及最后一个字符了)以此类推。
//		change(ch);
		change2(ch);
		System.out.println(Arrays.toString(ch));
		System.out.println(count);		
	}
	
	
	
	
	static void change(char[] ch){
		int left=0;  
		int mid=(ch.length-1)/2;
		int right=ch.length-1;
		int i;
		boolean flag=true;
		
		while(left<mid){
			flag=true;
			if(ch[left]!=ch[right]){ //如果是相等的就没有必要交换
				i=left+1;
				while(ch[left]!=ch[i]){ //一直向右边搜索，直到扎到 ch[left]==ch[i]
					i++;//一直要找到right所指的位置
					if(i>right){  //如果i==right 还能进入循环说明当前所指的left是奇数的，或者单次，就先把他的位置记录下，让lef向后走一步
						
						adjust(left, mid);
						flag=false;
						
						if(check(ch)){
							return;
						}
						break;
					}
				}				
				
				if(i<right){
					adjust(i, right);//需要交换 
				}
				
				if(check(ch)){
					return;
				}
			}
			
			if(flag){
				left++;
				right--;	
			}
				
		}
		
		
	}
	
	static boolean check(char[] ch){ //每次调整之后判断下是否是回文串了
		for(int i=0,j=ch.length-1;i<ch.length;i++,j--){
			if(ch[i]!=ch[j]){
				return false;
			}
		}
		return true;
	}
	
	static void adjust(int start,int end){
		char temp;//保存临时值
		for(int j=start;j<end;j++){ //需要交换
			temp=ch[j];
			ch[j]=ch[j+1];
			ch[j+1]=temp;
			count++;//交换次数加1
		}
	}
	
	static void change2(char[] ch){
		int left=0;  
		int mid=(ch.length-1)/2;
		int right=ch.length-1;
		int i;
		int odd=-1;
		boolean flag=true;
		
		while(left<mid){
			flag=true;
			if(ch[left]!=ch[right]){ //如果是相等的就没有必要交换
				i=left+1;
				while(ch[left]!=ch[i]){ //一直向右边搜索，直到扎到 ch[left]==ch[i]
					i++;//一直要找到right所指的位置
					if(i>right){  //如果i==right 还能进入循环说明当前所指的left是奇数的，或者单次，就先把他的位置记录下，让left向后走一步
						
						odd=left;
						left++;
						flag=false;
						
						if(check(ch)){
							return;
						}
						break;
					}
				}				
				
				if(i<right){
					adjust(i, right);//需要交换 
				}
				
				if(check(ch)){
					return;
				}
			}
			
			if(flag){
				left++;
				right--;	
			}
				
		}
		
		if(odd!=-1){
			adjust(odd, mid);
		}
		
	}
	
	
	
}



















































