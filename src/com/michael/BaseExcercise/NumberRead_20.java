package com.michael.BaseExcercise;

import java.util.Scanner;

/*
试题 基础练习 数的读法
     
资源限制
时间限制：1.0s   内存限制：512.0MB
问题描述
　　Tom教授正在给研究生讲授一门关于基因的课程，有一件事情让他颇为头疼：一条染色体上有成千上万个碱基对，它们从0开始编号，到几百万，几千万，甚至上亿。
　　比如说，在对学生讲解第1234567009号位置上的碱基时，光看着数字是很难准确的念出来的。
　　所以，他迫切地需要一个系统，然后当他输入12 3456 7009时，会给出相应的念法：
　　十二亿三千四百五十六万七千零九
　　用汉语拼音表示为
　　shi er yi san qian si bai wu shi liu wan qi qian ling jiu
　　这样他只需要照着念就可以了。
　　你的任务是帮他设计这样一个系统：给定一个阿拉伯数字串，你帮他按照中文读写的规范转为汉语拼音字串，相邻的两个音节用一个空格符格开。
　　注意必须严格按照规范，比如说“10010”读作“yi wan ling yi shi”而不是“yi wan ling shi”，“100000”读作“shi wan”而不是“yi shi wan”，“2000”读作“er qian”而不是“liang qian”。
输入格式
　　有一个数字串，数值大小不超过2,000,000,000。
输出格式
　　是一个由小写英文字母，逗号和空格组成的字符串，表示该数的英文读法。
样例输入
1234567009
样例输出
shi er yi san qian si bai wu shi liu wan qi qian ling jiu
 */
public class NumberRead_20 {
	static StringBuffer sb=new StringBuffer();//其实类属性默认就是static的可以不用加的
	static String[] number=new String[]{"ling","yi","er","san","si","wu","liu","qi","ba","jiu"};
	static int  num=0;
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		sc.close();
		int[] arr=intToArray(n);
		int len=arr.length;
		int[] temp=new int[4];
		int count=0;
		int c=0;
		if(len%4!=0){
			c=len-(len/4)*4;
			for(int i=len-1,j=0;i>=0;i--,j++){//9007654321 取出来就是  12 3456 7009 
				temp[j]=arr[i];
				if(j==(c-1)){
					num=num+1;
					read4(temp, j,len,num);
					break;
				}
			}
		}
		
		for(int i=len-1-c;i>=0;i--){ //9007654321 取出来就是  12 3456 7009 
			temp[count]=arr[i];
			if(count==3){
				num=num+1;
				read4(temp,count,len,num);
				count=0;
			}else{
				count++;	
			}
		}
		
		System.out.println(sb.toString());
		
	}
	
	//四位数，四位数的读取,以及不足四位      12,(yi) 3456,(wan) 7009
	/**
	 * 
	 * @Description
	 * @author Michael-luo
	 * @date 2020年6月21日下午9:01:44
	 * @param temp  传入的4位数及以下
	 * @param count 告诉是几位数  count的取值有0 1 2 3
	 * @param len   输入的数的长度好加单位
	 * @param n     是第几次传进来
	 */
	static void read4(int[] temp,int count,int len,int n){ 
		
		int count2=count;
		for(int i=0;i<count+1;i++){
			if(temp[i]!=0){
				break;
			}else{
				count--;
			}
		}
		
		if(count2!=count){
			sb.append("ling"+" ");
		}
		
		switch(count+1){
		case 1:
			sb.append(number[temp[0]]+" ");
			break;
		case 2:
			if(temp[1]==0){
				if(temp[0]==1){
					sb.append("shi"+" ");	
				}else{
					sb.append(number[temp[0]]+" "+"shi"+" ");
				}
			}else{
				sb.append(number[temp[0]]+" "+"shi"+" "+number[temp[1]]+" ");
			}
			break;
		case 3:
			if(temp[1]==0 && temp[2]==0){
				sb.append(number[temp[0]]+" "+"bai"+" ");	
			}else if(temp[1]==0 && temp[2]!=0){
				sb.append(number[temp[0]]+" "+"bai"+" "+"ling"+" "+number[temp[2]]+" ");
			}else if(temp[1]!=0 && temp[2]==0){
				sb.append(number[temp[0]]+" "+"bai"+" "+number[temp[1]]+" "+"shi"+" ");
			}else{
				sb.append(number[temp[0]]+" "+"bai"+" "+number[temp[1]]+" "+"shi"+" "+number[temp[2]]+" ");
			}
			break;
		case 4:
			if(temp[1]==0 && temp[2]==0 && temp[3]==0){
				sb.append(number[temp[0]]+" "+"qian"+" ");
			}else if(temp[1]==0 && temp[2]==0 && temp[3]!=0){
				sb.append(number[temp[0]]+" "+"qian"+" "+"ling"+" "+number[temp[3]]+" ");
			}else if(temp[1]==0 && temp[2]!=0 && temp[3]==0){
				sb.append(number[temp[0]]+" "+"qian"+" "+"ling"+" "+number[temp[3]]+" "+"shi"+" ");
			}else if(temp[1]!=0 && temp[2]==0 && temp[3]==0){
				sb.append(number[temp[0]]+" "+"qian"+" "+number[temp[1]]+" "+"bai"+" ");
			}else{
				sb.append(number[temp[0]]+" "+"qian"+" "+number[temp[1]]+" "+"bai"+" "+number[temp[2]]+" "+"shi"+" "+number[temp[3]]+" ");
			}
			break;
		}
		
		//4位数以下
		if(len<=4){
			return;
		}else if(4<len && len<=8 && n==1){
			sb.append("wan"+" ");
			return;
		}else if(8<len && len<=10){
			if(n==1){
				sb.append("yi"+" ");
			}else if(n==2){
				sb.append("wan"+" "); 
			}
			return;
		}
		
	}
	
	//将整数放入先反转再放入数组中，方便后面取    9007654321   
	static int[] intToArray(int n){
		String str=Integer.toString(n);
		StringBuffer sb1=new StringBuffer(str);
		sb1.reverse();
		str=sb1.toString();
		int len=str.length();
		int[] arr=new int[len];
		for(int i=0;i<len;i++){
			arr[i]=Integer.parseInt(Character.toString(str.charAt(i)));
		}
		return arr;
	}
	
	static void read(int[] temp,int count){
	
	}
	
}






























