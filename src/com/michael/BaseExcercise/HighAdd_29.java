package com.michael.BaseExcercise;

import java.util.Scanner;

/*
试题 基础练习 高精度加法
提交此题   评测记录  
资源限制
时间限制：1.0s   内存限制：512.0MB
问题描述
　　输入两个整数a和b，输出这两个整数的和。a和b都不超过100位。
算法描述
　　由于a和b都比较大，所以不能直接使用语言中的标准数据类型来存储。对于这种问题，一般使用数组来处理。
　　定义一个数组A，A[0]用于存储a的个位，A[1]用于存储a的十位，依此类推。同样可以用一个数组B来存储b。
　　计算c = a + b的时候，首先将A[0]与B[0]相加，如果有进位产生，则把进位（即和的十位数）存入r，把和的个位数存入C[0]，即C[0]等于(A[0]+B[0])%10。然后计算A[1]与B[1]相加，这时还应将低位进上来的值r也加起来，即C[1]应该是A[1]、B[1]和r三个数的和．如果又有进位产生，则仍可将新的进位存入到r中，和的个位存到C[1]中。依此类推，即可求出C的所有位。
　　最后将C输出即可。
输入格式
　　输入包括两行，第一行为一个非负整数a，第二行为一个非负整数b。两个整数都不超过100位，两数的最高位都不是0。
输出格式
　　输出一行，表示a + b的值。
样例输入
20100122201001221234567890
2010012220100122
样例输出
20100122203011233454668012
 */
public class HighAdd_29 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String a=sc.nextLine();
		String b=sc.nextLine();	
		sc.close();
		int alen=a.length();
		int blen=b.length();
		int[] arr=new int[alen];
		int[] brr=new int[blen];
		
		StringBuffer sb1=new StringBuffer(a);
		a=sb1.reverse().toString();
		StringBuffer sb2=new StringBuffer(b);
		b=sb2.reverse().toString();
		
		for(int i=0;i<alen;i++){
			arr[i]=Integer.parseInt(Character.toString(a.charAt(i)));
		}
		for(int i=0;i<blen;i++){
			brr[i]=Integer.parseInt(Character.toString(b.charAt(i)));
		}

		int cin=0;
		int max=Math.max(alen, blen);
		int min=Math.min(alen, blen);
		int[] maxarr;
		int[] minarr;
		if(alen>=blen){
			maxarr=arr;
			minarr=brr;
		}else{
			maxarr=brr;
			minarr=arr;
		}
		
		
		int[] sum=new int[max];
		for(int i=0;i<max;i++){
			if(i<=min-1){
				sum[i]=(maxarr[i]+minarr[i]+cin)%10;
				cin=(maxarr[i]+minarr[i]+cin)/10;
			}else{
				sum[i]=(maxarr[i]+cin)%10;			
				cin=(maxarr[i]+cin)/10;
			}
		}
		
		StringBuffer res=new StringBuffer();
		if(cin!=0){
			res.append(cin);	
		}
		for(int j=max-1;j>=0;j--){
			res.append(sum[j]);
		}
		System.out.println(res.toString());
		
	}

	
}

























